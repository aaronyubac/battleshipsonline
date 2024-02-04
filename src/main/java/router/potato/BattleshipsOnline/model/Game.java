package router.potato.BattleshipsOnline.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import router.potato.BattleshipsOnline.enumeration.GameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class Game {

    @Id
    private String gameId;
    private GameBoard[] gameBoards;
    private Player[] players;
    private Player winner;
    private int turn;
    private GameState gameState;

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

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", gameBoards=" + Arrays.toString(gameBoards) +
                ", players=" + Arrays.toString(players) +
                ", winner=" + winner +
                ", turn=" + turn +
                ", gameState=" + gameState +
                '}';
    }
}
