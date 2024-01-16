package router.potato.BattleshipsOnline.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Battleship {

    public ArrayList<Point> body;
    public Boolean[] hits;
    char direction;

    public Battleship(ArrayList<Point> body, char direction) {
        this.body = body;
        this.hits = new Boolean[this.body.size()];
        this.direction = direction;

        Arrays.fill(hits, Boolean.FALSE);
    }

    public static Battleship build(Point head, int length, char direction) {

        ArrayList<Point> body = new ArrayList<>(length);
        Point el = null;

        for (int i = 0; i < length; i++) {
            el = switch (direction) {
                case 'N' -> new Point(head.x, head.y - i);
                case 'S' -> new Point(head.x, head.y + i);
                case 'W' -> new Point(head.x - i, head.y);
                case 'E' -> new Point(head.x + i, head.y);
                default -> el;
            };
            body.add(el);
        }
        return new Battleship(body, direction);
    }

    public boolean isDestroyed() {

        return Arrays.stream(hits).allMatch(b -> b.equals(Boolean.TRUE));
    }
}