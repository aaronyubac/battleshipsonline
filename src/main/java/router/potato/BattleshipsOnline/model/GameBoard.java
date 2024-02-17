package router.potato.BattleshipsOnline.model;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameBoard {

    int length = 10;
    int width = 10;
    boolean showBattleships;
    Battleship[] battleships;
    public Set<Shot> shots = new HashSet<>();



    public GameBoard() {
    }

    public boolean isGameOver(Game game) {
        return Arrays.stream(battleships).allMatch(Battleship::isDestroyed);
    }

    public Battleship[] getBattleships() {
        return battleships;
    }

    public void setBattleships(Battleship[] battleships) {
        this.battleships = battleships;

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