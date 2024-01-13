package router.potato.BattleshipsOnline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import router.potato.BattleshipsOnline.model.Game;
import router.potato.BattleshipsOnline.model.Player;

import java.util.UUID;

@Service
public class GameService {

    @Autowired
    public Game createGame(Player player) {
        Game game = new Game();
        game.setGameId(UUID.randomUUID().toString());
        game.setPlayer1(player);

        return game;
    }

}
