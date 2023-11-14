package logic.chess;

public interface Placeable {
    boolean canPlace(int column,int row);
    void Place(int column, int row);
}
