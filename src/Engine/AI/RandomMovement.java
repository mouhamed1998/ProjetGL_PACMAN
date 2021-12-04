package Engine.AI;

import Engine.kernel.Kernel;
import Engine.physics.movement.MovementType;
import GamePlay.Pacman.Ghost;
import GamePlay.Pacman.Wall;

import java.awt.*;
import java.util.Random;

/**
 * RandomMovement est une class qui permet de faire bouger les fantomes d'une maniere aléatoire
 */
public class RandomMovement implements AiInterface{
    Ghost ghost;

    /**
     * cette methode permet de gèrer les déplacement aléatoire des fantomes
     * @param ghost prend en parametre un fantome
     * @param coreKernel le noyau
     * @return le déplacement choisi de maniere aléatoire
     */
    @Override
    public MovementType getMovement(Ghost ghost, Kernel coreKernel) {
        this.ghost = ghost;
        MovementType nextMove = MovementType.STOP;
        if(ghost.getDirection() != MovementType.STOP) {
            nextMove = checkMove(ghost.getDirection(), coreKernel);
            return nextMove;
        } else {
            Random randomMove = new Random();
            int random = randomMove.nextInt(4);
            System.out.println("random: "+ random);
            switch (random){
                case 0:
                    nextMove = MovementType.DOWN;
                    nextMove = checkMove(nextMove, coreKernel);
                    return nextMove;
                case 1:
                    nextMove= MovementType.UP;
                    nextMove = checkMove(nextMove, coreKernel);
                    return nextMove;
                case 2:
                    nextMove= MovementType.LEFT;
                    nextMove = checkMove(nextMove, coreKernel);
                    return nextMove;
                case 3:
                    nextMove= MovementType.RIGHT;
                    nextMove = checkMove(nextMove, coreKernel);
                    return nextMove;
                default:
                    return MovementType.STOP;
            }
        }
    }

    private MovementType checkMove(MovementType movement, Kernel coreKernel){
        Ghost next = new Ghost(new Point(ghost.getPosition().x, ghost.getPosition().y), ghost.getNumber());
        Point currentPixel = new Point(ghost.getPixelPosition());
        switch (movement) {
            case RIGHT:
                currentPixel.x+=1;
                next.setPixelPosition(currentPixel);
                break;
            case LEFT:
                currentPixel.x-=1;
                next.setPixelPosition(currentPixel);
                break;
            case UP:
                currentPixel.y-=1;
                next.setPixelPosition(currentPixel);
                break;
            case DOWN:
                currentPixel.y-=1;
                next.setPixelPosition(currentPixel);
                break;
        }

        for(Wall w : coreKernel.walls){
            if(coreKernel.collisionRectangle.isCollision(next, w)) {
                System.out.println("collision in random move");
                System.out.println("ghost: " + ghost.getPixelPosition());
                System.out.println("wall: " + w.getPixelPosition());
                movement = MovementType.STOP;
                return movement;
            }
        }
        return movement;
    }
}
