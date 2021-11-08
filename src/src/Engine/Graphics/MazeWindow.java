package moteur.moteurGRaphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MazeWindow extends JFrame {


    public MazeWindow() throws IOException {
        setTitle("GL-Projet-PACMAN");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(860, 700);

        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        JLabel scoreboard = new JLabel(" Score : 0");
        scoreboard.setForeground(new Color(59, 165, 92));
        getContentPane().add(new moteurGRaphique.Map("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/Projet2/ressource/map"), BorderLayout.CENTER);
        getContentPane().add(scoreboard, BorderLayout.SOUTH);
        /*
        Image img = new ImageIcon("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/Projet2/pacman_img/pacman_left.jpg").getImage();
        JPanel j = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("/Users/ousmanecisse/Downloads/pngwing.com_1.png"));
        ImageIcon image = new ImageIcon(myPicture);
        getContentPane().add(new JLabel(image));


         */


        setVisible(true);


    }

}
