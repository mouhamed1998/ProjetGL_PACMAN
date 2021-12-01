package Engine.AI;



import Engine.Graphics.Map;
import Engine.physics.Collision.CollisionMap;
import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;
import Pacman.Ghost;
import Pacman.Wall;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomMovement {
//    Ghost ghost;
//    JPanel jlabel;
//
//    public Ghost getGhost() {
//        return ghost;
//    }
//
//    public JPanel getJlabel() {
//        return jlabel;
//    }
//
//    @Override
//    public MovementType getMovement(Ghost ghost, Map map) {
//        this.ghost = ghost;
//        //Random random =  new Random();
//       // return  MovementType.values()[random.nextInt(MovementType.values().length)];
//
//        this.jlabel = map;
//        this.ghost = ghost;
//        MovementType nextMove = MovementType.STOP;
//
//        Random randomMove = new Random();
//        return MovementType.values()[randomMove.nextInt(MovementType.values().length)];
//
//        /*
//
//        if(ghost.getDirection() != MovementType.STOP) {
//            nextMove = checkMove(ghost.getDirection(), jpanel);
//            return nextMove;
//        }
//        else {
//            Random randomMove = new Random();
//
//            int random = randomMove.nextInt(4);
//            System.out.println("random: "+ random);
//            switch (random){
//                case 0:
//                    nextMove = MovementType.DOWN;
//                    nextMove = checkMove(nextMove, jpanel);
//                    return nextMove;
//                case 1:
//                    nextMove= MovementType.UP;
//                    nextMove = checkMove(nextMove, jpanel);
//                    return nextMove;
//                case 2:
//                    nextMove= MovementType.LEFT;
//                    nextMove = checkMove(nextMove, jpanel);
//                    return nextMove;
//                case 3:
//                    nextMove= MovementType.RIGHT;
//                    nextMove = checkMove(nextMove, jpanel);
//                    return nextMove;
//                default:
//                    return MovementType.STOP;
//            }
//        }
//
//         */
//
//
//
//
//    }
//
//    private MovementType checkMove(MovementType movement, JPanel jPanel){
//        CollisionMap collisionMap = new CollisionMap();
//        Ghost next = new Ghost(new Point(ghost.getPosition().x, ghost.getPosition().y), ghost.getNumber());
//        Point currentPixel = new Point(ghost.getPixelPosition());
//        switch (movement) {
//            case RIGHT:
//                currentPixel.x+=1;
//                next.setPixelPosition(currentPixel);
//                break;
//            case LEFT:
//                currentPixel.x-=1;
//                next.setPixelPosition(currentPixel);
//                break;
//            case UP:
//                currentPixel.y-=1;
//                next.setPixelPosition(currentPixel);
//                break;
//            case DOWN:
//                currentPixel.y+=1;
//                next.setPixelPosition(currentPixel);
//                break;
//        }
//
//        for(Wall w : Map.walls){
//            collisionMap.collisionWithWall(next, w);
//        }
//        return next.getDirection();
//    }
//
//    @Override
//    public MovementType getMovement(MovableEntity ghost, Map map) {
//        return null;
//    }
}
