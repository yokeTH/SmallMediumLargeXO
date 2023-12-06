package network.message;


public class Connect extends MessageObject{

    private int roomId;
    public Connect(){
        super(MessageType.CONNECT);
    }

    public Connect(int roomId){
        super(MessageType.CONNECT);
        this.roomId = roomId;
    }

    public int getRoomId(){
        return roomId;
    }
}
