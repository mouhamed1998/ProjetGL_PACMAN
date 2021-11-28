package Engine.Graphics;


import Engine.physics.Collision.CollisionCircle;
import Engine.physics.Collision.CollisionMap;
import Engine.physics.Collision.CollisionRectangle;
import Engine.physics.movement.Entity;

import Pacman.Gum;
import Pacman.Pacman;
import Pacman.Wall;
import Pacman.Ghost;

import Engine.physics.movement.ImmovableEntity;
import Engine.physics.movement.MovableEntity;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Map extends JPanel {

    int index_pacman = 0;
    int index = 0;
    public static ArrayList<ImmovableEntity> walls = new ArrayList<>();
    MapNew mapNew  = new MapNew();
    int[][] map ;
    Image[] mapSegments = new Image[28];;
    ArrayList<ImmovableEntity> foods;
    ArrayList<ImmovableEntity> pufoods;
    ArrayList<MovableEntity> ghosts;
    Image foodImage;
    Image[] pfoodImage;
    private JLabel jlabelScore;
    private JLabel jlabelLife;
    public int score = 0;
    public int life =3;
    private boolean isfirest;
    public int getScore(){
        return score;
    }
    public  static  ArrayList<Entity> entities;
    public MovableEntity pacman ;
    void initImage() {
        mapNew.getMapFromResource("src/API/mapS.txt");
        mapNew.adjustNewMap();
        map =mapNew.getMapGraphic();
        setBackground(Color.black);
        mapSegments[0] = null;
        for(int ms=1;ms<27;ms++){
            try {
                String path = "src/API/ressource/pacman_img/Image/map_segments/"+ms+".png";
                mapSegments[ms] = new ImageIcon(path).getImage();
            }catch(Exception e){
                System.out.println("ms: " + ms);
                e.printStackTrace();
            }
        }
        for(Point mapPoint : mapNew.getWallPositions()) {
            ImmovableEntity wall = new ImmovableEntity(mapPoint);
            wall.setImage(mapSegments[map[mapPoint.y][mapPoint.x]]);
            walls.add(wall);
        }
        pfoodImage = new Image[5];
        for(int ms=0 ;ms<5;ms++){
            try {
                String path =("src/API/ressource/pacman_img/Image/Coin/fruit-"+ms+".png");
                pfoodImage[ms] = new ImageIcon(path).getImage();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        try{
            String path = ("src/API/ressource/pacman_img/Image/Coin/coin-normal.png");
            foodImage = new ImageIcon(path).getImage();
            //goImage = ImageIO.read(this.getClass().getResource("resources/images/gameover.png"));
            //vicImage = ImageIO.read(this.getClass().getResource("resources/images/victory.png"));
            //pfoodImage = ImageIO.read(this.getClass().getResource("/images/pfood.png"));
        }catch(Exception e){}
    }

    public JLabel getJlabelLife() {
        return jlabelLife;
    }

    void initEntity(){
        foods = new ArrayList<>();
        pufoods = new ArrayList<>();
        ghosts = new ArrayList<>();
        for(Point foodPosition: mapNew.getCoinPositions()) {
            foods.add(new ImmovableEntity(new Point(foodPosition.x, foodPosition.y)));
        }
        for(Point puFood : mapNew.getPuCoinPositions()) {
            ImmovableEntity coin = new ImmovableEntity(new Point(puFood.x, puFood.y));
            int random = new Random().nextInt(5);
            coin.setImage(pfoodImage[random]);
            pufoods.add(coin);

        }
        this.pacman = new MovableEntity(mapNew.getPacmanPosition(), this);
        //foods = new ArrayList<>();
        //pufoods = new ArrayList<>();
        ghosts = new ArrayList<>();
        //walls = new ArrayList<>();

        ghosts = new ArrayList<>();
        ghosts.addAll(mapNew.getGhostsData());

    }
    public Map(){
        jlabelScore = new JLabel("Score:"+getScore());
        jlabelLife = new JLabel("Life:"+life);
        jlabelLife.setLocation(new Point(11*30 +10,30));
        jlabelLife.setLocation(new Point(24*30 +10,11*30 +10));
        initImage();
        initEntity();
    }


    public void getResources(String filename) throws IOException {

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
                    entities.add(new MovableEntity(new Point(j,i),1));
                    index_pacman++;
                    j++;
                }
                if(c=='g'){
                    entities.add(new MovableEntity(new Point(j,i),2));
                    j++;
                    index_pacman++;
                }
                if(c=='M'){
                    entities.add(new ImmovableEntity(new Point(j,i)));
                    //walls.add(new Wall(new Point(j,i)));
                    //mapGraphics[i][j]=0;
                    j++;
                    index_pacman++;
                }
                if (c=='o'){
                    entities.add(new ImmovableEntity(new Point(j,i)));
                    index_pacman++;
                    j++;
                }
                if (c=='P'){
                    entities.add(new MovableEntity(new Point(j,i), this));
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
    public MovableEntity getPacman(){
        return pacman;
    }
    /*
    public Entity getPacman() {
        return entities.get(index);
    }

     */
    CollisionMap collisionMap = new CollisionMap();
    public ArrayList<Entity> getEntities() {
        return entities;
    }
    JLabel imageLabel = new JLabel();
    CollisionCircle collisionCircle = new CollisionCircle();
    CollisionRectangle collisionRectangle = new CollisionRectangle();

    public JLabel getJlabelScore() {
        return jlabelScore;
    }

    protected void paintComponent(Graphics g){

        super.setBackground(new Color(3, 11, 33));
        super.paintComponents(g);
        for (ImmovableEntity wall : walls) {
            g.drawImage(wall.getImage(), wall.getPixelPosition().x, wall.getPixelPosition().y, null);
        }
        for(MovableEntity gh : ghosts) {
            Image ghostImage = gh.getImage();
            int xGhost = gh.getPixelPosition().x;
            int yGhost = gh.getPixelPosition().y;
            g.drawImage(ghostImage, xGhost, yGhost, null);
        }
        int xPacman = pacman.getPixelPosition().x;
        int yPacman = pacman.getPixelPosition().y;
        g.drawImage(pacman.getImage(), xPacman, yPacman, null);

        for(Gum f : foods){

        g.setColor(new Color(204, 122, 122));
        for(ImmovableEntity f : foods){
            //g.fillOval(f.position.x*28+22,f.position.y*28+22,4,4);

            int x = f.getPixelPosition().x;
            int y = f.getPixelPosition().y;
            g.drawImage(foodImage, x, y, null);
        }


        for(Gum f : pufoods){
        //Draw PowerUpFoods
        g.setColor(new Color(204, 174, 168));
        for(ImmovableEntity f : pufoods){

            //g.fillOval(f.position.x*28+20,f.position.y*28+20,8,8);
            int x = f.getPixelPosition().x;
            int y = f.getPixelPosition().y;
            g.drawImage(f.getImage(), x, y,null);
        }
        for(Gum gum: pufoods){
            if(collisionCircle.isCollision(pacman, gum)){
                pufoods.remove(gum);
                score +=10;
                jlabelScore.setText("Score:"+getScore());
                break;
            }

        }
        for(Gum gum: foods){
            if(collisionCircle.isCollision(pacman, gum)){
                foods.remove(gum);
                score += 5;
                jlabelScore.setText("Score:"+getScore());
                break;
            }
        }
        for(Ghost ghost : ghosts){
            if(collisionRectangle.isCollision(pacman,ghost)){
                ghosts.remove(ghost);
                pacman.life = pacman.getLife()-1;
                jlabelLife.setText("Life : " + pacman.getLife());
                break;

            }
        }
        jlabelScore.setForeground(Color.yellow);
        jlabelLife.setForeground(Color.yellow);
        jlabelScore.setLocation(new Point(30,11*30 +10));
        jlabelLife.setLocation(new Point(24*30 +10,11*30 +10));
        Font font = new Font("Arial",Font.BOLD , 20);
        jlabelLife.setFont(font);
        jlabelScore.setFont(font);







        /*
        for (Wall wall :walls){
            collisionMap.collisionWithWall(pacman,wall);
        }
        pacman.verifyNextDirection(walls);
        pacman.move();

        /*
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

         */

        /*
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