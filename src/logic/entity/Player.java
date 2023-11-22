package logic.entity;

import logic.chess.BaseChess;
import logic.chess.LargeChess;
import logic.chess.MediumChess;
import logic.chess.SmallChess;
import logic.game.GameLogic;
import logic.game.TeamColor;

import java.util.ArrayList;

public class Player {
    TeamColor teamColor;
    ArrayList<BaseChess> baseChessArrayList;
    String name;
    boolean playDone;

    public Player(TeamColor teamColor,String name){
        baseChessArrayList = new ArrayList<>();
        setTeamColor(teamColor);
        setName(name);
        baseChessArrayList.add(new LargeChess(teamColor));
        baseChessArrayList.add(new LargeChess(teamColor));
        baseChessArrayList.add(new MediumChess(teamColor));
        baseChessArrayList.add(new MediumChess(teamColor));
        baseChessArrayList.add(new SmallChess(teamColor));
        baseChessArrayList.add(new SmallChess(teamColor));
        setPlayDone(false);
    }
    public boolean haveThisChess(int chessIdx){
        return chessIdx < baseChessArrayList.size() && chessIdx >= 0;
    }

    public void play(int chessIdx,int column,int row){
        if (!haveThisChess(chessIdx)){
            System.out.println("You don't have this chess. Try Again.");
        } else {
            BaseChess baseChess = baseChessArrayList.get(chessIdx);
            if (!baseChess.canPlace(column,row)){
                System.out.println("You can't place there. Try Again.");
            } else {
                baseChess.Place(column,row);
                baseChessArrayList.remove(chessIdx);
                setPlayDone(true);
            }
        }

    }

    public boolean haveNoChess(){
        return baseChessArrayList.isEmpty();
    }

    public boolean noPlaceableChess(){
        for (BaseChess b : baseChessArrayList){
            for (int row=0;row<3;row++){
                for (int column=0;column<3;column++){
                    if (b.canPlace(column,row)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String getPlayerNum() {
        GameLogic gameInstance = GameLogic.getInstance();
        if (this == gameInstance.getPlayer1()){
            return "1";
        }
        return "2";
    }

    public ArrayList<BaseChess> getBaseChessArrayList() {return baseChessArrayList;}
    public void setBaseChessArrayList(ArrayList<BaseChess> baseChessArrayList) {this.baseChessArrayList = baseChessArrayList;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public TeamColor getTeamColor() {return teamColor;}
    public void setTeamColor(TeamColor teamColor) {this.teamColor = teamColor;}
    public void setPlayDone(boolean playDone) {this.playDone = playDone;}
    public boolean isPlayDone() {return playDone;}
}
