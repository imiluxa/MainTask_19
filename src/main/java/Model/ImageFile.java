package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static View.Constant_String.*;

public class ImageFile extends JFrame{

    private String path;
    private String name;
    private int date;



    private int mass;
    private String tag;

    protected static JLabel picture = new JLabel();
    //Hardcode
    protected static int height = 700;
    protected static int width = 1000;
    protected static Font font = new Font(FONT, Font.BOLD, 40);

    //Constructor

    public ImageFile() throws HeadlessException {
        super(TITLE);
    }

    public ImageFile(String name, int date, int mass, String tag) throws HeadlessException {
        super(TITLE);
        this.name = name;
        this.date = date;
        this.mass = mass;
        this.tag = tag;
    }

    public ImageFile(PictureTags pictureTags) throws HeadlessException {
        super(TITLE);
        File file = new File(PATH);
        this.name = pictureTags.getMainName();
        this.path = file.getAbsolutePath() + "\\" + pictureTags.getMainName();
        this.date = pictureTags.getDate();
        this.mass = pictureTags.getMass();
        this.tag = pictureTags.getTag();
    }

    public ImageFile(String path) throws HeadlessException {
        super(TITLE);
        this.path = path;
        File file = new File(path);
        this.name = file.getName();
    }

    //Resize Image to Frame Sizes
    protected ImageIcon getResizedImage() {
                Image newImg = ((new ImageIcon(this.path)).getImage())
                            .getScaledInstance(this.picture.getWidth(), this.picture.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    protected void InitImageFrame() {

        picture.setBounds(0, 0, width, height);
        picture.setForeground(Color.white);
        picture.setFont(font);
    }

    //Show picture. In child class will be showed slide-show
    public void Show() {

        this.InitImageFrame();

        add(this.picture);


        this.picture.setIcon(getResizedImage());
        setLayout(null);
        setSize(width, height);
        getContentPane().setBackground(Color.decode(BACKGROUND));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getNameImage() { return name; }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

}
