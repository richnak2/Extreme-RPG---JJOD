package combat;

import gameplay.Character;
import gameplay.ProfessionManager;

import java.util.*;

import static gameplay.ProfessionManager.Profession.*;


public class BasicAttackManager {
    Random random = new Random();

    public MutableEntry<AttackOptions, Long, String> getCurrentAttack() {
        return CURRENT_ATTACK;
    }

    public static MutableEntry<AttackOptions, Long,String> CURRENT_ATTACK;

    static {
        CURRENT_ATTACK = new MutableEntry<>(AttackOptions.MISS, (long) 0, "nothing had happened");
    }

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
        CURRENT_ATTACK.setValue(attacker.getPower());
        CURRENT_ATTACK.setKey(AttackOptions.BASIC);
        CURRENT_ATTACK.setMassage(String.format("-> basic (%d + %d ) - %d",defender.getCurrentHealth(),defender.getDefense(),attacker.getPower())  );
        defender.setCurrentHealth(defenderDefenseHealth - attacker.getPower());
    }
    public void CriticalAttack(Character attacker, Character defender){
        long defenderDefenseHealth = defender.getCurrentHealth() + defender.getDefense();
        long attackerPowerCritical = attacker.getPower() * getCriticalBonus(attacker,defender);
        CURRENT_ATTACK.setValue(attackerPowerCritical);
        CURRENT_ATTACK.setKey(AttackOptions.CRITICAL);
        CURRENT_ATTACK.setMassage(String.format("-> Critical (%d + %d ) - (%d * %d)",defender.getCurrentHealth(),defender.getDefense(),attacker.getPower(),getCriticalBonus(attacker,defender))  );

        defender.setCurrentHealth(defenderDefenseHealth - attackerPowerCritical);
    }

    public void BasicMiss(){
        CURRENT_ATTACK.setValue(0L);
        CURRENT_ATTACK.setKey(AttackOptions.MISS);
        CURRENT_ATTACK.setMassage("-> Miss ");
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
        System.out.println(attacker.toString() + "  ->     " + defender.toString());
        if (random.nextDouble() < getProbabilityCriticalAttack(attacker, defender) && random.nextDouble() > defender.getDogeChance()) {
            this.CriticalAttack(attacker,defender);
        } else if (random.nextDouble() < getProbabilityBasicAttack(attacker, defender) && random.nextDouble() > defender.getDogeChance()){
            this.BasicAttack(attacker, defender);
        }else {
            this.BasicMiss();
        }
    }
}