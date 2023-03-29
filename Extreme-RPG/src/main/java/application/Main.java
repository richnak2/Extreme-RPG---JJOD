package application;

import ui.InputReader;
import ui.Printer;

public class Main {

    public static void main(String[] args) {

        var printer = new Printer(System.out, System.err);
        var reader = new InputReader(System.in);
        var app = new Application(reader, printer);

        app.start();

    }

}