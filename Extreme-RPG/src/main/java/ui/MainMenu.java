package ui;

import application.Application;

import java.util.List;

public class MainMenu extends Menu{

    public MainMenu(Application application){
        setClassVariablesFromApplication(application);
    }

    private final List<Option> options = List.of(
            new Option("Create character", this::goToCharacterCreationMenu),
            new Option("Save character", this::throwNotImplementedException),
            new Option("Quit", Application::quit)
    );

    @Override
    public void run() {
        printer.printTitle("Main menu");
        handleOptionSelection(options);
    }

    private void goToCharacterCreationMenu(){
        application.switchMenu(new CharacterCreator(this));
    }

}
