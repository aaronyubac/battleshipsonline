package router.potato.BattleshipsOnline.model;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameBoard {

    int[][] board;
    int length = 10;
    int width = 10;
    boolean showBattleships;
    Battleship[] battleships;
    public Set<Shot> shots = new HashSet<>();


//    (0-water, 1-ship, 2-shot-hit, 3-shot-miss)
    public GameBoard() {
        board = new int[length][width];
        for (int[] row : board) {
            Arrays.fill(row, 0);
        }
    }

    public boolean isGameOver(Game game) {
        return Arrays.stream(battleships).allMatch(Battleship::isDestroyed);
    }

    public Battleship[] getBattleships() {
        return battleships;
    }

    public void setBattleships(Battleship[] battleships) {
        this.battleships = battleships;
        for (Battleship b : battleships) {
            for (Point p : b.body) {
                board[p.y][p.x] = 1;
            }
        }
    }


    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public Set<Shot> getShots() {
        return shots;
    }

    public void setShots(Set<Shot> shots) {
        this.shots = shots;
    }

    public boolean isShowBattleships() {
        return showBattleships;
    }

    public void setShowBattleships(boolean showBattleships) {
        this.showBattleships = showBattleships;
    }
}