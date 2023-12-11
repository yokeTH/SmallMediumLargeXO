package logic.chess;

import logic.game.GameLogic;
import logic.game.TeamColor;

public class LargeChess extends BaseChess{
    //Constructor
    public LargeChess(TeamColor teamColor) {
        super(teamColor, 3);
    }

    //Method
    @Override
    public boolean canPlace(int column,int row) {
        if (column >=3 || row>=3) {
            return false;
        }
        BaseChess[][] boardList = GameLogic.getInstance().getBoard().getBoardList();
        BaseChess chessInPos = boardList[row][column];
        if (chessInPos== null) {
            return true; //empty place
        } else return chessInPos.getSize() <= 2 && chessInPos.getTeamColor() != this.getTeamColor(); // if size <= 2 and different teamColor
    }

    @Override
    public void Place(int column,int row) {
        if (!canPlace(column,row)){
            return;
        }
        BaseChess[][] boardList = GameLogic.getInstance().getBoard().getBoardList();
        boardList[row][column] = this;
    }

    @Override
    public String toString() {
        return "LargeChess";
    }
}
