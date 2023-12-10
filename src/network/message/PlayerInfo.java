package network.message;

import logic.entity.Player;
import logic.game.TeamColor;

import java.io.Serializable;

public class PlayerInfo implements Serializable {
    private TeamColor teamColor;
    private String name;

    public PlayerInfo(TeamColor teamColor, String name) {
        this.teamColor = teamColor;
        this.name = name;
    }

    public PlayerInfo(Player player) {
        this.teamColor = player.getTeamColor();
        this.name = player.getName();
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
