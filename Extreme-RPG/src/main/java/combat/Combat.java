package combat;

import gameplay.Character;

public class Combat {

    Character hero;
    Character enemy;

    public Combat(Character hero, Character enemy){
        this.hero = hero;
        this.enemy = enemy;
    }

    public Character getHero() {
        return hero;
    }

    public Character getEnemy() {
        return enemy;
    }

    //TODO
    public boolean isOver(){
        if (hero.getCurrentHealth() <= 0 || enemy.getCurrentHealth() <= 0) {
            return true;
        }
        // hra konci aj vtedy, ak sa hero rozhodne utiect
        return false;
    }

    public boolean heroWon(){
        if (hero.getCurrentHealth() <= 0) { // alebo hrac utiekol
            return false;
        }
        return true;
    }

    //TODO
    public void simulateEnemyAction(){}

    //TODO
    public int rewardHero(){
        //zvsit xp-cka hrdinovi a vratit kolko xp-cok pribudlo
        return 0;
    }

}
