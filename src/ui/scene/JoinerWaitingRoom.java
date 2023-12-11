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
import network.client.Client;
import network.message.Connect;
import network.message.MessageObject;
import network.message.RoomInfo;
import ui.Main;
import ui.components.LargeOChess;
import ui.components.LargeXChess;
import ui.components.SVGViewBase;

import java.io.IOException;

public class JoinerWaitingRoom extends GridPane {
    private static Scene sceneInstance;
    public static Client client;
    JoinerWaitingRoom(String address, String playerName) throws IOException, ClassNotFoundException {

        client = new Client();
        client.connect(address, 65301);
        client.send(new Connect(playerName));
        RoomInfo initInfo = (RoomInfo) client.receive();
        GamePlay.getInstance(RoomRole.JOINER, new Player(initInfo.getPlayerInfo1().getTeamColor(), initInfo.getPlayerInfo1().getName()), new Player(initInfo.getPlayerInfo2().getTeamColor(), initInfo.getPlayerInfo2().getName())).updateClientGameInstance(initInfo);
        Platform.runLater(() -> Main.stage.setScene(GamePlay.getSceneInstance()));
        new Thread(()->{
            MessageObject msg;
            try {
                while ((msg = (MessageObject) client.receive()) != null){
                        if (msg instanceof RoomInfo){
                            GamePlay.getInstance().updateClientGameInstance((RoomInfo) msg);
                        }
                    System.out.println("RECEIVE");
                    }
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
            }
        }).start();

        Text roomNameText = new Text("Room Name \"" + initInfo.getPlayerInfo1().getName() + "\"");

        Label selectColorLabel = new Label("Select Color : ");
        SVGViewBase team = initInfo.getPlayerInfo1().getTeamColor() == TeamColor.WHITE ? new LargeXChess(72) : new LargeOChess(72);

        this.setAlignment(Pos.CENTER);

        this.add(roomNameText, 0,0,2,1);
        Text roomCodeText = new Text("Room Code : " + address);
        this.add(roomCodeText, 0,1,2,1);
        this.add(selectColorLabel,0 , 3);
//        this.add(team, 1,3);
    }
    public static Scene getSceneInstance(String address, String playerName) throws IOException, ClassNotFoundException {
        if(JoinerWaitingRoom.sceneInstance == null){
            JoinerWaitingRoom.sceneInstance = new Scene(new JoinerWaitingRoom(address, playerName), 854, 480);
        }
        return JoinerWaitingRoom.sceneInstance;
    }
}

