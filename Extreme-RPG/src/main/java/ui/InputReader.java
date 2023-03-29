package ui;

import java.io.InputStream;
import java.util.Scanner;

public class InputReader {

    InputStream input;
    Scanner scanner;

    public InputReader(InputStream input) {
        this.input = input;
        scanner = new Scanner(input);
    }

    public String getNextString(){
        return scanner.next();
    }
}
