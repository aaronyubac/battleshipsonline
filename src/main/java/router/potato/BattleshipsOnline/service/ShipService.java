package router.potato.BattleshipsOnline.service;

import org.springframework.stereotype.Service;
import router.potato.BattleshipsOnline.dto.PlaceBattleshipRequest;
import router.potato.BattleshipsOnline.model.Battleship;
import router.potato.BattleshipsOnline.model.Game;
import router.potato.BattleshipsOnline.model.GameBoard;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipService {

    public Game placeShips(Game game, PlaceBattleshipRequest placeRequest) {

        GameBoard gameBoard = (placeRequest.getPlayerType().equals("FIRST_PLAYER")) ?
                game.getGameBoards()[0] : game.getGameBoards()[1];

        Battleship[] battleships = new Battleship[5];
        for (int i = 0; i < battleships.length; i++) {
            battleships[i] = Battleship.build(placeRequest.getHeads()[i], placeRequest.getTails()[i], placeRequest.getIsVerticals()[i]);
        }

        gameBoard.setBattleships(battleships);


        return game;
    }
}
