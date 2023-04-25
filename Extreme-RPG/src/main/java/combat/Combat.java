package combat;

import gameplay.Character;
import satic.RandomGenerator;

public class Combat {

    private boolean runAway;
    Character hero;
    Character enemy;
    BasicAttackManager basicAttack;

    public Combat(Character hero, Character enemy){
        this.hero = hero;
        this.enemy = enemy;
        this.runAway = false;
        this.basicAttack = new BasicAttackManager();
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
        if (hero.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0) {
            return false;
        }
        if (hero.getCurrentHealth() <= 0) { // alebo hrac utiekol
            return false;
        }
        return true;
    }

    //TODO
    public void heroRun(){
        this.runAway = RandomGenerator.getRandomDouble()<0.5;
    }
    public boolean getRun(){
        return this.runAway;
    }

    //TODO
    public long rewardHero(){
        //zvsit xp-cka hrdinovi a vratit kolko xp-cok pribudlo
        return 100;
    }

    public void simpleAttackHero(){
        basicAttack.simulateAttack(this.hero,this.enemy);
    }

    public void simpleAttackEnemy(){
        basicAttack.simulateAttack(this.enemy,this.hero);
    }
}
