package JunitCollectionsTasksOne.MySimpleLinkedList;

import JunitCollectionsTasksOne.MyClasses.SpaceObject;
import JunitCollectionsTasksOne.MySimpleLinkedList.MySpaceLinkedList.MySpaceLinkedList;

public class Less_SimpleLinkedListMainApp {
    public static void main(String[] args) {
        // Создали наш список
        MySpaceLinkedList solarSystemPlanet = new MySpaceLinkedList();
        // Создали объекты списка
        SpaceObject mercury = new SpaceObject("Меркурий",2439.7);
        SpaceObject venus = new SpaceObject("Венера",6051.8);
        SpaceObject earth = new SpaceObject("Земля",6378.1);
        SpaceObject mars = new SpaceObject("Марс",3396.2);
        SpaceObject jupiter = new SpaceObject("Юпитер",71492.1);
        SpaceObject saturn = new SpaceObject("Сатурн",60268.4);
        SpaceObject uranus = new SpaceObject("Уран",25559.5);
        // Заполняем список объектами
        solarSystemPlanet.add(mercury);
        solarSystemPlanet.add(venus);
        solarSystemPlanet.add(earth);
        solarSystemPlanet.add(mars);
        solarSystemPlanet.add(jupiter);
        solarSystemPlanet.add(saturn);
        solarSystemPlanet.add(uranus);

        for (int i = 0; i < solarSystemPlanet.size(); i++){
            System.out.println(solarSystemPlanet.get(i));
        }
    }
}
