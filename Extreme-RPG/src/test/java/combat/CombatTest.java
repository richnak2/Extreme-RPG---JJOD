package combat;

import static gameplay.ProfessionManager.Profession.*;
//import static gameplay.ProfessionManager.Profession.MAGE;
import static org.junit.jupiter.api.Assertions.*;

import application.Application;
import gameplay.Character;
import gameplay.ProfessionManager;
import org.junit.jupiter.api.Test;
import ui.MainMenu;

class CombatTest {
    public Combat setupCombatTest(ProfessionManager.Profession professionHero,ProfessionManager.Profession professionEnemy) {

        Character hero = new Character();
        hero.setProfession(professionHero);
        hero.setCurrentHealth(hero.getMaxHealth());

        Character enemy = new Character();
        enemy.setProfession(professionEnemy);
        enemy.setCurrentHealth(enemy.getMaxHealth());

        return new Combat(hero, enemy);
    }

    @Test
    void gameIsOver(){
        Combat combat = setupCombatTest(GUARDIAN,MAGE);
        assertFalse(combat.isOver());
        combat.getHero().setCurrentHealth(0);
        assertTrue(combat.isOver());
    }

    @Test
    void basicAttack(){
        Combat combat = setupCombatTest(GUARDIAN,MAGE);
        combat.basicAttack.BasicAttack(combat.getHero(), combat.getEnemy());
        assertEquals(combat.getHero().getMaxHealth(),combat.getHero().getCurrentHealth());
        long damageWitchShouldBeDealt = combat.getHero().getPower() - combat.getEnemy().getDefense();
        long maxHealthOfEnemyBeforeAttack = combat.getEnemy().getMaxHealth();
        assertEquals(combat.getEnemy().getCurrentHealth(),maxHealthOfEnemyBeforeAttack - damageWitchShouldBeDealt);
    }
}