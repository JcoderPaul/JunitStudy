package MyClasses.SpaceObject;

import java.util.Objects;

public class SpaceObject {
    private String kindOfSpaceObject;
    private String nameOfSpaceObject;
    private double radius;

    public SpaceObject(String kindOfSpaceObject, String nameOfSpaceObject, double radius) {
        this.kindOfSpaceObject = kindOfSpaceObject;
        this.nameOfSpaceObject = nameOfSpaceObject;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceObject that = (SpaceObject) o;
        return Double.compare(that.radius, radius) == 0 &&
               Objects.equals(kindOfSpaceObject, that.kindOfSpaceObject) &&
               Objects.equals(nameOfSpaceObject, that.nameOfSpaceObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kindOfSpaceObject, nameOfSpaceObject, radius);
    }

    @Override
    public String toString() {
        return "SpaceObject: {" +
                "kindOfSpaceObject= '" + kindOfSpaceObject + '\'' +
                ", nameOfSpaceObject= '" + nameOfSpaceObject + '\'' +
                ", radius=" + radius +
                '}';
    }

    public String getKindOfSpaceObject() {
        return kindOfSpaceObject;
    }

    public void setKindOfSpaceObject(String kindOfSpaceObject) {
        this.kindOfSpaceObject = kindOfSpaceObject;
    }

    public String getNameOfSpaceObject() {
        return nameOfSpaceObject;
    }

    public void setNameOfSpaceObject(String nameOfSpaceObject) {
        this.nameOfSpaceObject = nameOfSpaceObject;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
