package gameplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterTest {

    @Test
    void getLevelInitial() {
        Character hero = new Character();
        assertEquals(1, hero.getLevel());
    }

    @Test
    void getLevelNegativeNumber() {
        Character hero = new Character();
        hero.setExperience(-10);
        assertEquals(1, hero.getLevel());
    }

    @Test
    void getLevel0() {
        Character hero = new Character();
        hero.setExperience(0);
        assertEquals(1, hero.getLevel());
    }

    @Test
    void getLevel1() {
        Character hero = new Character();
        hero.setExperience(1);
        assertEquals(1, hero.getLevel());
    }

    @Test
    void getLevel100RandomLevel1Value() {
        Character hero = new Character();
        hero.setExperience(100);
        assertEquals(1, hero.getLevel());
    }


    @Test
    void getLevel204LastLevel1Value() {
        Character hero = new Character();
        hero.setExperience(204);
        assertEquals(1, hero.getLevel());
    }

    @Test
    void getLevel205FirstLevel2Value() {
        Character hero = new Character();
        hero.setExperience(205);
        assertEquals(2, hero.getLevel());
    }

    @Test
    void getLevel205FirstLevel3Value() {
        Character hero = new Character();
        hero.setExperience(817);
        assertEquals(3, hero.getLevel());
    }

    ///////////////////////////////////////////////////////

    @Test
    void getCharacterDefaultProfession() {
        Character hero = new Character();
        assertEquals(ProfessionManager.DEFAULT_PROFESSION, hero.getProfession());
    }

    @Test
    void getCharacterDefaultRace() {
        Character hero = new Character();
        assertEquals(ProfessionManager.DEFAULT_PROFESSION, hero.getProfession());
    }

    ///////////////////////////////////////////////////////

    @Test
    void getMaxHealthInitialDefaultProfession() {
        Character hero = new Character();
        assertEquals((long)ProfessionManager.getHealthBonus(ProfessionManager.DEFAULT_PROFESSION),
                hero.getMaxHealth());
    }

    @Test
    void getMaxHealthInitialKnightProfession() {
        Character hero = new Character();
        hero.setProfession(ProfessionManager.Profession.MAGE);
        assertEquals((long)ProfessionManager.getHealthBonus(ProfessionManager.Profession.MAGE),
                hero.getMaxHealth());
    }

    @Test
    void getMaxHealthLevel2GuardianProfession() {
        Character hero = new Character();
        hero.setProfession(ProfessionManager.Profession.GUARDIAN);
        hero.setExperience(205);
        long level = hero.getLevel(); //2
        assertEquals((long)ProfessionManager.getHealthBonus(ProfessionManager.Profession.GUARDIAN) * level,
                hero.getMaxHealth());
    }

    @Test
    void getDefenseInitialDefaultProfession() {
        Character hero = new Character();
        assertEquals((long)ProfessionManager.getDefenseBonus(ProfessionManager.DEFAULT_PROFESSION),
                hero.getDefense());
    }

    @Test
    void getDefenseInitialKnightProfession() {
        Character hero = new Character();
        hero.setProfession(ProfessionManager.Profession.MAGE);
        assertEquals((long)ProfessionManager.getDefenseBonus(ProfessionManager.Profession.MAGE),
                hero.getDefense());
    }

    @Test
    void getDefenseLevel2GuardianProfession() {
        Character hero = new Character();
        hero.setProfession(ProfessionManager.Profession.GUARDIAN);
        hero.setExperience(205);
        long level = hero.getLevel(); //2
        assertEquals((long)ProfessionManager.getDefenseBonus(ProfessionManager.Profession.GUARDIAN) * level,
                hero.getDefense());
    }

    @Test
    void getPowerInitialDefaultProfession() {
        Character hero = new Character();
        assertEquals((long)ProfessionManager.getPowerBonus(ProfessionManager.DEFAULT_PROFESSION),
                hero.getPower());
    }

    @Test
    void getPowerInitialKnightProfession() {
        Character hero = new Character();
        hero.setProfession(ProfessionManager.Profession.MAGE);
        assertEquals((long)ProfessionManager.getPowerBonus(ProfessionManager.Profession.MAGE),
                hero.getPower());
    }

    @Test
    void getPowerLevel2GuardianProfession() {
        Character hero = new Character();
        hero.setProfession(ProfessionManager.Profession.GUARDIAN);
        hero.setExperience(817);
        long level = hero.getLevel(); //3
        assertEquals((long)ProfessionManager.getPowerBonus(ProfessionManager.Profession.GUARDIAN) * level,
                hero.getPower());
    }

}