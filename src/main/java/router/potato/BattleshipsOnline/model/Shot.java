package router.potato.BattleshipsOnline.model;

import java.awt.*;

public class Shot {

    private String gameId;
    Point location;
    boolean isHit;

    public Shot(Point location, boolean isHit) {
        this.location = location;
        this.isHit = isHit;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
