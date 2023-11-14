package logic.chess;

import logic.game.TeamColor;

public abstract class BaseChess {
    //Field
    private TeamColor teamColor;
    private int size ;

    //Constructor
    public BaseChess(TeamColor teamColor,int size){
        setSize(size);
        setTeamColor(teamColor);
    }

    //Getter & Setter
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
    public void setTeamColor(TeamColor teamColor){
        this.teamColor = teamColor;
    }
    public TeamColor getTeamColor(){
        return this.teamColor;
    }
}
