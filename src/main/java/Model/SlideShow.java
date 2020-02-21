package Model;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import static View.Constant_String.*;
import static Controller.Regex.*;

public class SlideShow extends ImageFile {

    private ArrayList<ImageFile> listImages;
    private File directory;
    protected static int delay = 1000;
    private static int counter = 0;

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

    public SlideShow(ArrayList<PictureTags> pictureTagsArrayList) {
        this.listImages = GetAllPictures(pictureTagsArrayList);
    }

    protected ImageIcon getResizedImage(ImageFile imageFile) {
        Image newImg = ((new ImageIcon(imageFile.getPath())).getImage())
                .getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public String GetPathDirectory() {
        return directory.getPath();
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

    private ArrayList<ImageFile> GetAllPictures(ArrayList<PictureTags> pictureTagsArrayList) {
        ArrayList<ImageFile> returnArray = new ArrayList<ImageFile>();
        for (PictureTags pictureTag:
             pictureTagsArrayList) {
            returnArray.add(new ImageFile(pictureTag));
        }
        return returnArray;
    }

    @Override
    public void Show() {

        this.InitImageFrame();
        counter = 0;

        final Timer timer = new Timer(delay, null);

        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //loops while timer not end all pics
                if (counter >= listImages.size()) {
                    counter = 0;
                    setVisible(false);
                    picture.removeAll();
                    timer.stop();
                }

                picture.setIcon(getResizedImage(listImages.get(counter)));
                counter += 1;
            }
        });

        add(picture);
        timer.start();
        setLayout(null);
        setSize(width, height);
        getContentPane().setBackground(Color.decode(BACKGROUND));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public int getMassArray() {
        int returnValue = 0;
        for (ImageFile imageFile:
             this.listImages) {
            returnValue += imageFile.getMass();
        }
        return returnValue;
    }

    public void keepDate(int input) {
        ArrayList<ImageFile> imageFileArrayListOut = new ArrayList<ImageFile>();
        for (ImageFile imagefile:
                this.listImages)
            if (imagefile.getDate() <= input) imageFileArrayListOut.add(imagefile);

        this.listImages = imageFileArrayListOut;
    }

    public void keepMass(int input) {
        ArrayList<ImageFile> imageFileArrayList = new ArrayList<ImageFile>();
        for (ImageFile imagefile:
                this.listImages)
            if (imagefile.getMass() <= input) imageFileArrayList.add(imagefile);

        this.listImages = imageFileArrayList;
    }

    public void keepTag(int input) {
        ArrayList<ImageFile> imageFileArrayList = new ArrayList<ImageFile>();

        for (ImageFile imagefile:
                this.listImages)
            if (imagefile.getTag().equals(NameTags.getTagById(input))) imageFileArrayList.add(imagefile);

        this.listImages = imageFileArrayList;
    }

    public ArrayList<ImageFile> getListImages() {
        return listImages;
    }

    public void setListImages(ArrayList<ImageFile> listImages) {
        this.listImages = listImages;
    }
}
