package network.message;


import logic.game.TeamColor;

public class Connect extends MessageObject{

    private int roomId;
    private TeamColor teamColor;
    private String name;

    public Connect(int roomId, TeamColor teamColor, String name) {
        super(MessageType.CONNECT);
        this.roomId = roomId;
        this.teamColor = teamColor;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Connect(){
        super(MessageType.CONNECT);
    }

    public Connect(int roomId){
        super(MessageType.CONNECT);
        this.roomId = roomId;
    }

    public Connect(TeamColor teamColor){
        super(MessageType.CONNECT);
        this.teamColor = teamColor;
    }

    public int getRoomId(){
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }
}
