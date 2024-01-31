package router.potato.BattleshipsOnline.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import router.potato.BattleshipsOnline.enumeration.GameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Game {

    @Id
    private String gameId;
    private GameBoard[] gameBoards;
    private Player player1;
    private Player player2;
    private String winner;
    private int turn;
    private GameState gameState;

    public Game() {
        this.gameBoards = new GameBoard[]{new GameBoard(), new GameBoard()};
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

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
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
                ", gameBoards=" + gameBoards +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", winner='" + winner + '\'' +
                ", turn=" + turn +
                ", gameState=" + gameState +
                '}';
    }
}
