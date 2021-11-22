package Engine.Graphics;

import Engine.Input.KeyBorad;
import Engine.physics.movement.MovableEntity;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MazeWindow extends JFrame {
    MovableEntity pacman ;
    public MazeWindow() throws IOException {
        setTitle("GL-Projet-PACMAN");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(860, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(19, 53, 170));
        JLabel scoreboard = new JLabel(" Score : 0");
        //scoreboard.setForeground(new Color(19, 53, 170));
        Map map = new Map("src/API/map");
        this.pacman = (MovableEntity) map.getPacman();
        System.out.println(pacman.getDirection());
        //System.out.println("cooredodenees pacman " + pacman.getPixelPosition().x + " " + pacman.getPixelPosition().y);
        getContentPane().add(map, BorderLayout.CENTER);
        getContentPane().add(scoreboard, BorderLayout.SOUTH);
        getContentPane().setBackground(new Color(19, 53, 170));
        this.addKeyListener(new KeyBorad(pacman));
        setVisible(true);
        while (true){
            repaint();
        }
    }

}
