package Model;

//import ImageFile;
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
    protected static int delay = 2500;
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

    protected ImageIcon getResizedImage(ImageFile imageFile) {
        Image newImg = ((new ImageIcon(imageFile.getPath())).getImage())
                .getScaledInstance(this.picture.getWidth(), this.picture.getHeight(), Image.SCALE_SMOOTH);
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

    @Override
    public void Show() {

        this.InitImageFrame();
        counter = 0;

        final Timer timer = new Timer(delay, null);

        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //loops while timer not end all pics
                counter += 1;
                if (counter >= listImages.size()) {
                    counter = 0;
                    //picture.hide();
                    dispose();
                    timer.stop();
                }
                picture.setIcon(getResizedImage(listImages.get(counter)));
            }

        });

        add(this.picture);
        timer.start();
        setLayout(null);
        setSize(width, height);
        getContentPane().setBackground(Color.decode(BACKGROUND));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
