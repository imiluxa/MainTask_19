package Controller;

import Model.Model;
import View.View;

import static Controller.StringConstants.*;

import java.io.File;

public class Controller {

    //Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void processUser() {
        //File directory = new File ("F:\\external_classes\\MainTask_19\\src\\img");
        //System.out.println(PATH + "4.jpg");
        //ImageFile imageFile = new ImageFile(PATH + "4.jpg");
        //imageFile.Show();

        SlideShow slideShow = new SlideShow();
        slideShow.printAllObjectsInListImages();

    }

}
