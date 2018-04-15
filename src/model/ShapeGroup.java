package model;

import java.util.Iterator;
import java.util.List;

public class ShapeGroup implements Entity {

    private List<Shape> children;

    public ShapeGroup() {

    }

    @Override
    public void addEntity(Entity e) {

    }

    @Override
    public void removeEntity(Entity e) {

    }

    @Override
    public Iterator<Entity> getChildren() {
        // return children;
        return null;
    }
}
