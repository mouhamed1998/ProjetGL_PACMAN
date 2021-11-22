package Engine.physics.Collision;

import Engine.physics.movement.Entity;

public class CollisionCircle implements CollisionEngine {


    @Override
    public boolean isOutOfMazeWindow(Entity e1, int mazeHeight, int mazeWidth) {
        return false;
    }

    @Override
    public boolean isCollision(Entity e1, Entity e2) {
        double Xe1 = e1.getPixelPosition().x + (double)e1.getSize()/2;
        double Ye1 = e1.getPixelPosition().y + (double)e1.getSize()/2;
        double Xe2 = e2.getPixelPosition().x + (double)e2.getSize()/2;
        double Ye2 = e2.getPixelPosition().y + (double)e2.getSize()/2;
        double distance= (Xe1 - Xe2)*(Xe1 - Xe2) + (Ye1 - Ye2)*(Ye1 - Ye2) ;
        return  (distance < e1.getSize()*e1.getSize());
     }
}
