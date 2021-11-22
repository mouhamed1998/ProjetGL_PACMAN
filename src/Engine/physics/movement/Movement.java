package Engine.physics.movement;


public interface Movement {
    void move();
    String name();
    void goUp();
    void goDown();
    void goLeft();
    void goRight();
    void stop();

}
