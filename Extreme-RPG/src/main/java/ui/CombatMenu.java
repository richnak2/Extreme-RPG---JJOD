package ui;

import combat.Combat;

import java.util.List;
import gameplay.Character;

public class CombatMenu extends Menu{

    Combat combat;

    CombatMenu(Menu previousMenu, Combat combat){
        super(previousMenu);
        this.combat = combat;
    }

    private final List<Option> actionOptions = List.of(
            new Option("Attack", this::simpleAttackHero),
            new Option("Special attack", this::throwNotImplementedException),
            new Option("Run away", this::runAway)
    );

    private void simpleAttackHero() {
        this.combat.simpleAttackHero();
    }

    private void runAway() {
        this.combat.heroRun();
    }

    @Override
    public void run() {

        printCombatStart();
        printer.printLine();
//        printTurn(combat.getHero());
        while (!combat.isOver()) {
            printTurn(combat.getHero());
            handleOptionSelection(actionOptions);
//            printTurn(combat.getHero());
            if (!combat.isOver()) {
                printTurn(combat.getEnemy());
                combat.simpleAttackEnemy();
//                combat.simulateEnemyAction();
            }

        }
        evaluateCombat();
        this.application.goToPreviousMenu();

    }

    private void evaluateCombat(){
        if (combat.getRun()){
            this.printSuccessfulEscapeMessage();
        }
        else if (combat.heroWon()){
            printVictoryMessage();
            rewardHero();
        }
        else {
            printDefeatMessage();
            // hero musi zomriet
        }
    }

    private void rewardHero(){
        long level = combat.getHero().getLevel();
        long xp = combat.rewardHero();
        if (combat.getHero().getLevel() > level)
            printLevelUpMessage(xp);
        else
            printRewardMessage(xp);
    }

    private void printHeroEnemy(Character ch1,Character ch2){
        if (combat.getTurn() > 0){
            this.printAction();
        }
        printCharacterStats(ch1);
        printCharacterStats(ch2);

    }
    /**
     * ---HERO'S TURN---
     * Hero: 100/150 HP, 20/100 mana
     * Angry minotaur: x/x hp, x/x mana
     */

    private void printTurn(Character characterOnTurn){
//        combat.updateTurn();
        printer.printLine("~~" + characterOnTurn.toString().toUpperCase() + "' TURN_"+combat.getTurn().toString()+"~~");

        combat.updateTurn();
        if (combat.getTurn()%2 == 0){
            printHeroEnemy(combat.getEnemy(),combat.getHero());
        }else{
            printHeroEnemy(combat.getHero(),combat.getEnemy());
        }
        printer.printLine();
    }
    private void printAction(){
        printer.printString(combat.getBasicAttack().getCurrentAttack().getMassage());
        printer.printLine();
    }

    private void printCharacterStats(Character character){
        printer.printString(character.toString());
        printer.printString(": " + character.getCurrentHealth() + "/" + character.getMaxHealth() + " HP ");
        printer.printString(" " + character.getCurrentEnergy() + "/" + character.getMaxEnergy() + " Energy");
        printer.printLine();
    }

    private void printCombatStart(){
        printer.printMessage(combat.getHero() + " challenges " + combat.getEnemy() + " to a fight!");
    }

    private void printVictoryMessage(){
        printer.printMessage(combat.getHero() + " gloriously defeated " + combat.getEnemy() + "!");
    }

    private void printDefeatMessage(){
        printer.printMessage(combat.getHero() + " was shamefully crushed by " + combat.getEnemy() + "!");
    }

    private void printLevelUpMessage(long xp){
        printer.printMessage(combat.getHero() + " gains " + xp + " as a reward and their level rises to "
                + combat.getHero().getLevel());
    }

    private void printRewardMessage(long xp){
        printer.printMessage(combat.getHero() + " gains " + xp + " as a reward.");
    }

    private void printSuccessfulEscapeMessage(){
        printer.printMessage(combat.getHero() + " managed to save their life and run away from the fight.");
    }

    private void printUnsuccessfulEscapeMessage(){
        printer.printMessage(combat.getHero() + " tried to cowardly escape, but failed!");
    }


    public Combat getCombat() {
        return combat;
    }
}
