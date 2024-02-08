package router.potato.BattleshipsOnline.dto;

import router.potato.BattleshipsOnline.model.Shot;

import java.awt.*;

public class ShotRequest {

    String gameId;
    Shot shot;

    public ShotRequest() {
    }

    public ShotRequest(String gameId, Shot shot) {
        this.gameId = gameId;
        this.shot = shot;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }
}
