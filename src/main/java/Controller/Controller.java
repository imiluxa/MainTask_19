package Controller;

import Model.*;
import View.*;

import java.util.GregorianCalendar;
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

    public void fillArrays() {
        model.addDateRange(Date_Range.TODAY);
        model.addDateRange(Date_Range.THISWEEK);
        model.addDateRange(Date_Range.THISMONTH);
        model.addDateRange(Date_Range.THISYEAR);
    }

    public void processMenu(Scanner sc) {
        //File directory = new File ("F:\\external_classes\\MainTask_19\\src\\img");
        //System.out.println(PATH + "4.jpg");
        //ImageFile imageFile = new ImageFile(PATH + "4.jpg");
        //imageFile.Show();
        fillArrays();

        System.out.println(Model.getDate_rangeList().toString());

        for (Date_Range a: Model.getDate_rangeList()
             ) {
            System.out.println(a.name() + " " + a.getDayBack());
        }

        /*
        boolean exitFlag = false;
        int chooser = 0;
        SlideShow slideShow = new SlideShow();

        while (!exitFlag) {


            while (chooser <= 1 || chooser > 5) {
                chooser = Integer.parseInt(inputValueWithScanner(sc, INPUT_STRING_DATA, REGEX_NUMBER));
            }

            switch (chooser) {
                case (1): slideShow.Show();
                case (2):
            }

            break;
        }
*/



        //slideShow.printAllObjectsInListImages();

    }

}
