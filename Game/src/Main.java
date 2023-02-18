import MainMenu.MainMenu;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.run();

        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}