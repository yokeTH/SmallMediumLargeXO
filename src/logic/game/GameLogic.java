package logic.game;

import logic.chess.*;

import java.util.ArrayList;

public class GameLogic {
    private Board board;
    private int currentPlayer;
    private final ArrayList<ArrayList<BaseChess>> playerHands;

    private static GameLogic instance = null;

    public GameLogic(){
        this.board = new Board();
        this.playerHands = new ArrayList<>();
        for (int i=0;i<2;i++){
            ArrayList<BaseChess> hand = new ArrayList<>();
            playerHands.add(hand);
        }
        this.currentPlayer=0;
    }

    public static GameLogic getInstance() {
        if(instance == null) {
            instance = new GameLogic();
        }
        return instance;
    }

    public static void clearInstance() {
        instance = null;
    }

    public void initGame(){
        //real game player1 and player 2 can choose TeamColor

        //case player1 is teamColor WHITE
        playerHands.get(0).add(new SmallChess(TeamColor.WHITE));
        playerHands.get(0).add(new SmallChess(TeamColor.WHITE));
        playerHands.get(0).add(new MediumChess(TeamColor.WHITE));
        playerHands.get(0).add(new MediumChess(TeamColor.WHITE));
        playerHands.get(0).add(new LargeChess(TeamColor.WHITE));
        playerHands.get(0).add(new LargeChess(TeamColor.WHITE));
        //case player2 is teamColor BLACK
        playerHands.get(1).add(new SmallChess(TeamColor.BLACK));
        playerHands.get(1).add(new SmallChess(TeamColor.BLACK));
        playerHands.get(1).add(new MediumChess(TeamColor.BLACK));
        playerHands.get(1).add(new MediumChess(TeamColor.BLACK));
        playerHands.get(1).add(new LargeChess(TeamColor.BLACK));
        playerHands.get(1).add(new LargeChess(TeamColor.BLACK));
    }

    //Getter and Setter
    public void setBoard(Board board){
        this.board = board;
    }
    public Board getBoard(){
        return board;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
