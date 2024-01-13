package router.potato.BattleshipsOnline.model;


import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameBoard {

    Battleship[] battleships;
    Set<Shot> shots = new HashSet<>();
    int width;
    int length;

    public GameBoard(Battleship[] battleships, int width, int length) {
        this.battleships = battleships;
        this.width = width;
        this.length = length;
    }

    public void takeShot(Point shotLocation) {
        boolean isHit = false;
        for (Battleship b : this.battleships) {
            int index = b.body.indexOf(shotLocation);
            if (index != -1) {
                isHit = true;
                b.hits[index] = true;
            }
        }
        this.shots.add(new Shot(shotLocation, isHit));
    }

    public boolean isGameOver() {

        return Arrays.stream(battleships).allMatch(Battleship::isDestroyed);

    }
}