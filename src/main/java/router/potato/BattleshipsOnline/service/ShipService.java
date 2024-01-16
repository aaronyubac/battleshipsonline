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

        // get gameboard

        System.out.println(game.getGameBoards()[0]);
        System.out.println(game.getGameBoards()[1]);

        GameBoard gameBoard = (placeRequest.getPlayerType().equals("FIRST_PLAYER")) ? game.getGameBoards()[0]
                : game.getGameBoards()[1];

        // set battleships on board
        Battleship battleship = Battleship.build(placeRequest.getHead(), placeRequest.getLength(), placeRequest.getDirection());
        Battleship[] battleships = {battleship};

        gameBoard.setBattleships(battleships);


        return game;
    }
}
