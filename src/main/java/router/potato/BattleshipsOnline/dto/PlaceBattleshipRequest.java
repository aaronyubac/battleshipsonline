package router.potato.BattleshipsOnline.dto;

import java.awt.*;

public class PlaceBattleshipRequest {

    Point[] heads;
    Point[] tails;
    boolean[] isVerticals;
    String playerType;
    String gameId;


    public PlaceBattleshipRequest(Point[] heads, Point[] tails, boolean[] isVerticals,
                                  String playerType, String gameId) {
        this.heads = heads;
        this.tails = tails;
        this.isVerticals = isVerticals;
        this.playerType = playerType;
        this.gameId = gameId;
    }

    public Point[] getHeads() {
        return heads;
    }

    public void setHeads(Point[] heads) {
        this.heads = heads;
    }

    public Point[] getTails() {
        return tails;
    }

    public void setTails(Point[] tails) {
        this.tails = tails;
    }

    public boolean[] getIsVerticals() {
        return isVerticals;
    }

    public void setIsVerticals(boolean[] isVerticals) {
        this.isVerticals = isVerticals;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
