package JunitCollectionsTasksOne.MySimpleHashSet;

import JunitCollectionsTasksOne.MyClasses.SpaceObject;
import JunitCollectionsTasksOne.MySimpleHashSet.MySpaceHashSet.MySpaceHashSet;

public class Less_SimpleHashSetMainApp {
    public static void main(String[] args) {
        // Создали наш список
        MySpaceHashSet solarSystemPlanet = new MySpaceHashSet();
        System.out.println("------------------- Тест метода *.isEmpty() на пустом Set-е -------------------");
        System.out.println(solarSystemPlanet.isEmpty());
        // Создали объекты списка
        SpaceObject mercury = new SpaceObject("Меркурий", 2439.7);
        SpaceObject venus = new SpaceObject("Венера", 6051.8);
        SpaceObject earth = new SpaceObject("Земля", 6378.1);
        SpaceObject mars = new SpaceObject("Марс", 3396.2);
        SpaceObject jupiter = new SpaceObject("Юпитер", 71492.1);
        SpaceObject saturn = new SpaceObject("Сатурн", 60268.4);
        SpaceObject uranus = new SpaceObject("Уран", 25559.5);

        SpaceObject ceres= new SpaceObject("Церера", 481.2);
        SpaceObject uranusTwo = new SpaceObject("Уран", 25559.5);
        // Заполняем список объектами
        solarSystemPlanet.add(mercury);
        solarSystemPlanet.add(venus);
        solarSystemPlanet.add(earth);
        solarSystemPlanet.add(mars);
        solarSystemPlanet.add(jupiter);
        solarSystemPlanet.add(saturn);
        solarSystemPlanet.add(uranus);

        System.out.println("------------------- Тест метода *.isEmpty() на Set-е из 7-и элементов -------------------");
        System.out.println(solarSystemPlanet.isEmpty());

        System.out.println("------------------- Содержимое Set-а -------------------");
        for (int i = 0; i < solarSystemPlanet.size(); i++) {
            System.out.println(solarSystemPlanet.allHashSetElementToSimpleArray()[i]);
        }

        System.out.println("------------------- Тест метода *.contains() -------------------");
        System.out.println("Ссылка на объект '" + uranusTwo + "' или его копию в коллекции есть : " + solarSystemPlanet.contains(uranusTwo));
        System.out.println("Ссылка на объект '" + ceres + "' или его копию в коллекции есть : " + solarSystemPlanet.contains(ceres));
    }
}
