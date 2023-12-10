package logic.chess;

import logic.game.GameLogic;
import logic.game.TeamColor;

public class MediumChess extends BaseChess{
    //Constructor
    public MediumChess(TeamColor teamColor) {
        super(teamColor, 2);
    }
    @Override
    public boolean canPlace(int column,int row) {
        if (column >=3 || row>=3) {
            return false; //out of index
        }
        BaseChess[][] boardList = GameLogic.getInstance().getBoard().getBoardList();
        BaseChess chessInPos = boardList[row][column];
        if (chessInPos == null) {
            return true; //empty place
        } else return chessInPos.getSize() == 1 && chessInPos.getTeamColor() != this.getTeamColor(); // if size = 1 and different teamColor
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
        return "MediumChess";
    }
}
