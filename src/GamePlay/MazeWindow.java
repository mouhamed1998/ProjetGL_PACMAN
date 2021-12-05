package GamePlay;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * cette class permet de construire notre interface graphique du jeu vidéo Pacman
 */
public class MazeWindow extends JFrame {

    public MazeWindow() throws FileNotFoundException, MalformedURLException, URISyntaxException {
        setTitle("GL - Projet -  Pacman");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.black); setSize(860, 780);
        setLocationRelativeTo(null);
        JLabel scoreboard = new JLabel("  Score : 0");
        //scoreboard.setLocation(new Point(24*30 +10,11*30 +10));
        scoreboard.setForeground(new Color(255, 243, 36));
        setVisible(true);
        MapNew map = new MapNew();
        map.getMapFromResource("API/mapS.txt");
        //map.adjustMap();
        map.adjustNewMap();
        GameGraphic pb = new GameGraphic(scoreboard, map, this);
        pb.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10),new LineBorder(Color.BLUE)));
        pb.setFocusable(true);
        pb.requestFocusInWindow();
        Font font = new Font("Arial", Font.BOLD , 20);
        scoreboard.setFont(font);
        this.getContentPane().add(scoreboard, BorderLayout.NORTH);
        this.getContentPane().add(pb);
        setVisible(true);
        this.addKeyListener(pb);
    }
}