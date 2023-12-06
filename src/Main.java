import logic.chess.BaseChess;
import logic.chess.Board;
import logic.entity.Player;
import logic.game.GameLogic;
import logic.game.TeamColor;

import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        //example main of the game
        GameLogic gameInstance = GameLogic.getInstance();

        System.out.println("-----------------------------------");
        System.out.println("Welcome to SmallMediumLarge XO Game");
        System.out.println("-----------------------------------");

        Scanner s = new Scanner(System.in);

        System.out.println("Enter Player1 name :");
        String player1Name = s.nextLine();
        gameInstance.setPlayer1(new Player(TeamColor.WHITE,player1Name));

        System.out.println("Enter Player2 name :");
        String player2Name = s.nextLine();
        gameInstance.setPlayer2(new Player(TeamColor.BLACK,player2Name));

        Board board = gameInstance.getBoard();

        gameInstance.initGame();
        System.out.println("------GAME START------");
        while (true){

            System.out.println("This is the board right now.");
            board.printBoard();

            Player currentPlayer = gameInstance.getCurrentPlayer();
            String playerNum = currentPlayer.getPlayerNum();

            System.out.println("Current Player is "+currentPlayer.getName()+" (Player"+playerNum+")");

            ArrayList<BaseChess> arrayList = currentPlayer.getBaseChessArrayList();
            System.out.println("Choose chess to play");
            for (int i = 0;i<arrayList.size();i++){
                System.out.println("<"+i+"> "+ arrayList.get(i).toString());
            }

            while (!currentPlayer.isPlayDone()){
                System.out.println("Choose Chess : ");
                int chessIdx = s.nextInt();
                System.out.println("Choose Row : ");
                int rowIdx = s.nextInt();
                System.out.println("Choose Column : ");
                int columnIdx = s.nextInt();

                currentPlayer.play(chessIdx,columnIdx,rowIdx);
            }
            currentPlayer.setPlayDone(false);

            if (gameInstance.isGameOver()){
                System.out.println("------GAME OVER------");
                board.printBoard();

                playerNum = currentPlayer.getPlayerNum();

                if (gameInstance.getWinner() != null){
                    System.out.println(gameInstance.getWinner().getName()+" (Player"+playerNum+")"+" wins.");
                } else {
                    System.out.println("It's a draw.");
                }
                break;
            }
            gameInstance.goToNextPlayer();
        }
    }
}