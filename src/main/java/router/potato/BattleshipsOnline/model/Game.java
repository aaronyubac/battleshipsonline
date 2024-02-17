package router.potato.BattleshipsOnline.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.AbstractMap;
import java.util.Arrays;


@Component
public class Game {

    @Id
    private String gameId;
    private GameBoard[] gameBoards;
    private Player[] players;
    private Player winner;
    private int turn;
    private Event event;
    private Shot latestShot;

    public Game() {
        this.gameBoards = new GameBoard[]{new GameBoard(), new GameBoard()};
        this.players = new Player[2];
        this.turn = 0;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public GameBoard[] getGameBoards() {
        return gameBoards;
    }

    public void setGameBoards(GameBoard[] gameBoards) {
        this.gameBoards = gameBoards;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Shot getLatestShot() {
        return latestShot;
    }

    public void setLatestShot(Shot latestShot) {
        this.latestShot = latestShot;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", gameBoards=" + Arrays.toString(gameBoards) +
                ", players=" + Arrays.toString(players) +
                ", winner=" + winner +
                ", turn=" + turn +
                ", event=" + event +
                ", latestShot=" + latestShot +
                '}';
    }
}
