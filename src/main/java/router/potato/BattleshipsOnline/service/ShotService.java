package router.potato.BattleshipsOnline.service;

import org.springframework.stereotype.Service;
import router.potato.BattleshipsOnline.model.Battleship;
import router.potato.BattleshipsOnline.model.Game;
import router.potato.BattleshipsOnline.model.GameBoard;
import router.potato.BattleshipsOnline.model.Shot;

import java.awt.*;
import java.util.Arrays;

@Service
public class ShotService {

    public Game shoot(Game game, Point shotLocation) {

        Shot shot = takeShot(game, shotLocation);

        isGameOver(game);

        return game;


    }

    public Shot takeShot(Game game, Point shotLocation) {
        boolean isHit = false;
        GameBoard defensiveGameBoard = game.getGameBoards()[1];
        for (Battleship b : defensiveGameBoard.getBattleships()) {
            int index = b.body.indexOf(shotLocation);
            if (index != -1) {
                isHit = true;
                b.hits[index] = true;
            }
        }

        Shot shot = new Shot(shotLocation, isHit);
        defensiveGameBoard.shots.add(shot);

        return shot;
    }

    public boolean isGameOver(Game game) {
        GameBoard defensiveGameBoard = game.getGameBoards()[1];
        return Arrays.stream(defensiveGameBoard.getBattleships()).allMatch(Battleship::isDestroyed);
    }
}
