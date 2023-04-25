package combat;

import gameplay.Character;
import gameplay.ProfessionManager;
import satic.RandomGenerator;

import java.util.*;

import static gameplay.ProfessionManager.Profession.*;


public class BasicAttackManager {


    public enum AttackOptions {
        BASIC,
        CRITICAL,
        MISS,
    }


    private static final Map<ProfessionManager.Profession,Map<ProfessionManager.Profession, Integer>> criticalBonus = new HashMap<>();
    static {
        ProfessionManager.Profession[] allProfessions = { MAGE,KNIGHT,GUARDIAN };

        criticalBonus.put(MAGE, getMapCriticalMultiplayer(List.of(allProfessions),new Integer[]{4,3,2}) );
        criticalBonus.put(KNIGHT, getMapCriticalMultiplayer(List.of(allProfessions),new Integer[]{4,2,3}) );
        criticalBonus.put(GUARDIAN, getMapCriticalMultiplayer(List.of(allProfessions),new Integer[]{3,4,2}) );

    }
    public static Integer getCriticalBonus(Character attacker, Character defender){
        if (attacker.getProfession() != null && defender.getProfession() != null) {
            return criticalBonus.get(attacker.getProfession()).get(defender.getProfession());
        }
        throw new RuntimeException("Missing profession");
    }
    private static Map<ProfessionManager.Profession, Integer> getMapCriticalMultiplayer(List<ProfessionManager.Profession> professions, Integer[] integers){
        Map<ProfessionManager.Profession, Integer> retMap = new HashMap<>(){};
        if (professions.size() != integers.length){
            throw new RuntimeException("Length of arg must be equal");
        }
        for (int index = 0; index < professions.size(); index++) {
            retMap.put(professions.get(index),integers[index]);
        }
        return retMap;
    }
    public void BasicAttack(Character attacker, Character defender){
        long defenderDefenseHealth = defender.getCurrentHealth() + defender.getDefense();
        defender.setCurrentHealth(defenderDefenseHealth - attacker.getPower());
        System.out.println(attacker.toString() + "  ->BASIC     " + defender.toString());
    }
    public void CriticalAttack(Character attacker, Character defender){
        long defenderDefenseHealth = defender.getCurrentHealth() + defender.getDefense();
        long attackerPowerCritical = attacker.getPower() * getCriticalBonus(attacker,defender);
        defender.setCurrentHealth(defenderDefenseHealth - attackerPowerCritical);
        System.out.println(attacker.toString() + "  ->CRITICAL     " + defender.toString());
    }

    public void BasicMiss(Character attacker, Character defender) {
        System.out.println(attacker.toString() + "  ->MISS     " + defender.toString());
    }

    public static double getProbabilityBasicAttack(Character attacker, Character defender){
        // TODO - some non basic logic to count crit chance by lvl and atributes
        return 0.90;
    }
    public static double getProbabilityCriticalAttack(Character attacker, Character defender){
        // TODO - some non basic logic to count crit chance by lvl and atributes
        return 0.3;
    }
    public void simulateAttack(Character attacker, Character defender) {
//        System.out.println(attacker.toString() + "  ->     " + defender.toString());
        if (RandomGenerator.getRandomDouble() < getProbabilityCriticalAttack(attacker, defender) && RandomGenerator.getRandomDouble() > defender.getDogeChance()) {
            this.CriticalAttack(attacker,defender);
        } else if (RandomGenerator.getRandomDouble() < getProbabilityBasicAttack(attacker, defender) && RandomGenerator.getRandomDouble() > defender.getDogeChance()){
            this.BasicAttack(attacker, defender);
        }else {
            this.BasicMiss(attacker, defender);
        }
    }
}