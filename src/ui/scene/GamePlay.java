package ui.scene;

import javafx.collections.ObservableArray;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.chess.BaseChess;
import logic.entity.Player;
import logic.game.GameLogic;
import logic.game.TeamColor;
import ui.Main;
import ui.components.*;
import ui.transition.PopTransitionController;
import ui.utils.BaseChessToUI;

public class GamePlay extends HBox {
    private static Scene sceneInstance;
    private int chessIdx = -1;
    private VBox leftPane, rightPane;

    public GamePlay(){
        this.setAlignment(Pos.CENTER);

        GameLogic.getInstance();
        GameLogic.getInstance().setPlayer1(new Player(TeamColor.BLACK, "P1"));
        GameLogic.getInstance().setPlayer2(new Player(TeamColor.WHITE, "P2"));
        GameLogic.getInstance().initGame();

        updateLayout();

    }

    public void updateLayout(){
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
        rightPane.setAlignment(Pos.TOP_LEFT);
        rightPane.setPadding(new Insets(4));

        TextButton mainMenu = new TextButton("MAIN MENU",150);
        TextButton clearBoard = new TextButton("RESET",150);
        mainMenu.setOnMouseClicked(event->{
            Main.stage.setScene(Menu.getSceneInstance());
        });
        mainMenu.setAlignment(Pos.CENTER);
        clearBoard.setOnMouseClicked(event -> {
            GameLogic.clearInstance();
            GameLogic.getInstance().setPlayer1(new Player(TeamColor.BLACK, "P1"));
            GameLogic.getInstance().setPlayer2(new Player(TeamColor.WHITE, "P2"));
//            GameLogic.getInstance().initGame();
            GameLogic.getInstance().setCurrentPlayer(GameLogic.getInstance().getPlayer1());
            System.out.println(GameLogic.getInstance().getCurrentPlayer().getBaseChessArrayList().size());
            updateGame();
            updateLayout();
        });
        clearBoard.setAlignment(Pos.CENTER);
        HBox menuWrapper = new HBox(clearBoard,mainMenu);
        menuWrapper.setAlignment(Pos.CENTER_RIGHT);

        Text turn;
        if(GameLogic.getInstance().isGameOver()){
            if(GameLogic.getInstance().getWinner() == null){
                turn = new Text("Draw");
            }else{
                turn = new Text(GameLogic.getInstance().getWinner().getName() + " in Wins.");
            }
        }else{
            turn = new Text(GameLogic.getInstance().getCurrentPlayer().getName() + "'s Turn");
        }
        turn.setFont(Font.font("Itim", 48));

        Text choose;
        if(!GameLogic.getInstance().isGameOver()){
            choose = new Text("Choose Chess :");
        }else{
            choose = new Text("");
        }
            choose.setFont(Font.font("Itim", 20));

        GridPane inventoryPane = new GridPane();
        inventoryPane.setHgap(8);
        inventoryPane.setVgap(8);
        if(!GameLogic.getInstance().isGameOver()) {
            for (int i = 0; i < GameLogic.getInstance().getCurrentPlayer().getBaseChessArrayList().size(); i++) {
                SVGViewBase n = toInventoryCell(i);
                inventoryPane.add(n, i % 3, i / 3);
            }
        }

        rightPane.getChildren().setAll(menuWrapper, turn, choose, inventoryPane);


        this.getChildren().setAll(leftPane, rightPane);
    }

    private void updateGame(){
        if(!GameLogic.getInstance().getCurrentPlayer().isPlayDone()) return;
        GameLogic.getInstance().getCurrentPlayer().setPlayDone(false);
        if(!GameLogic.getInstance().isGameOver())  GameLogic.getInstance().goToNextPlayer();
        chessIdx = -1;
    }

    private SVGViewBase toBoardCell(int i, int j){
        SVGViewBase n = BaseChessToUI.translate(GameLogic.getInstance().getBoard().getBoardList()[i][j]);
        PopTransitionController controller = new PopTransitionController(n);
        n.setStyle(
                "-fx-background-color: #7EB1DB;" +
                "-fx-background-radius: 12;"
        );
        n.setOnMouseClicked(event -> {
            controller.play();
            if(this.chessIdx != -1){
                GameLogic.getInstance().getCurrentPlayer().play(chessIdx, j, i);
                updateGame();
                updateLayout();
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
            controller.play();
            this.chessIdx = i;
            updateLayout();
        });
        return n;
    }

    public static Scene getSceneInstance(){
        if(GamePlay.sceneInstance == null){
            GamePlay.sceneInstance = new Scene(new GamePlay(), 854, 480);
        }

        return GamePlay.sceneInstance;
    }
}
