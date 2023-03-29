package ui;

import java.io.PrintStream;
import java.util.Collection;

public class Printer {

    PrintStream output, error;

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

    public void printOptions(Collection<Option> options){
        printLine();
        int number = 1;
        for (Option o : options) {
            printLine(formatOption(number, o));
            number++;
        }
    }

    private String formatOption(int number, Option option){
        return number + ". " + option.label();
    }
}
