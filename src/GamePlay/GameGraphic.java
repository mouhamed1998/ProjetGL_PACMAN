package GamePlay;

import Engine.kernel.Kernel;
import Engine.physics.Collision.CollisionMap;
import GamePlay.Pacman.Pacman;
import GamePlay.Pacman.Gum;
import GamePlay.Pacman.Ghost;
import GamePlay.Pacman.Wall;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class GameGraphic extends JPanel implements KeyListener {
    Timer coreKernelTimer;
    Kernel coreKernel;
    int[][] map;
    Image[] mapSegments = new Image[28];
    Image foodImage;
    Image[] pfoodImage;
    Pacman pacman;
    ArrayList<Gum> foods;
    ArrayList<Gum> pufoods;
    ArrayList<Ghost> ghosts;
    public static ArrayList<Wall> walls;
    ArrayList<Ghost> realGhosts;
    boolean drawScore = true;
    boolean clearScore = false;
    JLabel scoreboard;
    public Point ghostBase;
    public int mx;
    public int my;
    private final MazeWindow parent;
    private final MapNew md;
    private JLabel jlabelScore;
    private JLabel jlabelLife;
    private int score = 0;
    private int life =3;

    @Override
    public MazeWindow getParent() {
        return parent;
    }

    public GameGraphic(JLabel scoreboard, MapNew map, MazeWindow pw) throws FileNotFoundException, MalformedURLException, URISyntaxException {
        coreKernel = new Kernel();
        this.md = map;
        this.scoreboard = scoreboard;
        this.setDoubleBuffered(true);
        this.parent = pw;
        mx = 29;
        my = 27;
        this.map = md.getMapGraphic();
        this.ghostBase = md.getGhostBasePosition();
        jlabelScore = new JLabel("Score:"+getScore());
        jlabelLife = new JLabel("Life:"+life);
        scoreboard.setLocation(new Point(11*30 +10,30));
        //jlabelLife.setLocation(new Point(24*30 +10,11*30 +10));
        initImage();
        initEntity();
        initTimer();
        initKernel();
        startGame();
    }

    public JLabel getJlabelScore() {
        return jlabelScore;
    }

    public JLabel getJlabelLife() {
        return jlabelLife;
    }

    void startGame() {
        coreKernelTimer.start();
        //coreKernel.themeSound.loop();
    }
    public int getScore(){
        return score;
    }
    void initTimer(){
        coreKernelTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coreKernel.takeAnimation();
            }
        });
        coreKernelTimer.stop();
    }

    void initKernel() {
        pacman.setSpeed(2);
        coreKernel.pacman = this.pacman;
        coreKernel.walls = this.walls;
        coreKernel.coins = this.foods;
        coreKernel.pufoods = this.pufoods;
        coreKernel.ghosts = this.realGhosts;
        coreKernel.coreGraphic = this.getGraphics();
        coreKernel.wallPoint = this.md.getWallPositions();
        coreKernel.setAIForGhost();
    }

    void initEntity(){
        this.pacman = new Pacman(md.getPacmanPosition(), this);
        foods = new ArrayList<>();
        pufoods = new ArrayList<>();
        ghosts = new ArrayList<>();
        walls = new ArrayList<>();
        realGhosts = new ArrayList<>();
        for(Point foodPosition: md.getCoinPositions()) {
            foods.add(new Gum(new Point(foodPosition.x, foodPosition.y)));
        }
        for(Point puFood : md.getPuCoinPositions()) {
            Gum coin = new Gum(new Point(puFood.x, puFood.y));
            int random = new Random().nextInt(5);
            coin.setImage(pfoodImage[random]);
            pufoods.add(coin);

        }
        ghosts = new ArrayList<>();

        for(Ghost gd : md.getGhostsData()){
            gd.setGameBoard(this);
            ghosts.add(gd);
        }
        this.addKeyListener(this);

        for(Point mapPoint : md.getWallPositions()) {
            Wall wall = new Wall(mapPoint);
            wall.setImage(mapSegments[map[mapPoint.y][mapPoint.x]]);
            walls.add(wall);
        }
        for (Ghost ghost : ghosts){
            Ghost gh = new Ghost(ghost, this);
            realGhosts.add(gh);

        }

    }

    void initImage() {
       // md.getMapFromResource("src/API/mapS.txt");
        md.adjustNewMap();
        map =md.getMapGraphic();
        setBackground(Color.black);
        mapSegments[0] = null;
        for(int ms=1;ms<27;ms++){
            try {
                URL path = this.getClass().getClassLoader().getResource("API/ressource/pacman_img/Image/map_segments/"+ms+".png");
                mapSegments[ms] = new ImageIcon(path).getImage();
            }catch(Exception e){
                System.out.println("ms: " + ms);
                e.printStackTrace();
            }
        }
        pfoodImage = new Image[5];
        for(int ms=0 ;ms<5;ms++){
            try {
                URL path = this.getClass().getClassLoader().getResource("API/ressource/pacman_img/Image/Coin/fruit-"+ms+".png");
                pfoodImage[ms] = new ImageIcon(path).getImage();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        try{
            URL path = this.getClass().getClassLoader().getResource("API/ressource/pacman_img/Image/Coin/coin-normal.png");
            foodImage = new ImageIcon(path).getImage();
            //goImage = ImageIO.read(this.getClass().getResource("resources/images/gameover.png"));
            //vicImage = ImageIO.read(this.getClass().getResource("resources/images/victory.png"));
            //pfoodImage = ImageIO.read(this.getClass().getResource("/images/pfood.png"));
        }catch(Exception e){}
    }
    CollisionMap collisionMap =new CollisionMap();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.blue);

        for (Wall wall : walls) {
            g.drawImage(wall.getImage(), wall.getPixelPosition().x, wall.getPixelPosition().y, null);
        }
        for(Gum f : foods){
            int x = f.getPixelPosition().x;
            int y = f.getPixelPosition().y;
            g.drawImage(foodImage, x, y, null);
        }

        for(Gum f : pufoods){
            int x = f.getPixelPosition().x;
            int y = f.getPixelPosition().y;
            g.drawImage(f.getImage(), x, y,null);
        }

        //Draw Pacman
        int xPacman = pacman.getPixelPosition().x;
        int yPacman = pacman.getPixelPosition().y;
        g.drawImage(pacman.getImage(), xPacman, yPacman, null);
        System.out.println("pacman.getPixelPosition().x"+pacman.getPixelPosition().x);

        //Draw Ghosts

        for(Ghost gh : realGhosts) {
            Image ghostImage = gh.getImage();
            int xGhost = gh.getPixelPosition().x;
            int yGhost = gh.getPixelPosition().y;
            g.drawImage(ghostImage, xGhost, yGhost, null);
        }
        if(drawScore) {
            scoreboard.setText("    Score : " + coreKernel.score + "         Life:  " + coreKernel.getLife());
            clearScore = true;
        }
        /*

        scoreboard.setForeground(Color.yellow);
        //jlabelLife.setForeground(Color.yellow);
        scoreboard.setLocation(new Point(30,11*30 +10));
        //jlabelLife.setLocation(new Point(24*30 +10,11*30 +10));
        Font font = new Font("Arial", Font.BOLD , 20);
        //jlabelLife.setFont(font);
        scoreboard.setFont(font);

         */
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            System.out.println("left");
            this.pacman.goLeft();
            //this.pacman.move();
        } else if (key == KeyEvent.VK_RIGHT) {
            System.out.println("right");
            this.pacman.goRight();
            //this.pacman.move();
        } else if (key == KeyEvent.VK_UP) {
            System.out.println("up");
            this.pacman.goUp();
            //this.pacman.move();
        } else if (key == KeyEvent.VK_DOWN) {
            System.out.println("down");
            this.pacman.goDown();
            //this.pacman.move();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
