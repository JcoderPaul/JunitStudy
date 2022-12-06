import MyClasses.Discoverer;
import MyClasses.SpaceObject.Asteroid;
import MyClasses.SpaceObject.Planet;
import MyClasses.SpaceObject.SpaceObject;
import MyClasses.SpaceObject.Star;
import MyCollectionMap.SpaceObjectHashMap;
import MyInterfaces.SpaceObjectMap;

import java.util.List;
import java.util.Set;

public class Less_MyHashMapMainApp {
    public static void main(String[] args) {
        SpaceObjectMap firstSpaceObjectMap = new SpaceObjectHashMap();
        Discoverer discoverer1 =
                new Discoverer(1,"Сергей","Никитин");
        SpaceObject findSpaceObject1 =
                new Asteroid("астероид","Тариал 45",4356.3);
        Discoverer discoverer2 =
                new Discoverer(2,"Валентин","Уськов");
        SpaceObject findSpaceObject2 =
                new Planet("планетоид","Вектор Иридиум 3453-12",856.3);
        Discoverer discoverer3 =
                new Discoverer(3,"Сергей","Никитин");
        SpaceObject findSpaceObject3 =
                new Star("звезда","Гамма Тулатина",423556.3);
        Discoverer discoverer4 =
                new Discoverer(4,"Сергей","Никитин");
        SpaceObject findSpaceObject4 =
                new SpaceObject("комета","Адова бездна 234-12D",23256.3);

        firstSpaceObjectMap.put(discoverer1,findSpaceObject1);
        firstSpaceObjectMap.put(discoverer2,findSpaceObject2);
        firstSpaceObjectMap.put(discoverer3,findSpaceObject3);
        firstSpaceObjectMap.put(discoverer4,findSpaceObject4);
        System.out.println("-------------------- Размер коллекции Map --------------------");
        System.out.println(firstSpaceObjectMap.size());
        System.out.println("-------------------- Values of Map --------------------");
        List<SpaceObject> spaceObjectList = firstSpaceObjectMap.values();
        spaceObjectList.forEach(System.out::println);
        System.out.println("-------------------- Keys of Map --------------------");
        Set<Discoverer> myAstronomers = firstSpaceObjectMap.keySet();
        myAstronomers.forEach(System.out::println);
    }
}
