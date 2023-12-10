package network.message;

public class Play extends MessageObject{

    private int chessIdx, column, row;

    public Play(int chessIdx,int column,int row) {
        super(MessageType.ACTION);
    }

    public int getChessIdx() {
        return chessIdx;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
