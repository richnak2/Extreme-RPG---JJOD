package application;

import org.junit.jupiter.api.Test;
import ui.InputReader;
import ui.MainMenu;
import ui.Printer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    ByteArrayOutputStream outputArray = new ByteArrayOutputStream();
    ByteArrayOutputStream errorArray = new ByteArrayOutputStream();

    public Application setupApplicationWithInput(String input) {

        PrintStream out = new PrintStream(this.outputArray);
        PrintStream err = new PrintStream(this.errorArray);
        var printer = new Printer(out, err);

        InputReader reader = new InputReader(new ByteArrayInputStream(input.getBytes()));

        return new Application(reader, printer);
    }

    @Test
    void gameStartsWithMainMenu(){
        Application app = setupApplicationWithInput("");
        assertTrue(app.getCurrentMenu() instanceof MainMenu);
    }

    @Test
    void correctIntInput1(){
        Application app = setupApplicationWithInput("1");
        int parsedInt = app.currentMenu.promptToIntInput("");
        assertEquals(1, parsedInt);
    }

    @Test
    void correctIntInputNegative1(){
        Application app = setupApplicationWithInput("-1");
        int parsedInt = app.currentMenu.promptToIntInput("");
        assertEquals(-1, parsedInt);
    }

    @Test
    void invalidIntInputChar(){
        Application app = setupApplicationWithInput("a");
        assertThrows(NumberFormatException.class, () -> app.currentMenu.promptToIntInput(""));
    }

    @Test
    void invalidIntInputDouble(){
        Application app = setupApplicationWithInput("1.5");
        assertThrows(NumberFormatException.class, () -> app.currentMenu.promptToIntInput(""));
    }

    @Test
    void promptIsPrinted(){
        Application app = setupApplicationWithInput("1");
        app.currentMenu.promptToIntInput("Test");
        assertEquals("Test", outputArray.toString());
    }

}