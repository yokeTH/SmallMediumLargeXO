package network.message;

import logic.chess.BaseChess;
import logic.entity.Player;
import logic.game.TeamColor;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayerInfo implements Serializable {
    private TeamColor teamColor;
    private String name;

    private ArrayList<Chess> inventory;

    public PlayerInfo(TeamColor teamColor, String name, ArrayList<BaseChess> inventory) {
        this.teamColor = teamColor;
        this.name = name;
//        this.inventory = inventory;
    }

    public PlayerInfo(Player player) {
        this.teamColor = player.getTeamColor();
        this.name = player.getName();
        this.inventory = toChessMessage(player.getBaseChessArrayList());
    }

    private ArrayList<Chess> toChessMessage(ArrayList<BaseChess> inventory){
        ArrayList<Chess> chess = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            switch (inventory.get(i).getSize()){
                case 3:
                    chess.add(Chess.Large);
                    break;
                case 2:
                    chess.add(Chess.Medium);
                    break;
                case 1:
                    chess.add(Chess.Small);
                    break;
                default:
                    break;
            }
        }
        return chess;
    }

    public ArrayList<Chess> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Chess> inventory) {
        this.inventory = inventory;
    }

    public TeamColor getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(TeamColor teamColor) {
        this.teamColor = teamColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
