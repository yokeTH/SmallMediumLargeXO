package logic.chess;

import logic.game.TeamColor;

public class Board {
    //Field
    private BaseChess[][] boardList;
    //Constructor
    public Board(){
        setBoardList(new BaseChess[3][3]);
    }

    //Method
    public boolean checkThreeCells (int row1,int column1, int row2,int column2, int row3,int column3){
        if (boardList[row1][column1] == null) return false;
        if (boardList[row2][column2] == null) return false;
        if (boardList[row3][column3] == null) return false;
        return boardList[row1][column1].getTeamColor() == boardList[row2][column2].getTeamColor()
                && boardList[row2][column2].getTeamColor() == boardList[row3][column3].getTeamColor();

    }
    public boolean checkRows(){
        for (int row = 0; row < 3; row++) {
            if (checkThreeCells(row,0,row,1,row,2)){
                return true;
            }
        }
        return false;
    }
    public boolean checkColumns(){
        for (int column = 0; column < 3; column++) {
            if (checkThreeCells(0,column,1,column,2,column)){
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals(){
        return checkThreeCells(0,0,1,1,2,2) ||
                checkThreeCells(0,2,1,1,2,0);
    }

    public boolean checkForWinner(){
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public void printBoard() {
        //condition is player1 is white and player2 is black
        System.out.println("------------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                String p = "";
                BaseChess b = boardList[i][j];
                if (b==null){
                    p = "      ";
                } else if (b.getClass() == LargeChess.class){
                    if (b.getTeamColor() == TeamColor.WHITE){
                        p = " 1(L) ";
                    } else { p = " 2(L) "; }
                } else if (b.getClass() == MediumChess.class){
                    if (b.getTeamColor() == TeamColor.WHITE){
                        p = " 1(M) ";
                    } else { p = " 2(M) "; }
                } else if (b.getClass() == SmallChess.class) {
                    if (b.getTeamColor() == TeamColor.WHITE) {
                        p = " 1(S) ";
                    } else { p = " 2(S) "; }
                }
                System.out.print( p + " | ");
            }
            System.out.println("\n------------------------------");
        }
    }

    //Getter and Setter
    public void setBoardList(BaseChess[][] boardList){
        this.boardList=boardList;
    }
    public BaseChess[][] getBoardList(){
        return this.boardList;
    }
}
