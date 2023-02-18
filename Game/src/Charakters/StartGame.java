package Charakters;

import MainMenu.Menu;

import java.io.IOException;

public class StartGame extends Menu {

    @Override
    public void print() {
        System.out.println("****  SELECT YOUR CHARACTER  ****");
        System.out.println("* 1. Warrior                    *");
        System.out.println("* 2. Mage                       *");
        System.out.println("* 3. Archer                     *");
        System.out.println("* 4. Info about characters      *");
        System.out.println("* 5. exit                       *");
        System.out.println("*********************************");
    }

    @Override
    public void handle(String option) {
        try {
            switch (option) {
                case "1":
                    Enter_your_name();
                    break;

                case "2":
                    throw new Exception("Not implemented 2");
                case "3":
                    throw new Exception("Not implemented 3");
                case "4":
                    Info_about_characters();
                    break;
                case "5":
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
    private void Info_about_characters(){
        System.out.println("Warrior Stats");
        System.out.println("Attack 10");
        System.out.println("Defense 10");
        System.out.println("Doge 10");
        System.out.println("Block 10");
        System.out.println("Health 100");
        System.out.println();
        System.out.println("Other classes needs to be added here");
    }
    public void Enter_your_name() throws Exception {
        System.out.print("Please enter your name: ");
        String player_name = br.readLine(); // mam este niake validatori na vseobecne vstupi ak bude treba pitajte sa...


        if (Check_if_name_exist_in_save_files_folder(player_name)){
            throw new Exception("Abstract class for character not implemented ");
        }
    }
    public boolean Check_if_name_exist_in_save_files_folder(String player_name) {
        if (player_name.isEmpty()) {
            System.out.println("Your name must be at least 1 charakter long");
            return false;
        } else if (player_name.length() >= 1) {
            // tuna treba tu kontrolu priecinku suborov
            return true;
        }else{
            return false;
        }
    }
}