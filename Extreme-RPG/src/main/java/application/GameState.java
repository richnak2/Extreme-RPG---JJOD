package application;

import gameplay.Character;

import java.io.Serializable;

public class GameState implements Serializable {

    public Character currentHero;

    public void setCurrentHero(Character currentHero) {
        this.currentHero = currentHero;
    }
}
