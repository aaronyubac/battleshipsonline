package router.potato.BattleshipsOnline.dto;

import router.potato.BattleshipsOnline.model.Player;

public class ConnectRequest {

    private Player player;
    private String gameId;

    public ConnectRequest() {

    }

    public ConnectRequest(Player player, String gameId) {
        this.player = player;
        this.gameId = gameId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
