package network.message;


import logic.game.TeamColor;

public class Connect extends MessageObject{

    private String name;

    public Connect(TeamColor teamColor, String name) {
        super(MessageType.CONNECT);
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

    public Connect(String name){
        super(MessageType.CONNECT);
        this.name = name;
    }

}
