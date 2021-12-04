package Engine.physics.movement;

/**
 * Movement est une interface qui permet de gèrer les differents mouvement
 * de notre entitée
 */
public interface Movement {
    void move();
    String name();
    void goUp();
    void goDown();
    void goLeft();
    void goRight();
    void stop();

}
