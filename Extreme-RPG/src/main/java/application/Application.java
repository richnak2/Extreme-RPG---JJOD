package application;

import ui.InputReader;
import ui.MainMenu;
import ui.Menu;
import ui.Printer;

public class Application {

    InputReader inputReader;
    Printer printer;
    Menu currentMenu;

    GameState state;

    public Application(InputReader inputReader, Printer printer) {
        this.inputReader = inputReader;
        this.printer = printer;
        this.state = new GameState();

        currentMenu = new MainMenu(this);
        state = new GameState();

    }

    public InputReader getInputReader() {
        return inputReader;
    }

    public Printer getPrinter() {
        return printer;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public GameState getState() {
        return state;
    }

    public void start(){
        currentMenu = new MainMenu(this);
        currentMenu.run();
    }

    public void switchMenu(Menu newMenu){
        currentMenu = newMenu;
        currentMenu.run();
    }

    public void goToPreviousMenu(){
        Menu previousMenu = currentMenu.getPreviousMenu();
        if (previousMenu == null)
            return;
        currentMenu = previousMenu;
        currentMenu.run();
    }

    public static void quit(){
        System.exit(0);
    }

}
