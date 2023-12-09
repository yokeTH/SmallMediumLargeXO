package network.message;

import logic.entity.Player;
import network.server.Room;

public class Action extends MessageObject{

    private Room room;
    private Player player;


    public Action(Room room, Player player) {
        super(MessageType.ACTION);
        this.player = player;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
