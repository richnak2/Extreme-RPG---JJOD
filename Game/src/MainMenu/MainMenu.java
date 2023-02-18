package MainMenu;

import Charakters.StartGame;

/**
 *
 * @author Ondrej Richnak
 */
public class MainMenu extends Menu {

    @Override
    public void print() {
        System.out.println("*********************************");
        System.out.println("* 1. Start Game                 *");
        System.out.println("* 2. Load Game                  *");
        System.out.println("* 3. exit                       *");
        System.out.println("*********************************");
    }

    @Override
    public void handle(String option) {
        try {
            switch (option) {
                case "1":
                    StartGame ST = new StartGame();
                    ST.run();
                    break;
                case "2":
                    throw new Exception("Not implemented 2");
                case "3":
                    exit();
                    break;
                default:
                    System.out.println("Unknown option");
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}