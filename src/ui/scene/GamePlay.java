package ui.scene;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.chess.BaseChess;
import logic.chess.LargeChess;
import logic.chess.MediumChess;
import logic.chess.SmallChess;
import logic.entity.Board;
import logic.entity.Player;
import logic.game.GameLogic;
import logic.game.TeamColor;
import network.message.Play;
import network.message.RoomInfo;
import network.server.Server;
import ui.GameMode;
import ui.Main;
import ui.components.*;
import ui.transition.PopTransitionController;
import ui.utils.BaseChessToUI;

import java.io.IOException;
import java.util.ArrayList;

public class GamePlay extends HBox {
    private static GamePlay instance;
    private static Scene sceneInstance;
    private int chessIdx = -1;
    private VBox leftPane, rightPane;
    private GameMode mode;
    private TeamColor teamColor;
    private RoomRole role;

    public GamePlay(){
        mode = GameMode.OFFLINE;
        resetGame();
    }

    public GamePlay(RoomRole role, Player p1, Player p2){
        mode = GameMode.ONLINE;
        this.role = role;
        if(role == RoomRole.CREATOR){
            this.teamColor = p1.getTeamColor();
        }
//        resetGame(p1, p2);
//        updateLayout();
    }

    private void resetGame(){
        GameLogic.clearInstance();
        GameLogic.getInstance().setPlayer1(new Player(TeamColor.BLACK, "P1"));
        GameLogic.getInstance().setPlayer2(new Player(TeamColor.WHITE, "P2"));
        GameLogic.getInstance().initGame();
        updateGame();
        updateLayout();
    }

    private void resetGame(Player p1, Player p2){
        String p1Name = p1.getName();
        TeamColor p1TeamColor = p1.getTeamColor();
        String p2Name = p2.getName();
        TeamColor p2TeamColor = p2.getTeamColor();
        GameLogic.clearInstance();
        GameLogic.getInstance().setPlayer1(new Player(p1TeamColor, p1Name));
        GameLogic.getInstance().setPlayer2(new Player(p2TeamColor, p2Name));
        if(Math.random() > 0.5){
            GameLogic.getInstance().setCurrentPlayer(GameLogic.getInstance().getPlayer1());
        }else {
            GameLogic.getInstance().setCurrentPlayer(GameLogic.getInstance().getPlayer2());
        }
        try {
            CreatorWaitingRoom.server.sendMessageToClient(CreatorWaitingRoom.server.out, new RoomInfo(GameLogic.getInstance()));
        }catch (Exception e){
            e.printStackTrace();
        }
        updateLayout();
    }

    public void updateLayout(){
        System.out.println(mode);
        this.setAlignment(Pos.CENTER);

        // Set space for left and right pane
        this.setSpacing(10);

        // ====== LEFT =======
        leftPane = new VBox();
        leftPane.setAlignment(Pos.CENTER);

        GridPane inGameBoard = new GridPane();
        inGameBoard.setHgap(8);
        inGameBoard.setVgap(8);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j<3; j++){
                SVGViewBase n = toBoardCell(i,j);
                inGameBoard.add(n, j, i);
            }
        }

        leftPane.getChildren().setAll(inGameBoard);

        // ====== RIGHT ======
        rightPane = new VBox();
        rightPane.setMinWidth(400);
        rightPane.setAlignment(Pos.TOP_LEFT);
        rightPane.setPadding(new Insets(4));

        TextButton mainMenu = new TextButton("MAIN MENU",150);
        TextButton clearBoard = new TextButton("RESET",150);

        mainMenu.setOnMouseClicked(event->{
            Main.stage.setScene(Menu.getSceneInstance());
        });
        mainMenu.setAlignment(Pos.CENTER);


        if(mode == GameMode.OFFLINE){
            clearBoard.setOnMouseClicked(event -> {
                resetGame();
            });

        }else if(role == RoomRole.CREATOR) {
            clearBoard.setOnMouseClicked(event -> {
                resetGame(GameLogic.getInstance().getPlayer1(), GameLogic.getInstance().getPlayer2());
            });
        }

        clearBoard.setAlignment(Pos.CENTER);
        HBox menuWrapper = new HBox();
        if(role != RoomRole.JOINER){
            menuWrapper.getChildren().add(clearBoard);
        }
        menuWrapper.getChildren().add(mainMenu);
        menuWrapper.setAlignment(Pos.CENTER_RIGHT);
        menuWrapper.setSpacing(8);

        Text turn;
        if(GameLogic.getInstance().isGameOver()){
            if(GameLogic.getInstance().getWinner() == null){
                turn = new Text("Draw");
                turn.setFont(Font.font("Itim", 48));

            }else{
                turn = new Text(GameLogic.getInstance().getWinner().getName() + " in Wins.");
                turn.setFont(Font.font("Itim", 48));

            }
        }else{
            turn = new Text(GameLogic.getInstance().getCurrentPlayer().getName() + "'s Turn");
            turn.setFont(Font.font("Itim", 48));
        }

        Text choose;
        if(!GameLogic.getInstance().isGameOver()){
            choose = new Text("Choose Chess :");
        }else{
            choose = new Text("");
        }
            choose.setFont(Font.font("Itim", 20));

        Rectangle spacing = new Rectangle();
        spacing.setHeight(16);

        GridPane inventoryPane = new GridPane();
        inventoryPane.setHgap(8);
        inventoryPane.setVgap(8);
        if(!GameLogic.getInstance().isGameOver()) {
            if(mode == GameMode.OFFLINE){
                for (int i = 0; i < GameLogic.getInstance().getCurrentPlayer().getBaseChessArrayList().size(); i++) {
                    SVGViewBase n = toInventoryCell(i);
                    inventoryPane.add(n, i % 3, i / 3);
                }
            }else {
                System.out.println(role + ":" + teamColor + ":" + GameLogic.getInstance().getCurrentPlayer().getTeamColor());
                if(teamColor == GameLogic.getInstance().getCurrentPlayer().getTeamColor()){
                    for (int i = 0; i < GameLogic.getInstance().getCurrentPlayer().getBaseChessArrayList().size(); i++) {
                        SVGViewBase n = toInventoryCell(i);
                        inventoryPane.add(n, i % 3, i / 3);
                    }
                }
            }

        }

        rightPane.getChildren().setAll(menuWrapper, turn, choose, spacing, inventoryPane);

        Platform.runLater(()-> {
                GamePlay.getInstance().getChildren().setAll(leftPane, rightPane);
        });
    }

    private void updateGame(){
        if(!GameLogic.getInstance().getCurrentPlayer().isPlayDone()) return;
        GameLogic.getInstance().getCurrentPlayer().setPlayDone(false);
        if(!GameLogic.getInstance().isGameOver())  GameLogic.getInstance().goToNextPlayer();
        chessIdx = -1;
    }

    public void updateClientGameInstance(RoomInfo roomInfo){
        chessIdx = -1;
        if(role == RoomRole.CREATOR){
            teamColor = roomInfo.getPlayerInfo1().getTeamColor();
        }else{
            teamColor = roomInfo.getPlayerInfo2().getTeamColor();
        }


        // set board
        BaseChess[][] baseChess = new BaseChess[roomInfo.getBoardInfo().getSize().length][roomInfo.getBoardInfo().getSize()[0].length];
        for (int i = 0; i < baseChess.length; i++) {
            for (int j = 0; j < baseChess[i].length; j++) {
                int size = roomInfo.getBoardInfo().getSize()[i][j];
                TeamColor color = roomInfo.getBoardInfo().getTeamColor()[i][j];
                switch (size){
                    case 3:
                        baseChess[i][j] = new LargeChess(color);
                        break;
                    case 2:
                        baseChess[i][j] = new MediumChess(color);
                        break;
                    case 1:
                        baseChess[i][j] = new SmallChess(color);
                        break;
                    default:
                        baseChess[i][j] = null;
                        break;
                }
            }
        }
        Board board = new Board();
        board.setBoardList(baseChess);
        GameLogic.getInstance().setBoard(board);


        // SetPlayer1 hand
        if(GameLogic.getInstance().getPlayer1() == null){
            GameLogic.getInstance().setPlayer1(new Player(roomInfo.getPlayerInfo1().getTeamColor(), roomInfo.getPlayerInfo1().getName()));
        }
        GameLogic.getInstance().getPlayer1().setBaseChessArrayList(new ArrayList<>());
        for (int i = 0; i < roomInfo.getPlayerInfo1().getInventory().size(); i++) {
            switch (roomInfo.getPlayerInfo1().getInventory().get(i)){
                case Large -> GameLogic.getInstance().getPlayer1().getBaseChessArrayList().add(new LargeChess(GameLogic.getInstance().getPlayer1().getTeamColor()));
                case Medium -> GameLogic.getInstance().getPlayer1().getBaseChessArrayList().add(new MediumChess(GameLogic.getInstance().getPlayer1().getTeamColor()));
                case Small -> GameLogic.getInstance().getPlayer1().getBaseChessArrayList().add(new SmallChess(GameLogic.getInstance().getPlayer1().getTeamColor()));
            }
        }

        //SetPlayer2 hand
        if(GameLogic.getInstance().getPlayer2() == null){
            GameLogic.getInstance().setPlayer2(new Player(roomInfo.getPlayerInfo2().getTeamColor(), roomInfo.getPlayerInfo2().getName()));
        }
        GameLogic.getInstance().getPlayer2().setBaseChessArrayList(new ArrayList<>());
        for (int i = 0; i < roomInfo.getPlayerInfo2().getInventory().size(); i++) {
            switch (roomInfo.getPlayerInfo2().getInventory().get(i)){
                case Large -> GameLogic.getInstance().getPlayer2().getBaseChessArrayList().add(new LargeChess(GameLogic.getInstance().getPlayer2().getTeamColor()));
                case Medium -> GameLogic.getInstance().getPlayer2().getBaseChessArrayList().add(new MediumChess(GameLogic.getInstance().getPlayer2().getTeamColor()));
                case Small -> GameLogic.getInstance().getPlayer2().getBaseChessArrayList().add(new SmallChess(GameLogic.getInstance().getPlayer2().getTeamColor()));
                default -> {}
            }
        }
        if (roomInfo.getCurrentPlayer().getTeamColor() == GameLogic.getInstance().getPlayer1().getTeamColor()){
            GameLogic.getInstance().setCurrentPlayer(GameLogic.getInstance().getPlayer1());
        }else if(roomInfo.getCurrentPlayer().getTeamColor() == GameLogic.getInstance().getPlayer2().getTeamColor()) {
            GameLogic.getInstance().setCurrentPlayer(GameLogic.getInstance().getPlayer2());
        }

        updateLayout();
    }

    private SVGViewBase toBoardCell(int i, int j){
        SVGViewBase n = BaseChessToUI.translate(GameLogic.getInstance().getBoard().getBoardList()[i][j]);
        PopTransitionController controller = new PopTransitionController(n);
        n.setStyle(
                "-fx-background-color: #7EB1DB;" +
                "-fx-background-radius: 12;"
        );
        n.setOnMouseClicked(event -> {
            controller.playAnimation();
            controller.playSound();
            if(this.chessIdx != -1){
                if(mode == GameMode.OFFLINE){
                    GameLogic.getInstance().getCurrentPlayer().play(chessIdx, j, i);
                    updateGame();
                    updateLayout();
                }else {
                    if(role == RoomRole.CREATOR){
                        GameLogic.getInstance().getCurrentPlayer().play(chessIdx, j, i);
                        updateGame();
                        updateLayout();
                        try {
                            CreatorWaitingRoom.server.sendMessageToClient(CreatorWaitingRoom.server.out, new RoomInfo(GameLogic.getInstance()));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        try {
                            JoinerWaitingRoom.client.send(new Play(chessIdx, j,i));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        return n;
    }

    private SVGViewBase toInventoryCell(int i){
        SVGViewBase n = BaseChessToUI.translate(GameLogic.getInstance().getCurrentPlayer().getBaseChessArrayList().get(i));
        PopTransitionController controller = new PopTransitionController(n);
        if(i == chessIdx){
            n.setStyle(
                    "-fx-background-color: #DBEFF4;" +
                    "-fx-background-radius: 12;"
            );
        }
        n.setOnMouseClicked(event -> {
            controller.playAnimation();
            this.chessIdx = i;
            updateLayout();
        });
        return n;
    }

    public static Scene getSceneInstance(){
        if(GamePlay.sceneInstance == null){
            GamePlay.sceneInstance = new Scene(GamePlay.getInstance(), 854, 480);
        }

        return GamePlay.sceneInstance;
    }

    public static Scene getSceneInstance(RoomRole roomRole, Player p1, Player p2){
        if(GamePlay.sceneInstance == null){
            GamePlay.sceneInstance = new Scene(GamePlay.getInstance(roomRole, p1, p2), 854, 480);
        }
        return GamePlay.sceneInstance;
    }

    public static GamePlay getInstance(){
        if(instance == null){
            GamePlay.instance = new GamePlay();
        }
        return GamePlay.instance;
    }

    public static GamePlay getInstance(RoomRole role, Player p1, Player p2){
        if(instance == null){
            GamePlay.instance = new GamePlay(role, p1, p2);
        }
        return GamePlay.instance;
    }
}
