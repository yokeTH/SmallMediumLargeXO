package ui.scene;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import logic.entity.Player;
import logic.game.GameLogic;
import logic.game.TeamColor;
import network.server.Server;
import ui.Main;
import ui.components.LargeOChess;
import ui.components.LargeXChess;
import ui.components.SVGViewBase;
import ui.components.TextButton;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class CreatorWaitingRoom extends GridPane {
    private static Scene sceneInstance;
    public static Server server;
    CreatorWaitingRoom(String playerName, TeamColor teamColor) throws UnknownHostException {
        GameLogic.getInstance().setPlayer1(new Player(teamColor, playerName));
        server = new Server();
//        server.start(teamColor, playerName);
        Thread serverThread = new Thread(() -> server.start(teamColor, playerName));
        serverThread.setDaemon(true); // Mark as daemon thread
        serverThread.start();

        TextButton backButton = new TextButton("Back to Menu", 150);
        backButton.setOnMouseClicked(event -> {
            cleanup();
            Main.stage.setScene(Menu.getSceneInstance());
        });


        Text roomNameText = new Text("Player Name \"" + playerName + "\"");
        Text waitText = new Text("Waiting for Opponent...");

        Label selectColorLabel = new Label("Select Color : ");
        SVGViewBase team = (teamColor == TeamColor.BLACK)? new LargeXChess(72) : new LargeOChess(72);

        this.setAlignment(Pos.CENTER);

        this.add(roomNameText, 0,0,2,1);
        // Update to show the actual network IP instead of localhost
        String serverIP = server.getLocalIPAddress();
        Text roomCodeText = new Text("Room Address: " + serverIP);
        this.add(roomCodeText, 0,1,2,1);
        this.add(waitText, 0, 2, 2, 1);
        this.add(selectColorLabel,0 , 3);
        this.add(team, 1,3);
        this.add(backButton, 0, 4, 2, 1); // Add back button to layout
    }
    public static Scene getSceneInstance(RoomRole r, String playerName, TeamColor teamColor) throws UnknownHostException {
        if(CreatorWaitingRoom.sceneInstance == null){
            Scene scene = new Scene(new CreatorWaitingRoom(playerName, teamColor), 854, 480);

            // Add window close handler
            Main.stage.setOnCloseRequest(event -> {
                if (server != null) {
                    server.stop();
                }
                Platform.exit();
                System.exit(0);
            });

            CreatorWaitingRoom.sceneInstance = scene;
        }
        return CreatorWaitingRoom.sceneInstance;
    }

    /**
     * Cleanup method responsible for proper resource management and state reset
     * Called when:
     * 1. User clicks back button
     * 2. Window is closed
     * 3. Game session ends
     */
    private void cleanup() {
        // 1. Stop the server if it exists
        if (server != null) {
            server.stop(); // Calls server's cleanup routine
            server = null; // Remove the reference to allow garbage collection
        }

        // 2. Reset game state
        GameLogic.clearInstance(); // Clear the game logic singleton

        // 3. Clear the scene instance
        sceneInstance = null; // Allow scene to be recreated if needed
    }

    private void setupBackButton() {
        TextButton backButton = new TextButton("Back to Menu", 150);
        backButton.setOnMouseClicked(event -> {
            cleanup(); // Clean everything up
            Main.stage.setScene(Menu.getSceneInstance()); // Return to menu
        });
    }

}

