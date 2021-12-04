package Engine.physics.Collision;

import Engine.physics.movement.MovableEntity;
import Engine.physics.movement.MovementType;
import GamePlay.Pacman.Wall;

public class CollisionMap implements CollisionWall{
    /**
     * cette méthode arrete le déplacement de l'entitée donnée en parametre lorsque cette entitée rencontre un mur
     * (entre en collision avec un mur)
     * il y a quatre tupe de mouvement a vérifier : UP, DOWN , LEFT, RIGHT.
     *
     * @param movableEntity represente l'entitée en mouvement (pacman où fantome)
     * @param wall represente un mur dans le labyrinthe
     */
    @Override
    public void collisionWithWall(MovableEntity movableEntity, Wall wall) {
        MovementType direction = movableEntity.getDirection();
        int movableX = movableEntity.getPixelPosition().x;
        int movableY = movableEntity.getPixelPosition().y;
        int wallX = wall.getPixelPosition().x;
        int wallY = wall.getPixelPosition().y;
        int wallSize  =  wall.getSize();
        int movableSize = movableEntity.getSize();
        switch (direction){
            case UP: {
                //System.out.println("in up");
                int checkY = (movableY-wallY);
                int checkX = Math.abs(movableX-wallX);
                if(checkY>=0 && checkY<=wallSize && checkX<wallSize) {
                    System.out.println("Up collision with map");
                    System.out.println("GHost: " + movableX + " " + movableY);
                    System.out.println("Wall: " + wallX + " " + wallY);
                    movableEntity.stop();
                }
                break;
            }

            case DOWN: {
                //System.out.println("in down");
                int checkY = (wallY-movableY);
                int checkX = Math.abs(movableX-wallX);
                if(checkY >= 0 && checkY<=wallSize && checkX<wallSize) {
                    movableEntity.stop();
                    System.out.println("Pacman: " + movableX + " " + movableY);
                    System.out.println("GHost: " + wallX + " " + wallY);
                    System.out.println("Down collision with map");
                }
                break;
            }
            case LEFT: {
                //System.out.println("in left");
                int checkX = (movableX-wallX);
                int checkY = Math.abs(movableY - wallY);
                if(checkX>=0&&checkX<=wallSize&&(checkY<wallSize)) {
                    System.out.println("Pacman: " + movableX + " " + movableY + " " + movableSize);
                    System.out.println("GHost: " + wallX + " " + wallY + " " + wallSize);
                    System.out.println("Left collision with map");
                    movableEntity.stop();
                }
                break;
            }

            case RIGHT:{
                //System.out.println("in right");
                int checkX = (wallX - movableX);
                int checkY = Math.abs(wallY-movableY);
                if(checkX >= 0 && checkX <=wallSize && checkY<wallSize) {
                    movableEntity.stop();
                    System.out.println("Right collision with map");
                    System.out.println("GHost: " + movableX + " " + movableY);
                    System.out.println("Wall: " + wallX + " " + wallY);
                }
                break;
            }
            default:
                break;

        }


    }
    public boolean iscollisionWithWall(MovableEntity movableEntity, Wall wall) {
        MovementType direction = movableEntity.getDirection();
        int movableX = movableEntity.getPixelPosition().x;
        int movableY = movableEntity.getPixelPosition().y;
        int wallX = wall.getPixelPosition().x;
        int wallY = wall.getPixelPosition().y;
        int wallSize  =  wall.getSize();
        int movableSize = movableEntity.getSize();
        switch (direction){
            case UP: {
                //System.out.println("in up");
                int checkY = (movableY-wallY);
                int checkX = Math.abs(movableX-wallX);
                if(checkY>=0 && checkY<=wallSize && checkX<wallSize) {
                    System.out.println("Up collision with map");
                    System.out.println("GHost: " + movableX + " " + movableY);
                    System.out.println("Wall: " + wallX + " " + wallY);
                    movableEntity.stop();
                    return true;
                }
                break;
            }

            case DOWN: {
                //System.out.println("in down");
                int checkY = (wallY-movableY);
                int checkX = Math.abs(movableX-wallX);
                if(checkY >= 0 && checkY<=wallSize && checkX<wallSize) {
                    movableEntity.stop();
                    System.out.println("Pacman: " + movableX + " " + movableY);
                    System.out.println("GHost: " + wallX + " " + wallY);
                    System.out.println("Down collision with map");
                    return true;
                }
                break;
            }
            case LEFT: {
                //System.out.println("in left");
                int checkX = (movableX-wallX);
                int checkY = Math.abs(movableY - wallY);
                if(checkX>=0&&checkX<=wallSize&&(checkY<wallSize)) {
                    System.out.println("Pacman: " + movableX + " " + movableY + " " + movableSize);
                    System.out.println("GHost: " + wallX + " " + wallY + " " + wallSize);
                    System.out.println("Left collision with map");
                    movableEntity.stop();
                    return true;
                }
                break;
            }

            case RIGHT:{
                //System.out.println("in right");
                int checkX = (wallX - movableX);
                int checkY = Math.abs(wallY-movableY);
                if(checkX >= 0 && checkX <=wallSize && checkY<wallSize) {
                    movableEntity.stop();
                    System.out.println("Right collision with map");
                    System.out.println("GHost: " + movableX + " " + movableY);
                    System.out.println("Wall: " + wallX + " " + wallY);
                    return true;
                }
                break;
            }
            default:
                break;

        }

        return false;
    }

}
