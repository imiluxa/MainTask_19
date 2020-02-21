package Controller;

import Model.*;
import View.*;

import java.util.ArrayList;
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
    private SlideShow slideShow;

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
        fillArrays();

        processMenu(sc);
    }

    public Locale chooseLanguage(Scanner scanner){

        return Integer.parseInt(inputValueWithScanner(scanner, INPUT_LANGUAGE, REGEX_LANGUAGE)) == 1
                        ? new Locale("en") : new Locale("ua");

    }

    public void fillArrays() {
        /*
        model.addDateRange(Date_Range.TODAY);
        model.addDateRange(Date_Range.THISWEEK);
        model.addDateRange(Date_Range.THISMONTH);
        model.addDateRange(Date_Range.THISYEAR);
        model.addFileMass(FileMass.LESSONEMB);
        model.addFileMass(FileMass.LESSTHREEMB);
        model.addFileMass(FileMass.LESSTENMB);
        model.addFileMass(FileMass.LESSGB);
        */
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
    }

    public void processMenu(Scanner sc) {
        //File directory = new File ("F:\\external_classes\\MainTask_19\\src\\img");
        //System.out.println(PATH + "4.jpg");
        //ImageFile imageFile = new ImageFile(PATH + "4.jpg");
        //imageFile.Show();



        boolean exitFlag = false;
        int chooser = 0;
        slideShow = new SlideShow(model.getPictureTagsList());

        while (!exitFlag) {
            chooser = 0;
            while (chooser < 1 || chooser > 5) {
                chooser = Integer.parseInt(inputValueWithScanner(sc, INPUT_STRING_DATA, REGEX_NUMBER));
            }

            switch (chooser) {
                case 1:
                    slideShow.Show();
                    break;
                case 2:
                    slideShow.setListImages(keepDate(Integer.parseInt(inputValueWithScanner(sc, INPUT_STRING_DATES, REGEX_NUMBER))
                            , slideShow.getListImages()));
                    //view.printMessage(INPUT_STRING_DATA);
                    break;
                case 3:
                    slideShow.keepMass(Integer.parseInt(inputValueWithScanner(sc, INPUT_STRING_MASS, REGEX_NUMBER)));
                    //view.printMessage(INPUT_STRING_DATA);
                    break;
                case 4:
                    System.out.print("Get back!");
                    break;
                case 5:
                    exitFlag = true;
                    break;
            }



        }






        //slideShow.printAllObjectsInListImages();

    }

    public ArrayList<ImageFile> keepDate(int input, ArrayList<ImageFile> imageFileArrayList) {
        ArrayList<ImageFile> imageFileArrayListOut = new ArrayList<ImageFile>();
        for (ImageFile imagefile:
                imageFileArrayList)
            if (imagefile.getDate() <= input) imageFileArrayListOut.add(imagefile);

        return imageFileArrayListOut;
    }

}
