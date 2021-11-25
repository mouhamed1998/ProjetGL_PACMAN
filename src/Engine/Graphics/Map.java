package Engine.Graphics;


import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.Entity;
import Engine.physics.movement.MovableEntity;
import Pacman.Gum;
import Pacman.Pacman;
import Pacman.Wall;
import Pacman.Ghost;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Map extends JPanel {
    int index_pacman = 0;
    int index = 0;
    ArrayList<Wall> walls = new ArrayList<>();
    MapNew mapNew  = new MapNew();
    int[][] map = mapNew.getMapGraphic();
    Image[] mapSegments;
    //private int[][] mapGraphics;;
    public  static  ArrayList<Entity> entities;

    public Pacman pacman ;
    void initImage() {
        setBackground(Color.black);
        mapSegments = new Image[28];
        mapSegments[0] = null;
        for(int ms=1;ms<27;ms++){
            try {
                URL path = this.getClass().getClassLoader().getResource("Image/map_segments/"+ms+".png");
                mapSegments[ms] = new ImageIcon(path).getImage();
            }catch(Exception e){
                System.out.println("ms: " + ms);
                e.printStackTrace();
            }
        }
    }
    public Map(){
        //initImage();
    }
    public void getResources(String filename) throws IOException {
        mapNew.getMapFromResource("src/API/MapSecondaire");
        for(Point mapPoint : mapNew.getWallPositions()) {
            Wall wall = new Wall(mapPoint);
            wall.setImage(mapSegments[map[mapPoint.y][mapPoint.x]]);
            walls.add(wall);
        }
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
                    walls.add(new Wall(new Point(j,i)));
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
                    entities.add(new Pacman(new Point(j,i), this));
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
    CollisionMap collisionMap = new CollisionMap();
    public ArrayList<Entity> getEntities() {
        return entities;
    }
    JLabel imageLabel = new JLabel();
    protected void paintComponent(Graphics g){

        pacman = (Pacman) getPacman();

        super.setBackground(new Color(3, 11, 33));
        super.paintComponents(g);
        for (Entity entity :entities){
            BufferedImage myPicture = null;

            if(entity == pacman){
                //this.remove(imageLabel);
                int xEntiy = entity.getPixelPosition().x;
                int yEntiy = entity.getPixelPosition().y;
                //g.fillOval(xEntiy,yEntiy,pacman.getPixelPosition().x,pacman.getCurrentPosition().y);
                //System.out.println("okoui");
                ImageIcon image = new ImageIcon(entity.getUrls());
                imageLabel.setIcon(image);
                imageLabel.setBounds(xEntiy,yEntiy,image.getIconWidth(),image.getIconHeight());
                this.add(imageLabel);
            }
            else {
                Image image = entity.getImage();
                int xEntiy = entity.getPixelPosition().x;
                int yEntiy = entity.getPixelPosition().y;
                g.drawImage(image,xEntiy,yEntiy,null);
            }


        }


        for (Wall wall :walls){
            collisionMap.collisionWithWall(pacman,wall);
        }
        pacman.verifyNextDirection(walls);
        pacman.move();
        /*
        for (Entity entity : entities){
            collisionMap.CollisionWithWall(pacman, entity);
        }

         */

    }
}
