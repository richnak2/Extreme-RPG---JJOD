package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeroCreator {

    static final String SUCCESS_MESSAGE = "-Hero was successfully created.";

    static void createHero() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Character hero = new Character();

        String name = getName(in);
        hero.setName(name);
        setRace(in);
        setProfession(in);

        System.out.println(SUCCESS_MESSAGE);
    }

    private static String getName(BufferedReader in) {
        System.out.println("Enter hero name: ");
        try {
            return in.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static boolean checkName(String name) {
        //TODO
        return true;
    }

    private static void setRace(BufferedReader in) {
        System.out.println("Enter hero race number: ");
        Printer.printRaces();
        int race_id = Integer.parseInt(in.readLine());

        try {
            Race.findById(race_id); //skusi najst zadanu rasu
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        character.setRace_id(race_id);
    }

    private static void setProfession(BufferedReader in) {
        System.out.println("Enter hero profession number: ");
        Printer.printRaces();
        int race_id = Integer.parseInt(in.readLine());

        try {
            Race.findById(race_id); //skusi najst zadanu rasu
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        character.setRace_id(race_id);
    }
}
