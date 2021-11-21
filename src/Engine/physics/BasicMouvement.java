package Engine.physics;

public class BasicMouvement  implements Movement{
    protected String name;
    private int speed =1;
    private int xPosition;
    private int  yPosition;
    MovementType direction = MovementType.RIGHT;

    @Override
    public void move() {
        switch (direction){
            case UP : yPosition -= speed; break;
            case DOWN : yPosition += speed; break;
            case LEFT : xPosition -= speed; break;
            case RIGHT : xPosition += speed; break;
        }
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void goUp() {
        direction = MovementType.UP;
    }

    @Override
    public void goDown() {
        direction = MovementType.DOWN;
    }

    @Override
    public void goLeft() {
        direction = MovementType.LEFT;
    }

    @Override
    public void goRight() {
        direction = MovementType.RIGHT;

    }

    @Override
    public void stop() {

    }
}
