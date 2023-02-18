package Charakters;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StartGameTest {

    @Test
    void Enter_your_name() throws IOException {
        StartGame ST = new StartGame();
//        ST.run(); // pokial zavolame toto vsetko za zastavi a kedze to je While loop optimalne thredom riesit run metodu

//
//        String input = "1\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);


    }

    @Test
    void check_if_name_exist_in_save_files_folder() {
        StartGame ST = new StartGame();
        assertFalse(ST.Check_if_name_exist_in_save_files_folder(""));
        assertTrue(ST.Check_if_name_exist_in_save_files_folder("Ondrej"));
    }
}