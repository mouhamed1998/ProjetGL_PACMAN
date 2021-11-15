package Engine.Graphics;

import Engine.Input.KeyBorad;
import Engine.physics.Entity;
import Engine.physics.MovableEntity;
import Pacman.Pacman;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MazeWindow extends JFrame implements KeyListener {
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
        Map map = new Map("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/Projet2/src/API/map");
        this.pacman = (MovableEntity) map.getPacman();
        getContentPane().add(map, BorderLayout.CENTER);
        System.out.println(pacman.getSpeed());
                getContentPane().add(scoreboard, BorderLayout.SOUTH);
        getContentPane().setBackground(new Color(19, 53, 170));
        getContentPane().addKeyListener(new KeyBorad(pacman));
        /*
        Image img = new ImageIcon("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/Projet2/pacman_img/pacman_left.jpg").getImage();
        JPanel j = new JPanel();
        BufferedImage myPicture = ImageIO.read(new File("/Users/ousmanecisse/Downloads/pngwing.com_1.png"));
        ImageIcon image = new ImageIcon(myPicture);
        getContentPane().add(new JLabel(image));


         */
        //this.addKeyListener(new KeyBorad(pacman));
        this.addKeyListener(this);

        setVisible(true);



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent event){
        int key = event.getKeyCode();
        if(key == KeyEvent.VK_UP){
            System.out.println("UP");
            this.pacman.goUp();
            this.pacman.move();
            this.repaint();
        }
        if(key == KeyEvent.VK_DOWN){
            System.out.println("DOWN");
            this.pacman.goDown();
            this.pacman.move();
            this.repaint();

        }
        if(key == KeyEvent.VK_LEFT){
            System.out.println("LEFT");
            this.pacman.goLeft();
            this.pacman.move();
            this.repaint();
        }
        if(key == KeyEvent.VK_RIGHT){
            System.out.println("RIGHT");
            this.pacman.goRight();
            this.pacman.move();
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
