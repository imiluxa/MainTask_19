package Controller;

import Model.*;
import View.*;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static View.Constant_String.*;
import static Controller.Regex.*;

public class Controller {

    //Constructor
    private Model model;
    private View view;
    public static Scanner sc;
    private SlideShow slideShow;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void processUser() {
        sc = new Scanner(System.in);
        view.setLocale(chooseLanguage(sc));
        fillArrays();

        processMenu(sc);
        slideShow.dispose();
    }

    public Locale chooseLanguage(Scanner scanner){

        return Integer.parseInt(inputValueWithScanner(scanner, INPUT_LANGUAGE, REGEX_LANGUAGE)) == 1
                        ? new Locale("en") : new Locale("ua");
    }

    public void fillArrays() {
        model.addPictureTags(PictureTags.ONE);
        model.addPictureTags(PictureTags.TWO);
        model.addPictureTags(PictureTags.THREE);
        model.addPictureTags(PictureTags.FOUR);
        model.addPictureTags(PictureTags.FIVE);
        model.addPictureTags(PictureTags.SIX);
        model.addPictureTags(PictureTags.SEVEN);
        model.addPictureTags(PictureTags.EIGHT);
        model.addPictureTags(PictureTags.NINE);
        model.addPictureTags(PictureTags.TEN);
        model.addNameTag(NameTags.ANIMALS);
        model.addNameTag(NameTags.WORLD);
        model.addNameTag(NameTags.GOT);
        model.addNameTag(NameTags.MEMS);
    }

    public void processMenu(Scanner sc) {

        boolean exitFlag = false;
        int chooser = 0;
        slideShow = new SlideShow(Model.getPictureTagsList());

        while (!exitFlag) {
            chooser = 0;
            while (chooser < 1 || chooser > 5) {
                chooser = Integer.parseInt(inputValueWithScanner(sc, INPUT_STRING_DATA, REGEX_NUMBER));
            }

            switch (chooser) {
                case 1:
                    slideShow.Show();
                    view.printMessage(INPUT_STRING_SIZE);
                    view.print(String.valueOf(slideShow.getMassArray()));
                    break;
                case 2:
                    slideShow.keepDate(Integer.parseInt(inputValueWithScanner(sc, INPUT_STRING_DATES, REGEX_NUMBERS)));
                    break;
                case 3:
                    slideShow.keepMass(Integer.parseInt(inputValueWithScanner(sc, INPUT_STRING_MASS, REGEX_NUMBERS)));
                    break;
                case 4:
                    slideShow.keepTag(Integer.parseInt(inputValueWithScanner(sc, INPUT_STRING_TAGS, REGEX_NUMBER)));
                    break;
                case 5:
                    exitFlag = true;
                    break;
            }

        }

    }

    public String inputValueWithScanner(Scanner scanner, String message, String regex){
        String returnString;
        view.printMessage(message);

        while( !(scanner.hasNext() && (returnString = scanner.next()).matches(regex))) {
            view.printMessage(INPUT_ERROR);
        }

        return returnString;
    }

}
