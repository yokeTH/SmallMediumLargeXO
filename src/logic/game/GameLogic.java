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

    public boolean[][] getWinPattern(){
        boolean[][] pattern = new boolean[3][3];
        Board gameBoard = getBoard();
        if (gameBoard.checkRows()){
            for (int row=0;row<3;row++){
                if (gameBoard.checkThreeCells(row,0,row,1,row,2)){
                    pattern[row][0] = true;
                    pattern[row][1] = true;
                    pattern[row][2] = true;
                    break;
                }
            }
            return pattern;
        }
        if (gameBoard.checkColumns()){
            for (int column = 0; column < 3; column++) {
                if (gameBoard.checkThreeCells(0,column,1,column,2,column)){
                    pattern[0][column] = true;
                    pattern[1][column] = true;
                    pattern[2][column] = true;
                    break;
                }
            }
            return pattern;
        }
        if (gameBoard.checkDiagonals()){
            if (gameBoard.checkThreeCells(0,0,1,1,2,2)){
                pattern[0][0] = true;
                pattern[1][1] = true;
                pattern[2][2] = true;
                return pattern;
            }
            if (gameBoard.checkThreeCells(0,2,1,1,2,0)){
                pattern[0][2] = true;
                pattern[1][1] = true;
                pattern[2][0] = true;
                return pattern;
            }
        }
        return pattern;
    }
}
