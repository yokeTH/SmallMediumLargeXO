package network.message;

import logic.entity.Board;
import logic.game.GameLogic;

public class RoomInfo extends MessageObject{
    private PlayerInfo playerInfo1;
    private PlayerInfo playerInfo2;

    private PlayerInfo currentPlayer;
    private BoardInfo boardInfo;


    public BoardInfo getBoardInfo() {
        return boardInfo;
    }

    public void setBoardInfo(Board board) {
        this.boardInfo = new BoardInfo(board);
    }

    public RoomInfo(GameLogic gameLogic){
        super(MessageType.ROOM_INFO);
        this.playerInfo1 = new PlayerInfo(gameLogic.getPlayer1());
        this.playerInfo2 = new PlayerInfo(gameLogic.getPlayer2());
        this.currentPlayer = new PlayerInfo(gameLogic.getCurrentPlayer());
        this.boardInfo = new BoardInfo(gameLogic.getBoard());
    }

    public PlayerInfo getPlayerInfo1() {
        return playerInfo1;
    }


    public void setPlayerInfo1(PlayerInfo playerInfo1) {
        this.playerInfo1 = playerInfo1;
    }

    public PlayerInfo getPlayerInfo2() {
        return playerInfo2;
    }

    public void setPlayerInfo2(PlayerInfo playerInfo2) {
        this.playerInfo2 = playerInfo2;
    }

    public PlayerInfo getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerInfo currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String toString() {
        return "RoomInfo: \n" +
                "player1=" + playerInfo1.getName() + "("+ playerInfo1.getTeamColor() +")\n" +
                "player2=" + playerInfo2.getName() + "("+ playerInfo2.getTeamColor() +")\n" +
                "current=" + currentPlayer.getName() + "("+ currentPlayer.getTeamColor() +")\n";
    }
}
