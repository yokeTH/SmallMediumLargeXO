package logic.chess;

import logic.game.GameLogic;
import logic.game.TeamColor;

public class SmallChess extends BaseChess{
    //Constructor
    public SmallChess(TeamColor teamColor) {
        super(teamColor, 1);
    }


    @Override
    public boolean canPlace(int column, int row) {
        if (column >=3 || row>=3) {
            return false; //out of index
        }
        BaseChess[][] boardList = GameLogic.getInstance().getBoard().getBoardList();
        BaseChess chessInPos = boardList[row][column];
        return chessInPos == null; //empty place
    }

    @Override
    public void Place(int column, int row) {
        if (!canPlace(column,row)){
            return;
        }
        BaseChess[][] boardList = GameLogic.getInstance().getBoard().getBoardList();
        boardList[row][column] = this;
    }
    @Override
    public String toString() {
        return "SmallChess";
    }
}
