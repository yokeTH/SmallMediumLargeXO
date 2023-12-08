package logic.game;

import logic.entity.Board;
import logic.entity.Player;

public class GameLogic {
    private Board board;
    private Player winner;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private static GameLogic instance = null;

    public GameLogic(){
        setBoard(new Board());
        setWinner(null);
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

    public void goToNextPlayer(){
        if (getCurrentPlayer()==player1){
            setCurrentPlayer(player2);
        } else {
            setCurrentPlayer(player1);
        }
    }
    public void initGame(){
        setCurrentPlayer(player1);
    }

    public boolean isGameOver(){
        if (getBoard().checkForWinner()){
            setWinner(getCurrentPlayer());
            return true;
        }
        return (player1.haveNoChess() && player2.haveNoChess()) ||
                (player1.noPlaceableChess() && player2.noPlaceableChess());
    }

    public void setBoard(Board board){
        this.board = board;
    }
    public Board getBoard(){
        return board;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public Player getWinner() {return winner;}
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public Player getPlayer1() {return player1;}
    public void setPlayer2(Player player2) {this.player2 = player2;}
    public Player getPlayer2() {return player2;}
}
