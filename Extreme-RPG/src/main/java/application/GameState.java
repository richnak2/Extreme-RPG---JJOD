package application;

import gameplay.Character;

import java.io.Serializable;
import gameplay.Character;

public class GameState implements Serializable {

    public Character currentHero;
      
    public Character getCurrentHero() {
        return currentHero;
    }

    public void setCurrentHero(Character currentHero) {
        this.currentHero = currentHero;
    }
}
