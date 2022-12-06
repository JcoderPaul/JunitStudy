package MyClasses.SpaceObject;

import java.util.Objects;

public class Planet extends SpaceObject {
    private int countOfSatellite;
    public Planet(String kindOfSpaceObject, String nameOfSpaceObject, double radius) {
        super(kindOfSpaceObject, nameOfSpaceObject, radius);
    }

    public Planet(String kindOfSpaceObject, String nameOfSpaceObject, double radius, int countOfSatellite) {
        super(kindOfSpaceObject, nameOfSpaceObject, radius);
        this.countOfSatellite = countOfSatellite;
    }

    public int getCountOfSatellite() {
        return countOfSatellite;
    }

    public void setCountOfSatellite(int countOfSatellite) {
        this.countOfSatellite = countOfSatellite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Planet planet = (Planet) o;
        return countOfSatellite == planet.countOfSatellite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countOfSatellite);
    }

    @Override
    public String toString() {
        return "SpaceObject: {" +
                "kindOfSpaceObject= '" + this.getKindOfSpaceObject() + '\'' +
                ", nameOfSpaceObject= '" + this.getNameOfSpaceObject() + '\'' +
                ", radius=" + this.getRadius() +
                ", satellite=" + countOfSatellite +
                '}';
    }
}
