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

    public Game takeShot(Game game, Point shotLocation) {
        Battleship hitBattleship = null;
        boolean isHit = false;
        int defensiveIndex = (game.getTurn()+1) % 2;
        GameBoard defensiveGameBoard = game.getGameBoards()[defensiveIndex];
        for (Battleship b : defensiveGameBoard.getBattleships()) {
            int index = b.body.indexOf(shotLocation);
            if (index != -1) {
                isHit = true;
                b.hits[index] = true;
                hitBattleship = b;
            }
        }

        Shot shot = new Shot(shotLocation, isHit);
        defensiveGameBoard.shots.add(shot);

        if(defensiveGameBoard.isGameOver(game)) {
            game.setWinner(game.getPlayers()[game.getTurn()]);
            // end game
        } else {
            game.setTurn(defensiveIndex);
        }


        return game;
    }


}
