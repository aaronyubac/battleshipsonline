package router.potato.BattleshipsOnline.model;

import java.awt.*;

public class Shot {

    Point location;
    boolean isHit;

    public Shot() {
    }

    public Shot(Point location, boolean isHit) {
        this.location = location;
        this.isHit = isHit;
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
