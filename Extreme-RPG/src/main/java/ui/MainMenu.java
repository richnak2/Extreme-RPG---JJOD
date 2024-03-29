package ui;

import application.Application;
import combat.Combat;
import gameplay.Character;
import gameplay.ProfessionManager;

import java.util.List;

public class MainMenu extends Menu{

    public MainMenu(Application application){
        setClassVariablesFromApplication(application);
    }

    private final List<Option> noHeroOptions = List.of(
            new Option("Create hero", this::goToCharacterCreationMenu),
            new Option("Load hero", this::throwNotImplementedException),
            new Option("Quit", Application::quit)
    );

    private final List<Option> heroOptions = List.of(
            new Option("Find a fight", this::startCombat),
            new Option("Visit the shop", this::throwNotImplementedException),
            new Option("Show hero stats", this::throwNotImplementedException),
            new Option("Save hero", this::throwNotImplementedException),
            new Option("Fire hero", this::throwNotImplementedException),
            new Option("Quit", Application::quit)
    );

    @Override
    public void run() {

        List<Option> options;
        if (application.getState().getCurrentHero() == null)
            options = noHeroOptions;
        else
            options = heroOptions;
      
        printer.printTitle("Main menu");
        handleOptionSelection(options);
    }

    private void goToCharacterCreationMenu(){
        application.switchMenu(new CharacterCreator(this));
    }

    private void startCombat(){
        Character enemy = new Character();
        enemy.setProfession(ProfessionManager.Profession.GUARDIAN);
        enemy.setCurrentHealth(enemy.getMaxHealth());
        Combat combat = new Combat(application.getState().currentHero, enemy, printer);
        application.switchMenu(new CombatMenu(this, combat));
    }

}
