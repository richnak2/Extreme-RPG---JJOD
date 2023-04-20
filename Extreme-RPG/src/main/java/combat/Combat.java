package combat;

import gameplay.Character;

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
        return this.heroWon() || this.enemyWon() || this.runAway;
    }

    public boolean heroWon(){
        return this.enemy.getCurrentHealth() <=  0;
    }
    public boolean enemyWon(){
        return this.hero.getCurrentHealth() <=  0;
    }

    //TODO
    public void heroRun(){
        this.runAway = this.basicAttack.random.nextDouble()<0.5;
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
