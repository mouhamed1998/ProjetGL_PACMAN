package Engine.Graphics;

import Engine.Input.KeyBorad;
import Pacman.Pacman;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MazeWindow extends JFrame {
    Pacman pacman ;
    public MazeWindow() throws IOException, InterruptedException {
        setTitle("GL-Projet-PACMAN");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(860, 780);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(19, 53, 170));


        Map map = new Map();
        map.getResources("src/API/mapS.txt");
        this.pacman = map.getPacman();
        System.out.println("score "+ map.getScore());
        //JLabel scoreboard = new JLabel(" Score : " + map.getScore());
        //System.out.println("cooredodenees pacman " + pacman.getPixelPosition().x + " " + pacman.getPixelPosition().y);
        getContentPane().add(map.getJlabelScore(),BorderLayout.SOUTH);
        getContentPane().add(map.getJlabelLife(),BorderLayout.NORTH);
        getContentPane().add(map, BorderLayout.CENTER);
        //getContentPane().add(scoreboard, BorderLayout.SOUTH);
        getContentPane().setBackground(new Color(3, 11, 33));
        this.addKeyListener(new KeyBorad(pacman));
        setVisible(true);
        System.out.println();
        /*
        while (true){
            repaint();
        }

         */



    }

}
