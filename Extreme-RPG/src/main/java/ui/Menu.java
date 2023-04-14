package ui;

import application.Application;

import java.util.List;

// rodicovska trieda pre vsetky "obrazovky" menu
public abstract class Menu {

    Application application;
    InputReader reader;
    Printer printer;

    Menu previousMenu;

    final String notImplementedMessage = "Functionality not implemented!";
    final String invalidInputMessage = "Invalid input!";
    final String selectOptionMessage = "Select option: ";

    Menu(){}

    Menu(Menu previousMenu){
        this.previousMenu = previousMenu;
        copyClassVariablesFromPreviousMenu();
    }

    public abstract void run();

    public Menu getPreviousMenu() {
        return previousMenu;
    }

    void copyClassVariablesFromPreviousMenu(){
        setClassVariablesFromApplication(previousMenu.application);
    }

    void setClassVariablesFromApplication(Application application){
        this.application = application;
        reader = application.getInputReader();
        printer = application.getPrinter();
    }

    public int promptToIntInput(String prompt){
        printer.printString(prompt);
        String input = reader.getNextString();
        return Integer.parseInt(input);
    }

    public String promptToStringInput(String prompt){
        printer.printString(prompt);
        return reader.getNextString();
    }

    void handleOptionSelection(List<Option> options) {
        printer.printOptions(options);
        try{
            int userInput = promptToIntInput(selectOptionMessage);
            selectOption(options, userInput);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            printer.printError(invalidInputMessage);
            handleOptionSelection(options);
        } catch (Exception e){
            printer.printError(e.getMessage());
            handleOptionSelection(options);
        }

    }

    public void selectOption(List<Option> options, int input) {
        options.get(input-1).run();
    }

    void throwNotImplementedException(){
        throw new RuntimeException(notImplementedMessage);
    }

}