package combat;

import gameplay.Character;

public class Combat {

    Character hero;
    Character enemy;

    public Character getHero() {
        return hero;
    }

    public Character getEnemy() {
        return enemy;
    }

    //TODO
    public boolean isOver(){
        return false;
    }

    public boolean heroWon(){
        return false;
    }

    //TODO
    public void simulateEnemyAction(){}

    //TODO
    public int rewardHero(){
        //zvsit xp-cka hrdinovi a vratit kolko xp-cok pribudlo
        return 0;
    }

}
