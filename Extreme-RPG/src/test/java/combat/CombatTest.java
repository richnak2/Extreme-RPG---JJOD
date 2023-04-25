package combat;

import static gameplay.ProfessionManager.Profession.*;
import static org.junit.jupiter.api.Assertions.*;

import gameplay.Character;
import gameplay.ProfessionManager;
import org.junit.jupiter.api.Test;

public class CombatTest {
    public Combat setupCombat(ProfessionManager.Profession professionHero, ProfessionManager.Profession professionEnemy) {

        Character hero = new Character();
        hero.setProfession(professionHero);
        hero.setCurrentHealth(hero.getMaxHealth());

        Character enemy = new Character();
        enemy.setProfession(professionEnemy);
        enemy.setCurrentHealth(enemy.getMaxHealth());

        return new Combat(hero, enemy);
    }

    @Test
    void isOver(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        assertFalse(combat.isOver());
    }

    @Test
    void isOverHeroZeroHealth(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        assertFalse(combat.isOver());
        combat.getHero().setCurrentHealth(0);
        assertTrue(combat.isOver());
    }

    @Test
    void isOverHeroNegativeHealth(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        assertFalse(combat.isOver());
        combat.getHero().setCurrentHealth(-6);
        assertTrue(combat.isOver());
    }

    @Test
    void isOverEnemyZeroHealth(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        assertFalse(combat.isOver());
        combat.getEnemy().setCurrentHealth(0);
        assertTrue(combat.isOver());
    }

    @Test
    void isOverEnemyNegativeHealth(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        assertFalse(combat.isOver());
        combat.getEnemy().setCurrentHealth(-1);
        assertTrue(combat.isOver());
    }

    @Test
    void heroWonGameStart(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        assertFalse(combat.heroWon());
    }

    @Test
    void heroWonHeroZeroHealth(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        combat.getHero().setCurrentHealth(0);
        assertFalse(combat.heroWon());
    }

    @Test
    void heroWonHeroNegativeHealth(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        combat.getHero().setCurrentHealth(-3);
        assertFalse(combat.heroWon());
    }

    @Test
    void heroWonEnemyZeroHealth(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        combat.getEnemy().setCurrentHealth(0);
        assertTrue(combat.heroWon());
    }

    @Test
    void heroWonEnemyNegativeHealth(){
        Combat combat = setupCombat(GUARDIAN,MAGE);
        combat.getEnemy().setCurrentHealth(-50);
        assertTrue(combat.heroWon());
    }
}
