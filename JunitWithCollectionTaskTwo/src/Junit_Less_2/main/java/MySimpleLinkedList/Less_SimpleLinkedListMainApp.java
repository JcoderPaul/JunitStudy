package MySimpleLinkedList;

import MyClasses.Planet;
import MyClasses.SpaceObject;
import MySimpleLinkedList.MySpaceLinkedList.MySpaceLinkedList;

public class Less_SimpleLinkedListMainApp {
    public static void main(String[] args) {
        // Создали наш список
        MySpaceLinkedList solarSystemPlanet = new MySpaceLinkedList();
        // Создали объекты списка
        SpaceObject mercury = new Planet("планета","Меркурий",2439.7);
        SpaceObject venus = new Planet("планета","Венера",6051.8);
        SpaceObject earth = new Planet("планета","Земля",6378.1);
        SpaceObject mars = new Planet("планета","Марс",3396.2);
        SpaceObject jupiter = new Planet("планета","Юпитер",71492.1);
        SpaceObject saturn = new Planet("планета","Сатурн",60268.4);
        SpaceObject uranus = new Planet("планета","Уран",25559.5);
        // Заполняем список объектами
        solarSystemPlanet.add(mercury);
        ((Planet) mercury).setCountOfSatellite(0);
        solarSystemPlanet.add(venus);
        ((Planet) venus).setCountOfSatellite(0);
        solarSystemPlanet.add(earth);
        ((Planet) earth).setCountOfSatellite(1);
        solarSystemPlanet.add(mars);
        ((Planet) mars).setCountOfSatellite(2);
        solarSystemPlanet.add(jupiter);
        ((Planet) jupiter).setCountOfSatellite(80);
        solarSystemPlanet.add(saturn);
        ((Planet) saturn).setCountOfSatellite(83);
        solarSystemPlanet.add(uranus);
        ((Planet) uranus).setCountOfSatellite(27);

        for (int i = 0; i < solarSystemPlanet.size(); i++){
            System.out.println(solarSystemPlanet.get(i));
        }
    }
}
