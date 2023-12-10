package ui.scene;

import javafx.collections.ObservableArray;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.entity.Player;
import logic.game.GameLogic;
import logic.game.TeamColor;
import ui.components.*;
import ui.utils.BaseChessToUI;

public class GamePlay extends HBox {
    private static Scene sceneInstance;
    private GameLogic gameInstance;
    private int chessIdx = -1;
    private VBox leftPane, rightPane;

    public GamePlay(){

        gameInstance = GameLogic.getInstance();
        gameInstance.setPlayer1(new Player(TeamColor.BLACK, "P1"));
        gameInstance.setPlayer2(new Player(TeamColor.WHITE, "P2"));
        gameInstance.initGame();

        initLayout();
    }

    public void initLayout(){
        leftPane = new VBox();
        this.getChildren().add(leftPane);

        Text gameTitle = new Text("LargeMediumSmall XOXO");
        gameTitle.setFont(Font.font("Itim", 24));
        leftPane.getChildren().add(gameTitle);

        Pane inGameBoard = new VBox();
        for (int i = 0; i < 3; i++){
            inGameBoard.getChildren().add(new HBox());
            HBox row = (HBox) inGameBoard.getChildren().get(i);
            for (int j = 0; j<3; j++){
                SVGViewBase n = new EmptyChess();
                int finalI = i;
                int finalJ = j;
                n.setOnMouseClicked(event -> {
                    System.out.println(chessIdx);
                    if(this.chessIdx != -1){
                        gameInstance.getCurrentPlayer().play(chessIdx, finalJ, finalI);
                        update();
                    }
                });
                row.getChildren().add(n);
            }
        }
        leftPane.getChildren().add(inGameBoard);


        rightPane = new VBox();
        this.getChildren().add(rightPane);

        TextButton mainMenu = new TextButton("MAIN MENU");
        rightPane.getChildren().add(mainMenu);

        Text turn = new Text(gameInstance.getCurrentPlayer().getName() + "'s Turn");
        rightPane.getChildren().add(turn);

        Text choose = new Text("Choose Chess");
        rightPane.getChildren().add(choose);

        GridPane inventoryPane = new GridPane();
        rightPane.getChildren().add(inventoryPane);
        for (int i = 0; i < this.gameInstance.getCurrentPlayer().getBaseChessArrayList().size(); i++) {
            SVGViewBase n = BaseChessToUI.translate(this.gameInstance.getCurrentPlayer().getBaseChessArrayList().get(i));

            final int iSus = i;
            n.setOnMouseClicked(event -> {
                this.chessIdx = iSus;
                System.out.println(iSus);
            });

            inventoryPane.add(n, i%3, i/3);
        }

    }

    public void update(){
        if(!gameInstance.getCurrentPlayer().isPlayDone()){
            return;
        }
        gameInstance.goToNextPlayer();
        chessIdx = -1;
        Pane inGameBoard = new VBox();
        for (int i = 0; i < 3; i++){
            inGameBoard.getChildren().add(new HBox());
            HBox row = (HBox) inGameBoard.getChildren().get(i);
            for (int j = 0; j<3; j++){
                SVGViewBase n = BaseChessToUI.translate(gameInstance.getBoard().getBoardList()[i][j]);
                int finalI = i;
                int finalJ = j;
                n.setOnMouseClicked(event -> {
                    System.out.println(chessIdx);
                    if(this.chessIdx != -1){
                        gameInstance.getCurrentPlayer().play(chessIdx, finalJ, finalI);
                        update();
                    }
                });
                row.getChildren().add(n);
            }
        }

        GridPane inventoryPane = new GridPane();
        for (int i = 0; i < this.gameInstance.getCurrentPlayer().getBaseChessArrayList().size(); i++) {
            SVGViewBase n = BaseChessToUI.translate(this.gameInstance.getCurrentPlayer().getBaseChessArrayList().get(i));

            final int iSus = i;
            n.setOnMouseClicked(event -> {
                this.chessIdx = iSus;
                System.out.println(iSus);
            });

            inventoryPane.add(n, i%3, i/3);
        }

        Text turn = new Text(gameInstance.getCurrentPlayer().getName() + "'s Turn");

        rightPane.getChildren().set(1, turn);
        rightPane.getChildren().set(3, inventoryPane);
        leftPane.getChildren().set(1, inGameBoard);
    }

    public static Scene getSceneInstance(){
        if(GamePlay.sceneInstance == null){
            GamePlay.sceneInstance = new Scene(new GamePlay(), 854, 480);
        }

        return GamePlay.sceneInstance;
    }
}
