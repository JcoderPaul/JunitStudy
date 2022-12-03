package JunitCollectionsTasksOne.MyClasses;

import java.util.Objects;

public class SpaceObject {
    private String kindOfSpaceObject;
    private double radius;

    public SpaceObject(String kindOfSpaceObject, double radius) {
        this.kindOfSpaceObject = kindOfSpaceObject;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceObject that = (SpaceObject) o;
        return Double.compare(that.radius, radius) == 0 &&
                Objects.equals(kindOfSpaceObject, that.kindOfSpaceObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindOfSpaceObject, radius);
    }

    @Override
    public String toString() {
        return "SpaceObject: {" +
                "kindOfSpaceObject='" + kindOfSpaceObject + '\'' +
                ", radius=" + radius +
                '}';
    }

    public String getKindOfSpaceObject() {
        return kindOfSpaceObject;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
