package router.potato.BattleshipsOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/battleships")
public class MenuController {

    @GetMapping
    public String showMenu() {
        return "menu.html";
    }

    @PostMapping("/lobby")
    public String process(@RequestParam("mode") String mode) {

        if(mode.equals("singleplayer")) {
            return "menu.html";
        } else {
            return "lobby.html";
        }

    }
}
