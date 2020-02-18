package Controller;

import javax.swing.*;
import java.awt.*;

import static Controller.StringConstants.*;

public class ImageFile extends JFrame{

    private String path;
    private JLabel picture;
    //Hardcode
    private int height = 700;
    private int width = 1000;
    private int delay = 3000;
    private Font font = new Font(FONT, Font.BOLD, 40);

    //Constructor

    public ImageFile() throws HeadlessException {
        super(TITLE);
        this.picture = new JLabel();
        this.picture.setBounds(0, 0, width, height);
        this.picture.setForeground(Color.white);
        this.picture.setFont(font);
    }

    public ImageFile(String path) throws HeadlessException {
        super(TITLE);
        this.path = path;
        this.picture = new JLabel();
        this.picture.setBounds(0, 0, width, height);
        this.picture.setForeground(Color.white);
        this.picture.setFont(font);
    }

    //Resize Image to Frame Sizes
    private ImageIcon getResizedImage() {
        Image newImg = ((new ImageIcon(this.path)).getImage())
                            .getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    //Show picture. In child class will be showed slide-show
    public void Show() {

        add(picture);
        picture.setIcon(getResizedImage());
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

    @Override
    public String toString() {
        return this.getPath();
    }
}
