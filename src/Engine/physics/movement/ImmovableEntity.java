package Engine.physics.movement;

import java.awt.*;

public class ImmovableEntity extends Entity{
    public ImmovableEntity(Point position){
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x * getSize()+10,position.y*getSize()+10));
    }

    @Override
    public String getUrls() {
        return "";
    }
}
