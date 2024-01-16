package router.potato.BattleshipsOnline.dto;

import router.potato.BattleshipsOnline.model.Battleship;

import java.awt.*;

public class PlaceBattleshipRequest {

    Point head;
    char direction;
    int length;
    String playerType;
    String gameId;


    public PlaceBattleshipRequest(Point head, char direction, int length, String playerType, String gameId) {
        this.head = head;
        this.direction = direction;
        this.length = length;
        this.playerType = playerType;
        this.gameId = gameId;
    }

    public Point getHead() {
        return head;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
