package router.potato.BattleshipsOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import router.potato.BattleshipsOnline.model.Game;
import router.potato.BattleshipsOnline.model.GameBoard;
import router.potato.BattleshipsOnline.model.Player;
import router.potato.BattleshipsOnline.service.GameService;

@RestController
@RequestMapping("/battleships")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService theGameService) {
        gameService = theGameService;
    }

    @PostMapping("/create")
    public ResponseEntity<Game> createGame(@RequestBody Player player) {
        System.out.println("create game request: " + player);
        return ResponseEntity.ok(gameService.createGame(player));

    }

}
