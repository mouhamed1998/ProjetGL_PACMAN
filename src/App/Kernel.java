package App;


import Engine.AI.AstarAI;
import Engine.AI.RandomMovement;
import Engine.physics.Collision.CollisionCircle;
import Engine.physics.Collision.CollisionMap;
import Engine.physics.Collision.CollisionRectangle;
import Pacman.Ghost;
import Pacman.Gum;
import Pacman.Pacman;
import Pacman.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;

enum GameState{
    PLAY, PAUSE, STOP, GAMEOVER, VICTORY
}

public class CoreKernel {
    public Pacman pacman;
    //public CopyOnWriteArrayList<Ghost> ghosts;
    public ArrayList<Ghost> ghosts;
    public ArrayList<Gum> coins;
    public ArrayList<Gum> pufoods;
    public ArrayList<Wall> walls;
    public ArrayList<Point> wallPoint;
    public GameState gameState;
    public CollisionMap checkCollisionInMap = new CollisionMap();
    CollisionCircle collisionCircle = new CollisionCircle();
    public CollisionRectangle collisionRectangle = new CollisionRectangle();
    public Graphics coreGraphic;
    public int score = 0;

    public CoreKernel(){

    }
    int i = 0;
    public void takeAnimation() {
        if(gameState==GameState.VICTORY) {
            victoryPush();
        }
        for (Wall wall : walls) {
            checkCollisionInMap.collisionWithWall(pacman, wall);
        }
        pacman.verifyNextDirection(this.walls);
        pacman.move();
        for(Ghost ghost : ghosts) {

            //ghost.setDirection(MovementType.LEFT);
            //ghost.nextMoveCalculateByAI(this);
            ghost.move();
        }
        for(Ghost ghost: ghosts){
            if(collisionRectangle.isCollision(pacman, ghost)){
                ghostCatchPacman();
            }
        }

        //eat coin
        for (Gum coin:coins) {
            if(collisionCircle.isCollision(pacman, coin)) {
                //coinEat.start();
                coins.remove(coin);
                score += 10;
                break;
            }
            if(coins.isEmpty()) {
                gameState = GameState.VICTORY;
            }
        }

        for (Gum coin: pufoods) {
            if(collisionCircle.isCollision(pacman, coin)) {
                //coinEat.start();
                pufoods.remove(coin);
                score += 30;
                break;
            }
        }

    }

    public void setAIForGhost(){
        //ghosts.get(0).AI = new AstarAI();
        for (int i = 0; i<ghosts.size(); i++){
            if(i==3||i==1) ghosts.get(i).AI = new AstarAI();
            else this.ghosts.get(i).AI = new RandomMovement();
        }
    }

    public void ghostCatchPacman(){
        gameState = GameState.GAMEOVER;
        int  result = JOptionPane.showConfirmDialog(null, "You lose, GAME OVER",
                "Quit", JOptionPane.YES_OPTION);
        if(result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    void victoryPush(){

        JOptionPane.showMessageDialog(null, "You are victory");
    }

    public void reNewState(){
        for (Ghost ghost: ghosts) {
            ghost.getPixelPosition();
        }
    }

    public int[][] getWallsPosition() {
        int[][] walls = new int[wallPoint.size()][2];
        int i = 0;
        for (Point point:wallPoint){
            walls[i] = new int[]{
                    point.y, point.x
            };
            i+=1;
        }
        return walls;
    }
}
