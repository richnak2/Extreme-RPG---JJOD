package ui;

import combat.Combat;

import java.io.PrintStream;
import java.util.Collection;

public class Printer {

    PrintStream output, error;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Printer(PrintStream output, PrintStream error) {
        this.output = output;
        this.error = error;
    }

    public void printLine(){
        output.println();
    }

    public void printLine(String message){
        output.println(message);
    }

    public void printString(String message){
        output.print(message);
    }

    public void printError(String message){
        error.println(message);
    }

    public void printTitle(String title) {
        printLine();
        String decoration = "---";
        printLine(decoration + title.toUpperCase() + decoration);
    }

    public void printMessage(String message) {
        String decoration = "-";

        printString(ANSI_YELLOW);
        printLine(decoration + message);
        printString(ANSI_RESET);
    }

    public void printOptions(Collection<Option> options) {
        int number = 1;
        for (Option o : options) {
            printLine(formatOption(number, o));
            number++;
        }
        printLine();
    }

    private String formatOption(int number, Option option){
        return number + ". " + option.label();
    }
}
