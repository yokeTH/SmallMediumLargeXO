package network.message;

import network.server.Room;

public class RoomInfo extends MessageObject{
    private PlayerInfo playerInfo1;
    private PlayerInfo playerInfo2;

    private PlayerInfo currentPlayer;


    public RoomInfo(Room room){
        super(MessageType.ROOM_INFO);
        this.playerInfo1 = new PlayerInfo(room.getPlayer1());
        this.playerInfo2 = new PlayerInfo(room.getPlayer2());
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
