package Engine.Input;


import Engine.physics.Collision.CollisionMap;
import GamePlay.Pacman.Pacman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Moteur Input-Output
 * c'est cette class qui permet de faire la connexion entre les touches clavier et les déplacements du pacman
 * pour cela elle implements l'interface KeyListener et étend la class abstraite KeyAdapter
 */
public class KeyBorad extends KeyAdapter implements KeyListener {
    Pacman pacman ;
    public KeyBorad(Pacman pacman) {
        this.pacman = pacman;

    }


    /**
     * la méthode keyPressed permet de déclencher l'evenement du déplacement de l'entité pacman
     * lorsque une touche (fléche) est pressée par l'utilisateur
     * @param event un keyEvent
     */
    public void keyPressed(KeyEvent event){
        CollisionMap collisionMap = new CollisionMap();
        int key = event.getKeyCode();
        if(key == KeyEvent.VK_UP){
            System.out.println("UP");
            this.pacman.goUp();
            /*
            MovableEntity pac = new Pacman(new Point(pacman.getPosition().x, pacman.getPosition().y), pacman.getMap());
            int y = pacman.getPixelPosition().y - pacman.speed;
            pac.setPixelPosition(new Point(pacman.getPosition().x, ));

             */
            /*
            for (Entity entity : Map.walls){
                if(entity instanceof Wall){
                    collisionMap.collisionWithWall(pacman, (Wall) entity);
                }

            }
            this.pacman.move();

            //this.pacman.goUp();

             */
        }

        if(key == KeyEvent.VK_DOWN){
            System.out.println("DOWN");
           this.pacman.goDown();
           /*
            for (Entity entity : Map.walls){
                if(entity instanceof Wall) collisionMap.collisionWithWall(pacman, (Wall) entity);

            }
            this.pacman.move();

            //this.pacman.goDown();

            */

        }
        if(key == KeyEvent.VK_LEFT){
            System.out.println("LEFT");
            this.pacman.goLeft();
            /*
            for (Entity entity : Map.walls){
                if(entity instanceof Wall) collisionMap.collisionWithWall(pacman, (Wall) entity);

            }
            this.pacman.move();

             */

        }
        if(key == KeyEvent.VK_RIGHT){
            System.out.println("RIGHT");
            this.pacman.goRight();
            /*
            for (Entity entity : Map.walls){
                if(entity instanceof Wall) collisionMap.collisionWithWall(pacman, (Wall) entity);

            }
            this.pacman.move();



                       //this.pacman.goRight();

             */
        }
    }


}
