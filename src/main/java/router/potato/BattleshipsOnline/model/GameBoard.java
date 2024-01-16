package router.potato.BattleshipsOnline.model;


import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameBoard {

    char[][] board;
    int length = 10;
    int width = 10;
    boolean showBattleships;
    Battleship[] battleships;
    public Set<Shot> shots = new HashSet<>();


    public GameBoard() {
        board = new char[length][width];
        for (char[] row : board) {
            Arrays.fill(row, '-');
        }

    }

    public Battleship takeShot(Point shotLocation) {
        Battleship hitBattleship = null;
        boolean isHit = false;
        for (Battleship b : this.battleships) {
            int index = b.body.indexOf(shotLocation);
            if (index != -1) {
                isHit = true;
                b.hits[index] = true;
                hitBattleship = b;
            }
        }
        this.shots.add(new Shot(shotLocation, isHit));

        return hitBattleship;
    }



    public Battleship[] getBattleships() {
        return battleships;
    }

    public void setBattleships(Battleship[] battleships) {
        this.battleships = battleships;
    }
}