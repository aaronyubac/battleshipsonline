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

    @Autowired
    public Game createGame(Player player) {
        Game game = new Game();
        game.setGameId(UUID.randomUUID().toString());
        game.setPlayer1(player);
        gameRepository.save(game);

        return game;
    }

}
