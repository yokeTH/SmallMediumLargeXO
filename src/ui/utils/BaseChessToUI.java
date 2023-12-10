package ui.utils;

import logic.chess.BaseChess;
import logic.chess.LargeChess;
import logic.chess.MediumChess;
import logic.game.TeamColor;
import ui.components.*;

public class BaseChessToUI {
    public static SVGViewBase translate(BaseChess baseChess){
            if (baseChess == null){
                return new EmptyChess();
            } else if(baseChess instanceof LargeChess){
                if(baseChess.getTeamColor() == TeamColor.BLACK){
                    return new LargeXChess(120);
                }else{
                    return new LargeOChess(120);
                }
            } else if (baseChess instanceof MediumChess) {
                if(baseChess.getTeamColor() == TeamColor.BLACK){
                    return new MediumXChess(120);
                }else{
                    return new MediumOChess(120);
                }
            }else{
                if(baseChess.getTeamColor() == TeamColor.BLACK){
                    return new SmallXChess(120);
                }else{
                    return new SmallOChess(120);
                }
        }
    }
}
