package router.potato.BattleshipsOnline.model;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.function.Function;
@Component
public class Player {

    String name;
    boolean isReady = false;


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

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
