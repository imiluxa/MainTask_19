package Controller;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static Controller.StringConstants.*;

public class SlideShow extends ImageFile {

    private ArrayList<ImageFile> listImages;
    private File directory;

    public SlideShow() throws HeadlessException {
        super();
        this.directory = new File(PATH);
        this.listImages = GetAllPictures(this.directory);
    }

    public SlideShow(String directory) throws HeadlessException {
        super();
        this.directory = new File(directory);
        this.listImages = GetAllPictures(this.directory);
    }

    public String GetPathDirectory() {
        return directory.getPath();
    }

    public void printAllObjectsInListImages() {
        listImages.toString();
    }

    private ArrayList<ImageFile> GetAllPictures(File directory) throws ExceptionHasMessage {
        ArrayList<ImageFile> returnArray = new ArrayList<ImageFile>();
        if(directory.isDirectory()) {
            //get all items in path
            for(File item : directory.listFiles()) {
                if (!item.isDirectory()) {
                    if (item.getName().matches(IMAGE_PATTERN)) {
                        returnArray.add(new ImageFile(item.getAbsolutePath()));
                    }
                }
            }
        }
        return returnArray;
    }
}
