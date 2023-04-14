package ui;

import combat.Combat;

import java.util.List;

public class CombatMenu extends Menu{

    Combat combat;

    CombatMenu(Menu previousMenu, Combat combat){
        super(previousMenu);
        this.combat = combat;
    }

    private final List<Option> actionOptions = List.of(
            new Option("Attack", this::throwNotImplementedException),
            new Option("Special attack", this::throwNotImplementedException),
            new Option("Run away", this::throwNotImplementedException)
    );

    @Override
    public void run() {

        printCombatStart();
        while (!combat.isOver()){
            handleOptionSelection(actionOptions);
            if (!combat.isOver())
                combat.simulateEnemyAction();
        }
        evaluateCombat();
        application.goToPreviousMenu();

    }

    private void evaluateCombat(){
        if (combat.heroWon()){
            printVictoryMessage();
            rewardHero();
        }
        else {
            printDefeatMessage();
            // hero musi zomriet
        }
    }

    private void rewardHero(){
        int level = combat.getHero().getLevel();
        int xp = combat.rewardHero();
        if (combat.getHero().getLevel() > level)
            printLevelUpMessage(xp);
        else
            printRewardMessage(xp);
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

    private void printLevelUpMessage(int xp){
        printer.printMessage(combat.getHero() + " gains " + xp + " as a reward and their level rises to "
                + combat.getHero().getLevel());
    }

    private void printRewardMessage(int xp){
        printer.printMessage(combat.getHero() + " gains " + xp + " as a reward.");
    }



}
