package Engine.Graphics;


import Pacman.Gum;
import Pacman.Pacman;
import Pacman.Wall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Map extends JPanel {

    private int[][] mapGraphics;
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Gum> gums = new ArrayList<>();
    public ArrayList<Pacman> pacmen = new ArrayList<>();

    public Map(String filename) throws IOException {
        BufferedReader reader;
        //mapGraphics = new int[][]
        BufferedReader lecteurAvecBuffer = null;
        String ligne;

        try
        {
            lecteurAvecBuffer = new BufferedReader(new FileReader(filename));
        }
        catch(FileNotFoundException exc)
        {
            System.out.println("Erreur d'ouverture");
        }
        String line = lecteurAvecBuffer.readLine();;
        int i= 0;
        int j=0;
        while ((line !=null )){{

            for (char c : line.toCharArray()){
                System.out.println(c);
                if(c=='M'){
                    walls.add(new Wall(new Point(j,i)));
                    j++;
                }
                if (c=='o'){
                    gums.add(new Gum(new Point(j,i)));
                    j++;
                }
                if (c=='P'){
                    pacmen.add(new Pacman(new Point(j,i)));
                    j++;
                }
            }
            line = lecteurAvecBuffer.readLine();
            j=0;
            i++;

        }
        }


    }
    public void setComponent(JPanel jPanel) throws IOException {
        for (Gum gum :gums){
            BufferedImage myPicture = ImageIO.read(new File("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/Projet2/ressource/pacman_img/wall.jpeg"));
            ImageIcon image = new ImageIcon(myPicture);
            jPanel.add(new JLabel(image));
        }
    }

    protected void paintComponent(Graphics g){
        super.setBackground(new Color(59, 165, 92));
        super.paintComponents(g);
        System.out.println(gums.size());
        System.out.println(walls.size());
        for (Gum gum :gums){
            BufferedImage myPicture = null;
            try {
                myPicture = ImageIO.read(new File("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/Projet2/src/src/API/ressource/pacman_img/big_gum.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image image = new ImageIcon(myPicture).getImage();
            g.drawImage(image,gum.getPixelPosition().x, gum.getPixelPosition().y,this);
        }


        for (Wall wall :walls){
            BufferedImage myPicture = null;
            try {
                myPicture = ImageIO.read(new File("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/Projet2/src/src/API/ressource/pacman_img/wall.jpeg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image image = new ImageIcon(myPicture).getImage();
            g.drawImage(image,wall.getPixelPosition().x, wall.getPixelPosition().y,this);
        }
        for (Pacman pacman :pacmen){
            BufferedImage myPicture = null;
            try {
                myPicture = ImageIO.read(new File("/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/Projet2/src/src/API/ressource/pacman_img/pac_right.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image image = new ImageIcon(myPicture).getImage();
            g.drawImage(image,pacman.getPixelPosition().x, pacman.getPixelPosition().y,this);
        }
    }
}
