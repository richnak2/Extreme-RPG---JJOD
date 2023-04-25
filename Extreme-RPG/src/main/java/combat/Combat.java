package combat;

import gameplay.Character;
import satic.RandomGenerator;
import ui.Printer;

public class Combat {

    private boolean heroEscaped;
    Character hero;
    Character enemy;
    BasicAttackManager basicAttack;

    public Combat(Character hero, Character enemy, Printer printer){
        this.hero = hero;
        this.enemy = enemy;
        this.heroEscaped = false;
        this.basicAttack = new BasicAttackManager(printer);

        setMaxHealthToCombatants();
    }

    private void setMaxHealthToCombatants() {
        hero.setCurrentHealth(hero.getMaxHealth());
        enemy.setCurrentHealth(enemy.getMaxHealth());
    }

    public Character getHero() {
        return hero;
    }

    public Character getEnemy() {
        return enemy;
    }

    public boolean isOver(){
        if (hero.getCurrentHealth() <= 0 || enemy.getCurrentHealth() <= 0) {
            return true;
        }
        return heroEscaped;
    }

    public boolean heroWon(){
        if (hero.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0) {
            return false;
        }
        if (hero.getCurrentHealth() <= 0 || heroEscaped) {
            return false;
        }
        return true;
    }

    public void attemptEscape(){
        this.heroEscaped = RandomGenerator.getRandomDouble() < 0.5;
    }

    public boolean getRun(){
        return this.heroEscaped;
    }

    //TODO
    public long addExperienceToHero(){
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
