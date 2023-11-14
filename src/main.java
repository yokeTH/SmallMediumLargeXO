import logic.chess.BaseChess;
import logic.chess.Board;
import logic.chess.LargeChess;
import logic.chess.MediumChess;
import logic.game.GameLogic;
import logic.game.TeamColor;

public class main{
    public static void main(String[]args){
        //example main of the game

        GameLogic gameInstance = GameLogic.getInstance();

        BaseChess[][] boardList = gameInstance.getBoard().getBoardList();
        Board board = gameInstance.getBoard();

        boardList[0][0] = new LargeChess(TeamColor.RED);
        boardList[1][1] = new MediumChess(TeamColor.RED);
        boardList[2][2] = new MediumChess(TeamColor.RED);

        LargeChess l = new LargeChess(TeamColor.BLUE);
        l.Place(2,2);

        boolean t = board.checkForWinner();
        if (t) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }



}