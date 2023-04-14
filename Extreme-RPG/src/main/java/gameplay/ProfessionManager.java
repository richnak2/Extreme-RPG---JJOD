package gameplay;

import java.util.HashMap;
import java.util.Map;

public class ProfessionManager {

    public static final Profession DEFAULT_PROFESSION = Profession.KNIGHT;
    public enum Profession {
        MAGE,
        KNIGHT,
        GUARDIAN,
    }

    public enum EvilProfession {
        NECROMANCER,
        BANDIT,
        BRUTE
    }

    private static final Map<Profession, Integer> healthBonus = new HashMap<>();
    static {
        healthBonus.put(Profession.MAGE, 100);
        healthBonus.put(Profession.KNIGHT, 150);
        healthBonus.put(Profession.GUARDIAN, 200);
    }

    public static Integer getHealthBonus(Profession profession) {
        if (profession == null) {
            return healthBonus.get(DEFAULT_PROFESSION);
        }
        return healthBonus.get(profession);
    }

    private static final Map<Profession, Integer> defenseBonus = new HashMap<>();
    static {
        defenseBonus.put(Profession.MAGE, 5);
        defenseBonus.put(Profession.KNIGHT, 10);
        defenseBonus.put(Profession.GUARDIAN, 10);
    }

    public static Integer getDefenseBonus(Profession profession) {
        if (profession == null) {
            return defenseBonus.get(DEFAULT_PROFESSION);
        }
        return defenseBonus.get(profession);
    }

    private static final Map<Profession, Integer> powerBonus = new HashMap<>();
    static {
        powerBonus.put(Profession.MAGE, 50);
        powerBonus.put(Profession.KNIGHT, 30);
        powerBonus.put(Profession.GUARDIAN, 20);
    }

    public static Integer getPowerBonus(Profession profession) {
        if (profession == null) {
            return powerBonus.get(DEFAULT_PROFESSION);
        }
        return powerBonus.get(profession);
    }

    private static final Map<Profession, String> description = new HashMap<>();
    static {
        description.put(Profession.MAGE, "powerful but fragile");
        description.put(Profession.KNIGHT, "balance between power and defense");
        description.put(Profession.GUARDIAN, "resilient but with lower damage");
    }

    public static String getDescription(Profession profession) {
        if (profession == null) {
            return description.get(DEFAULT_PROFESSION);
        }
        return description.get(profession);
    }

    private static final Map<Profession, EvilProfession> evilVersion = new HashMap<>();
    static {
        evilVersion.put(Profession.MAGE, EvilProfession.NECROMANCER);
        evilVersion.put(Profession.KNIGHT, EvilProfession.BANDIT);
        evilVersion.put(Profession.GUARDIAN, EvilProfession.BRUTE);
    }

    public static EvilProfession getEvilProfessionVersion(Profession profession) {
        if (profession == null) {
            return evilVersion.get(DEFAULT_PROFESSION);
        }
        return evilVersion.get(profession);
    }

}
