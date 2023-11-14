package logic.chess;

public class Board {
    //Field
    private BaseChess[][] boardList;
    //Constructor
    public Board(){
        this.boardList = new BaseChess[3][3];
    }
    //Method
    public boolean isBoardFull(){
        //check if the board is full to GameOver
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (boardList[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

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
        // Check rows, columns, and diagonals for a winner
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private void resetGame() {
        //for reset the game, if don't use just delete this
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                boardList[row][column]=null;
            }
        }
    }
    //Getter and Setter
    public void setBoard(BaseChess[][] boardList){
        this.boardList=boardList;
    }
    public BaseChess[][] getBoardList(){
        return this.boardList;
    }
}
