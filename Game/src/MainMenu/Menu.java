package MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Alexander Šimko
 */
public abstract class Menu {
    /*
     * toto je urcene pre citanie kedze riadok sa musi opakovat
     *  vsade kde treba ineco citat tak je zadefinovani ako global public
     */
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private boolean print = true;
    private boolean exit;

    public void run() throws IOException {
        exit = false;


        while (exit == false) {
            System.out.println();
            print();
            System.out.println();

            String line = br.readLine();
            if (line == null) {
                return;
            }

            System.out.println();

            handle(line);
        }
    }

    public void exit() {
        exit = true;
    }
    /*
    * toto je urcene pre zrusenie pritovania vela dat ktore netreba pre test s velkimi datami
    */
    public void setPrint(){
        if(print==true ){
            System.out.println("Printing is NOTALLOWED");
            print = false;
        }else{
            System.out.println("Printing is ALLOWED");
            print = true;
        }
    }
    public boolean getPrint(){return print;  }
    public abstract void print();

    public abstract void handle(String option);	
}