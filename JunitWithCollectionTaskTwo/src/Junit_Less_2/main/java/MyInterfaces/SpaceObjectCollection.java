package MyInterfaces;

import MyClasses.SpaceObject;

public interface SpaceObjectCollection {
        boolean add(SpaceObject spaceObject);

        boolean remove(SpaceObject spaceObject);

        int size();

        void clear();

        boolean contains(SpaceObject spaceObject);
}
