package model;

import java.util.Iterator;

public interface Entity extends Cloneable {

    void addEntity(Entity e);
    void removeEntity(Entity e);
    Iterator<Entity> getChildren();

}
