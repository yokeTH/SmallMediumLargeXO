package logic.chess;

import logic.game.GameLogic;
import logic.game.TeamColor;

public class LargeChess extends BaseChess implements Placeable{
    //Constructor
    public LargeChess(TeamColor teamColor) {
        super(teamColor, 3);
    }

    //Method
    @Override
    public boolean canPlace(int column,int row) {

        if (column >=3 || row>=3) {
            return false; //out of index
        }

        BaseChess[][] boardList = GameLogic.getInstance().getBoard().getBoardList();
        BaseChess baseChess = boardList[row][column];
        if (baseChess == null) {
            return true; //empty place
        } else if (baseChess.getSize()<=2 && baseChess.getTeamColor()!=this.getTeamColor()) {
            return true; // if size <= 2 and different teamColor
        }

        return false;
    }

    @Override
    public void Place(int column,int row) {
        if (!this.canPlace(column,row)){
            System.out.println("Can't place here"); //must be an exception
            return;
        }
        BaseChess[][] boardList = GameLogic.getInstance().getBoard().getBoardList();
        boardList[row][column] = this;
    }
}
