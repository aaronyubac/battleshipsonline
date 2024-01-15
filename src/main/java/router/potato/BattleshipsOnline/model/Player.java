package router.potato.BattleshipsOnline.model;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.function.Function;
@Component
public class Player {

    String name;


    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
