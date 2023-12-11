//package ui.scene;
//
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import logic.chess.BaseChess;
//import logic.chess.LargeChess;
//import logic.chess.MediumChess;
//import logic.chess.SmallChess;
//import logic.entity.Board;
//import logic.entity.Player;
//import logic.game.GameLogic;
//import logic.game.TeamColor;
//import network.message.Play;
//import network.message.RoomInfo;
//import ui.components.EmptyChess;
//import ui.components.SVGViewBase;
//import ui.components.TextButton;
//import ui.utils.BaseChessToUI;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class GamePlayOnline extends HBox {
//    private static Scene sceneInstance;
//    private static int chessIdx = -1;
//    private static VBox leftPane;
//    private static VBox rightPane;
//    private static RoomRole roomRole;
//    private static TeamColor teamColor;
//
//    public GamePlayOnline(RoomRole roomRole, TeamColor teamColor, String name){
//
//        GamePlayOnline.roomRole = roomRole;
//        GamePlayOnline.teamColor = teamColor;
//        GameLogic gameInstance = GameLogic.getInstance();
//
//        if(roomRole == RoomRole.CREATOR){
//            gameInstance.setPlayer1(new Player(teamColor, name));
//        }else {
//            gameInstance.setPlayer2(new Player(teamColor, name));
//        }
//        rightPane = new VBox();
//        leftPane = new VBox();
//        this.getChildren().addAll(leftPane, rightPane);
//        updateLayout();
//        gameInstance.initGame();
//    }
//
//    private static SVGViewBase getBordChessView(int i, int j) {
//        SVGViewBase n = BaseChessToUI.translate(GameLogic.getInstance().getBoard().getBoardList()[i][j]);
//        n.setOnMouseClicked(event -> {
//            System.out.println(chessIdx);
//            if(chessIdx != -1){
//                if(roomRole == RoomRole.CREATOR){
//                    GameLogic.getInstance().getCurrentPlayer().play(chessIdx, j, i);
//                    if(GameLogic.getInstance().getCurrentPlayer().isPlayDone()){
//                        GameLogic.getInstance().goToNextPlayer();
//                    }
//                    try {
//                        CreatorWaitingRoom.server.sendMessageToClient(CreatorWaitingRoom.server.out, new RoomInfo(GameLogic.getInstance()));
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }else {
//                    try {
//                        JoinerWaitingRoom.client.send(new Play(chessIdx, j,i));
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                updateLayout();
//            }
//        });
//        return n;
//    }
//
//    private static SVGViewBase getInventoryView(int i){
//        SVGViewBase n = BaseChessToUI.translate(GameLogic.getInstance().getCurrentPlayer().getBaseChessArrayList().get(i));
//        n.setOnMouseClicked(event -> {
//            chessIdx = i;
//            System.out.println(i);
//        });
//        return n;
//    }
//
//    public static void updateLayout(){
//        chessIdx = -1;
//
//        // Board
//        Pane inGameBoard = new VBox();
//        for (int i = 0; i < 3; i++){
//            inGameBoard.getChildren().add(new HBox());
//            HBox row = (HBox) inGameBoard.getChildren().get(i);
//            for (int j = 0; j<3; j++){
//                SVGViewBase n = getBordChessView(i, j);
//                row.getChildren().add(n);
//            }
//        }
//
//        // Inventory
//        GridPane inventoryPane = new GridPane();
//        System.out.println(roomRole+":"+GameLogic.getInstance().getCurrentPlayer().getTeamColor());
//        System.out.println(roomRole+":"+teamColor);
//        if (GameLogic.getInstance().getCurrentPlayer().getTeamColor() == teamColor)
//            for (int i = 0; i < GameLogic.getInstance().getCurrentPlayer().getBaseChessArrayList().size(); i++) {
//                SVGViewBase n = getInventoryView(i);
//                inventoryPane.add(n, i%3, i/3);
//            }
//
//        Text turn = new Text(GameLogic.getInstance().getCurrentPlayer().getName() + "'s Turn");
//
//        TextButton mainMenu = new TextButton("MAIN MENU");
//        Text choose = new Text("Choose Chess:");
//
//        Text gameTitle = new Text("SmallMediumLarge XOXO");
//        gameTitle.setFont(Font.font("Itim", 24));
//
//
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                rightPane.getChildren().setAll(mainMenu,turn,choose,inventoryPane);
//                leftPane.getChildren().setAll(gameTitle, inGameBoard);
//            }
//        });
//    }
//
//    public static void updateGameInstance(RoomInfo roomInfo){
//        System.out.println(roomInfo);
//        GameLogic gameInstance = GameLogic.getInstance();
//
//        BaseChess[][] baseChess = new BaseChess[roomInfo.getBoardInfo().getSize().length][roomInfo.getBoardInfo().getSize()[0].length];
//        for (int i = 0; i < baseChess.length; i++) {
//            for (int j = 0; j < baseChess[i].length; j++) {
//                int size = roomInfo.getBoardInfo().getSize()[i][j];
//                TeamColor color = roomInfo.getBoardInfo().getTeamColor()[i][j];
//                switch (size){
//                    case 3:
//                        baseChess[i][j] = new LargeChess(color);
//                        break;
//                    case 2:
//                        baseChess[i][j] = new MediumChess(color);
//                        break;
//                    case 1:
//                        baseChess[i][j] = new SmallChess(color);
//                        break;
//                    default:
//                        baseChess[i][j] = null;
//                        break;
//                }
//            }
//        }
//        Board board = new Board();
//        board.setBoardList(baseChess);
//        gameInstance.setBoard(board);
//
//        if(gameInstance.getPlayer1() == null){
//            gameInstance.setPlayer1(new Player(roomInfo.getPlayerInfo1().getTeamColor(), roomInfo.getPlayerInfo1().getName()));
//        }
//        gameInstance.getPlayer1().setBaseChessArrayList(new ArrayList<>());
//        for (int i = 0; i < roomInfo.getPlayerInfo1().getInventory().size(); i++) {
//            switch (roomInfo.getPlayerInfo1().getInventory().get(i)){
//                case Large -> gameInstance.getPlayer1().getBaseChessArrayList().add(new LargeChess(gameInstance.getPlayer1().getTeamColor()));
//                case Medium -> gameInstance.getPlayer1().getBaseChessArrayList().add(new MediumChess(gameInstance.getPlayer1().getTeamColor()));
//                case Small -> gameInstance.getPlayer1().getBaseChessArrayList().add(new SmallChess(gameInstance.getPlayer1().getTeamColor()));
//                default -> {}
//            }
//        }
//
//        if(gameInstance.getPlayer2() == null){
//            gameInstance.setPlayer2(new Player(roomInfo.getPlayerInfo2().getTeamColor(), roomInfo.getPlayerInfo2().getName()));
//        }
//        gameInstance.getPlayer2().setBaseChessArrayList(new ArrayList<>());
//        for (int i = 0; i < roomInfo.getPlayerInfo2().getInventory().size(); i++) {
//            switch (roomInfo.getPlayerInfo2().getInventory().get(i)){
//                case Large -> gameInstance.getPlayer2().getBaseChessArrayList().add(new LargeChess(gameInstance.getPlayer2().getTeamColor()));
//                case Medium -> gameInstance.getPlayer2().getBaseChessArrayList().add(new MediumChess(gameInstance.getPlayer2().getTeamColor()));
//                case Small -> gameInstance.getPlayer2().getBaseChessArrayList().add(new SmallChess(gameInstance.getPlayer2().getTeamColor()));
//                default -> {}
//            }
//        }
//
//
//        if (roomInfo.getCurrentPlayer().getTeamColor() == gameInstance.getPlayer1().getTeamColor()){
//            gameInstance.setCurrentPlayer(gameInstance.getPlayer1());
//        }else if(roomInfo.getCurrentPlayer().getTeamColor() == gameInstance.getPlayer2().getTeamColor()) {
//            gameInstance.setCurrentPlayer(gameInstance.getPlayer2());
//        }
////        gameInstance.setCurrentPlayer(new Player(roomInfo.getCurrentPlayer().getTeamColor(), roomInfo.getCurrentPlayer().getName()));
//    }
//
//    public static Scene getSceneInstance(RoomRole roomRole, TeamColor teamColor, String name){
//        if(GamePlayOnline.sceneInstance == null){
//            GamePlayOnline.sceneInstance = new Scene(new GamePlayOnline(roomRole, teamColor, name), 854, 480);
//        }
//
//        return GamePlayOnline.sceneInstance;
//    }
//}
