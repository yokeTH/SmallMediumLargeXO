package network.message;

import network.server.Room;

public class RoomInfo extends MessageObject{

    private Room room;
    public RoomInfo(Room room){
        super(MessageType.ROOM_INFO);
        this.room = room;
    }

    @Override
    public String toString() {
        return "RoomID:" + this.room.getRoomId();
    }
}
