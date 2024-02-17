package router.potato.BattleshipsOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import router.potato.BattleshipsOnline.dto.ConnectRequest;
import router.potato.BattleshipsOnline.dto.PlaceBattleshipRequest;
import router.potato.BattleshipsOnline.dto.ShotRequest;
import router.potato.BattleshipsOnline.model.*;
import router.potato.BattleshipsOnline.service.GameService;
import router.potato.BattleshipsOnline.service.ShipService;

import java.util.ArrayList;
import java.util.Arrays;

@CrossOrigin(origins = "http://192.168.0.133:8080/battleships")
@Controller
@RequestMapping("/battleships")
public class GameController {

    private final GameService gameService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public GameController(GameService theGameService, SimpMessagingTemplate theSimpMessagingTemplate) {
        gameService = theGameService;
        simpMessagingTemplate = theSimpMessagingTemplate;
    }

    @PostMapping("/create")
    public ResponseEntity<Game> createGame(@RequestBody Player player) {
        System.out.println("create game request: " + player);
        return ResponseEntity.ok(gameService.createGame(player));

    }

    @PostMapping("/connect")
    public ResponseEntity<Game> createGame(@RequestBody ConnectRequest connectRequest) {
        System.out.println("connect request: " + connectRequest);
        System.out.println("Player: " + connectRequest.getPlayer());
        System.out.println("Game Id: " + connectRequest.getGameId());

        Game game = gameService.connectToGame(connectRequest.getPlayer(), connectRequest.getGameId());

        simpMessagingTemplate.convertAndSend("/topic/game-progress/" + connectRequest.getGameId(), game);
        return ResponseEntity.ok(game);

    }

    @PostMapping("/place")
    public ResponseEntity<Game> placeShips(@RequestBody PlaceBattleshipRequest placeRequest) {

        System.out.println("heads: " + Arrays.toString(placeRequest.getHeads()));
        System.out.println("tails: " + Arrays.toString(placeRequest.getTails()));
        System.out.println("isVerticals: " + Arrays.toString(placeRequest.getIsVerticals()));

        Game game = gameService.placeShips(placeRequest);

        simpMessagingTemplate.convertAndSend("/topic/game-progress/" + placeRequest.getGameId(), game);
        return ResponseEntity.ok(game);
    }

    @PostMapping("/shoot")
    public ResponseEntity<Game> shoot(@RequestBody ShotRequest shotRequest) {

        Game game = gameService.shoot(shotRequest);

        simpMessagingTemplate.convertAndSend("/topic/game-progress/" + shotRequest.getGameId(), game);
        return ResponseEntity.ok(game);
    }

}
