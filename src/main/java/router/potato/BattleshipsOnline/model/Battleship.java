package router.potato.BattleshipsOnline.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Battleship {

    public ArrayList<Point> body;
    public Boolean[] hits;

    public Battleship() {
    }

    public Battleship(ArrayList<Point> body) {
        this.body = body;
        this.hits = new Boolean[this.body.size()];

        Arrays.fill(hits, Boolean.FALSE);
    }

    public static Battleship build(Point head, Point tail, boolean isVertical) {

        int length = (isVertical) ? (tail.y - head.y) + 1 : (tail.x - head.x) + 1;
        ArrayList<Point> body = new ArrayList<>(5);
        Point el = null;

        for (int i = 0; i < length; i++) {
            if (isVertical) {
                el = new Point(head.x, head.y + i);
            } else {
                el = new Point(head.x + i, head.y);
            }
            body.add(el);
        }
        return new Battleship(body);
    }

    public boolean isDestroyed() {

        return Arrays.stream(hits).allMatch(b -> b.equals(Boolean.TRUE));
    }
}