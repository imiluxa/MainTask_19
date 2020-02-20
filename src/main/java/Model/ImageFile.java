package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static View.Constant_String.*;

public class ImageFile extends JFrame{

    private String path;
    protected static JLabel picture;
    //Hardcode
    protected static int height = 700;
    protected static int width = 1000;
    protected static Font font = new Font(FONT, Font.BOLD, 40);

    //Constructor

    public ImageFile() throws HeadlessException {
        super(TITLE);
    }

    public ImageFile(String path) throws HeadlessException {
        super(TITLE);
        this.path = path;
    }

    //Resize Image to Frame Sizes
    protected ImageIcon getResizedImage() {
                Image newImg = ((new ImageIcon(this.path)).getImage())
                            .getScaledInstance(this.picture.getWidth(), this.picture.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    protected void InitImageFrame() {
        this.picture = new JLabel();
        this.picture.setBounds(0, 0, width, height);
        this.picture.setForeground(Color.white);
        this.picture.setFont(font);
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

}
