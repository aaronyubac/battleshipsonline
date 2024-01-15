package router.potato.BattleshipsOnline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import router.potato.BattleshipsOnline.model.Game;
import router.potato.BattleshipsOnline.model.Player;
import router.potato.BattleshipsOnline.repository.GameRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository theGameRepository) {
        gameRepository = theGameRepository;
    }

    public Game createGame(Player player) {
        Game game = new Game();
        game.setGameId(UUID.randomUUID().toString());
        game.setPlayer1(player);
        gameRepository.save(game);

        return game;
    }

    public Game connectToGame(Player player, String gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);

        optionalGame.orElseThrow(() -> new RuntimeException("Game with provided id doesn't exist")); // create game exception
        Game game = optionalGame.get();

        if (game.getPlayer2() != null) {
            throw new RuntimeException("Game is full");
        }

        game.setPlayer2(player);
        gameRepository.save(game);
        return game;

    }

}
