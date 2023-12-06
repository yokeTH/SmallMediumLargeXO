package network.server;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {
    private int roomId;
//    private GameInstance gameInstance;
//    private Player player[];

    public Room(int roomId){
        this.roomId = roomId;
    }

    public Room(){
        this.roomId = (int) (Math.random() * 1000000);
//        this.gameInstance = new GameInstance();
//        player = new Player[2];
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

//    public void addPlayer(Player p){
//        if(!isRoomFull()){
//            if(player[0] == null){
//                player[0] = p;
//            }else{
//                player[1] = p;
//            }
//        }
//    }
//
//    public boolean isRoomFull(){
//        if(player[0] == null) return false;
//        if(player[1] == null) return false;
//        return true;
//    }

    @Override
    public String toString() {
        return "Room: " + roomId;
    }
}
