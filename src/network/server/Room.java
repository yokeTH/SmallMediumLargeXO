package network.server;

import java.io.Serializable;

import logic.entity.Player;
import logic.game.GameLogic;
public class Room implements Serializable {
    private int roomId;
    private GameLogic gameInstance;
    private Player player1;
    private Player player2;

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Room(int roomId){
        this.roomId = roomId;
        this.gameInstance = new GameLogic();
    }

    public Room(){
        this.roomId = (int) (Math.random() * 1000000);
        this.gameInstance = new GameLogic();
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public GameLogic getGameInstance() {
        return gameInstance;
    }

    public void setGameInstance(GameLogic gameInstance) {
        this.gameInstance = gameInstance;
    }

    @Override
    public String toString() {
        return "Room: " + roomId;
    }
}
