package router.potato.BattleshipsOnline.model;

import java.awt.*;

public class Shot {

    Point location;
    boolean isHit;

    public Shot(Point location, boolean isHit) {
        this.location = location;
        this.isHit = isHit;
    }
}
