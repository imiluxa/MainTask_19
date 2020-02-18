import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SlideShow_Test extends JFrame {

    JLabel pic;
    Timer tm;
    int x = 0;
    int height = 700;
    int width = 1000;
    int delay = 3000;
    Font font = new Font("Helvetica", Font.BOLD, 40);
    String[] list = {
            "F:/external_classes/MainTask_19/src/img/1.jpg",
            "F:/external_classes/MainTask_19/src/img/2.jpg",
            "F:/external_classes/MainTask_19/src/img/3.jpg",
            "F:/external_classes/MainTask_19/src/img/4.jpg",
            "F:/external_classes//MainTask_19/src/img/5.jpg",
            ""};

    public SlideShow_Test() {
        super("Images SlideShow");
        pic = new JLabel();
        pic.setBounds(0, 0, width, height);
        pic.setForeground(Color.white);
        pic.setFont(font);

        tm = new Timer(delay, new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon ii = getResizedImage(x);
                pic.setText("File Not Found");
                x += 1;

                if (x >= list.length) {
                    x = 0;
                    pic.setText("The End");
                }

                pic.setIcon(ii);
            }
        });

        add(pic);
        tm.start();
        setLayout(null);
        setSize(width, height);
        getContentPane().setBackground(Color.decode("#3c3a2a"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SlideShow_Test();
    }

    private ImageIcon getResizedImage(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();

        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        return newImc;
    }

}