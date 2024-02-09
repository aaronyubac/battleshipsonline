package router.potato.BattleshipsOnline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import router.potato.BattleshipsOnline.dto.PlaceBattleshipRequest;
import router.potato.BattleshipsOnline.dto.ShotRequest;
import router.potato.BattleshipsOnline.model.*;
import router.potato.BattleshipsOnline.repository.GameRepository;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final ShotService shotService;
    private final ShipService shipService;

    @Autowired
    public GameService(GameRepository theGameRepository, ShotService theShotService, ShipService theShipService) {
        gameRepository = theGameRepository;
        shotService = theShotService;
        shipService = theShipService;
    }

    public Game createGame(Player player) {
        Game game = new Game();
        game.setGameId(UUID.randomUUID().toString());
        game.getPlayers()[0] = player;

        gameRepository.save(game);

        return game;
    }

    public Game connectToGame(Player player, String gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);

        optionalGame.orElseThrow(() -> new RuntimeException("Game with provided id doesn't exist")); // create game exception
        Game game = optionalGame.get();

        if (game.getPlayers()[1] != null) {
            throw new RuntimeException("Game is full");
        }

        game.getPlayers()[1] = player;
        gameRepository.save(game);
        return game;

    }

    public Game placeShips(PlaceBattleshipRequest placeRequest) {

        Optional<Game> optionalGame = gameRepository.findById(placeRequest.getGameId());

        optionalGame.orElseThrow(() -> new RuntimeException("Game with provided id doesn't exist"));
        Game game = optionalGame.get();

        Game gameShipsPlaced = shipService.placeShips(game, placeRequest);
        if (placeRequest.getPlayerType().equals("FIRST_PLAYER")) {
            game.getPlayers()[0].setReady(true);
        } else {
            game.getPlayers()[1].setReady(true);
        }
        gameRepository.save(gameShipsPlaced);

        return gameShipsPlaced;
    }

    public Game shoot(ShotRequest shotRequest) {
        Optional<Game> optionalGame = gameRepository.findById(shotRequest.getGameId());

        optionalGame.orElseThrow(() -> new RuntimeException("Game with provided id doesn't exist"));
        Game game = optionalGame.get();

        Game gamePostShot = shotService.takeShot(game, shotRequest.getShot().getLocation());

        gameRepository.save(gamePostShot);

        return game;
    }

}
