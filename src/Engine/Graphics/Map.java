package Engine.Graphics;


import Engine.physics.Entity;
import Engine.physics.MovableEntity;
import Pacman.Gum;
import Pacman.Pacman;
import Pacman.Wall;
import Pacman.Ghost;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Map extends JPanel {
    int index_pacman = 0;
    int index = 0;
    //private int[][] mapGraphics;;
    public ArrayList<Entity> entities;



    public Pacman  pacman ;
    public Map(String filename) throws IOException {
        entities = new ArrayList<>();
        //mapGraphics = new int[22][6];
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
                if(c=='G'){
                    entities.add(new Ghost(new Point(j,i),1));
                    index_pacman++;
                    j++;
                }
                if(c=='g'){
                    entities.add(new Ghost(new Point(j,i),2));
                    j++;
                    index_pacman++;
                }
                if(c=='M'){
                    entities.add(new Wall(new Point(j,i)));
                    //mapGraphics[i][j]=0;
                    j++;
                    index_pacman++;
                }
                if (c=='o'){
                    entities.add(new Gum(new Point(j,i)));
                    index_pacman++;
                    j++;
                }
                if (c=='P'){
                    entities.add(new Pacman(new Point(j,i)));
                    index = index_pacman;
                    j++;
                }

                if(c==' '){
                    j++;
                }


            }
            i++;
            line = lecteurAvecBuffer.readLine();
            j=0;


        }
        }


    }
    public Entity getPacman() {
        return entities.get(index);
    }
    protected void paintComponent(Graphics g){
        super.setBackground(new Color(3, 11, 33));
        super.paintComponents(g);
         for (Entity entity :entities){
            BufferedImage myPicture = null;
            try {
                myPicture = ImageIO.read(new File(entity.getUrls()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image image = new ImageIcon(myPicture).getImage();
            int xEntiy = entity.getPixelPosition().x;
            int yEntiy = entity.getPixelPosition().y;

            g.drawImage(image,xEntiy,yEntiy,null);
        }
    }
}
