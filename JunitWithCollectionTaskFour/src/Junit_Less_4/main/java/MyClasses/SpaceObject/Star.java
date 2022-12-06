package MyClasses.SpaceObject;

import java.util.Objects;

public class Star extends SpaceObject {
    private String spectralClass = "not set";
    public Star(String kindOfSpaceObject, String nameOfSpaceObject, double radius) {
        super(kindOfSpaceObject, nameOfSpaceObject, radius);
    }

    public Star(String kindOfSpaceObject, String nameOfSpaceObject, double radius, String spectralClass) {
        super(kindOfSpaceObject, nameOfSpaceObject, radius);
        this.spectralClass = spectralClass;
    }

    public String getSpectralClass() {
        return spectralClass;
    }

    public void setSpectralClass(String spectralClass) {
        this.spectralClass = spectralClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Star star = (Star) o;
        return Objects.equals(spectralClass, star.spectralClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), spectralClass);
    }

    @Override
    public String toString() {
        return "SpaceObject: {" +
                "kindOfSpaceObject= '" + this.getKindOfSpaceObject() + '\'' +
                ", nameOfSpaceObject= '" + this.getNameOfSpaceObject() + '\'' +
                ", radius=" + this.getRadius() +
                ", spectralClass=" + spectralClass +
                '}';
    }
}
