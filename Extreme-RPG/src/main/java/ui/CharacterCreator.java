package ui;

import gameplay.Character;
import gameplay.ProfessionManager;
import gameplay.RaceManager;

import java.util.ArrayList;
import java.util.List;

public class CharacterCreator extends Menu {
    private final List<Option> raceOptions = new ArrayList<>();
    private final List<Option> professionOptions = new ArrayList<>();
    private RaceManager.Race chosenRace;
    private ProfessionManager.Profession chosenProfession;

    public CharacterCreator(Menu previousMenu) {
        this.previousMenu = previousMenu;
        copyClassVariablesFromPreviousMenu();

        loadRaces();
        loadProfessions();
    }

    private void loadProfessions() {
        for (ProfessionManager.Profession profession : ProfessionManager.Profession.values()) {
            professionOptions.add(new Option(getProfessionWithDescription(profession), () -> chosenProfession = profession));
        }
    }

    private static String getProfessionWithDescription(ProfessionManager.Profession profession) {
        return profession.name().toLowerCase() + " -> " + ProfessionManager.getDescription(profession);
    }

    private void loadRaces() {
        for (RaceManager.Race race : RaceManager.Race.values()) {
            raceOptions.add(new Option(race.name().toLowerCase(), () -> chosenRace = race));
        }
    }

    @Override
    public void run() {
        printer.printTitle("Character creator");

        String chosenName = promptToStringInput("Enter hero name: ");
        handleOptionSelection(raceOptions);
        handleOptionSelection(professionOptions);

        Character hero = createCharacter(chosenName);
        saveHero(hero);

        printer.printMessage("Hero was successfully created.");
        application.goToPreviousMenu();
    }

    private void saveHero(Character hero) {
        application.getState().setCurrentHero(hero);
    }

    private Character createCharacter(String name) {
        Character hero = new Character();
        hero.setName(name);
        hero.setRace(chosenRace);
        hero.setProfession(chosenProfession);

        return hero;
    }
}
