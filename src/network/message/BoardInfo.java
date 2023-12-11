package network.message;

import logic.chess.BaseChess;
import logic.entity.Board;
import logic.game.TeamColor;

import java.io.Serializable;

public class BoardInfo implements Serializable {
    private int[][] size;
    private TeamColor[][] teamColor;

    public BoardInfo(Board board){
        int rowCnt = board.getBoardList().length;
        int colCnt = board.getBoardList()[0].length;
        size = new int[rowCnt][colCnt];
        teamColor = new TeamColor[rowCnt][colCnt];
        for (int i = 0; i < rowCnt; i++) {
            for (int j = 0; j < colCnt; j++) {
                BaseChess chess = board.getBoardList()[i][j];
                if(chess == null){
                    size[i][j] = 0;
                    teamColor[i][j] = null;
                }else {
                    size[i][j] = chess.getSize();
                    teamColor[i][j] = chess.getTeamColor();
                }
            }
        }
    }

    public int[][] getSize() {
        return size;
    }

    public void setSize(int[][] size) {
        this.size = size;
    }

    public TeamColor[][] getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor[][] teamColor) {
        this.teamColor = teamColor;
    }
}
