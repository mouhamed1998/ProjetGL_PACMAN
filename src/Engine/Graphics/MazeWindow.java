package Engine.Graphics;

import Engine.Input.KeyBorad;
import Engine.physics.movement.MovableEntity;
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
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(19, 53, 170));
        JLabel scoreboard = new JLabel(" Score : 0");
        //scoreboard.setForeground(new Color(19, 53, 170));
        Map map = new Map();
        map.getResources("src/API/mapS.txt");
        this.pacman = map.getPacman();
        //System.out.println("cooredodenees pacman " + pacman.getPixelPosition().x + " " + pacman.getPixelPosition().y);
        getContentPane().add(map, BorderLayout.CENTER);
        getContentPane().add(scoreboard, BorderLayout.SOUTH);
        getContentPane().setBackground(new Color(19, 53, 170));
        this.addKeyListener(new KeyBorad(pacman));
        setVisible(true);
        /*
        while (true){
            repaint();
        }*/



    }

}
