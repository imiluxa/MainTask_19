package Controller;

import Model.*;
import View.*;

import java.util.Locale;
import java.util.Scanner;

import static View.Constant_String.*;
import static Controller.Regex.*;

public class Controller {

    //Constructor
    private Model model;
    private View view;
    public static Scanner sc;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public String inputValueWithScanner(Scanner scanner, String message, String regex){
        String returnString;
        view.printMessage(message);

        while( !(scanner.hasNext() && (returnString = scanner.next()).matches(regex))) {
            view.printMessage(INPUT_ERROR);
            view.printMessage(INPUT_LANGUAGE);
        }

        return returnString;
    }

    public void processUser() {
        sc = new Scanner(System.in);
        view.setLocale(chooseLanguage(sc));
        processMenu(sc);
    }

    public Locale chooseLanguage(Scanner scanner){

        return Integer.parseInt(inputValueWithScanner(scanner, INPUT_LANGUAGE, REGEX_LANGUAGE)) == 1
                        ? new Locale("en") : new Locale("ua");

    }

    public void processMenu(Scanner sc) {
        //File directory = new File ("F:\\external_classes\\MainTask_19\\src\\img");
        //System.out.println(PATH + "4.jpg");
        //ImageFile imageFile = new ImageFile(PATH + "4.jpg");
        //imageFile.Show();
        boolean exitFlag = false;

        while (!exitFlag) {
            break;
        }

        SlideShow slideShow = new SlideShow();
        slideShow.Show();

        //slideShow.printAllObjectsInListImages();

    }

}
