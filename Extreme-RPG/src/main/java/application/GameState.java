package application;

import java.io.Serializable;
import gameplay.Character;

public class GameState implements Serializable {

    Character currentCharacter;

    public Character getCurrentCharacter() {
        return currentCharacter;
    }
}
