package MySimpleHashSet;

import MyClasses.Asteroid;
import MyClasses.Planet;
import MyClasses.SpaceObject;
import MyClasses.Star;
import MySimpleHashSet.MySpaceHashSet.MySpaceHashSet;

import java.util.Iterator;

public class Less_SimpleHashSetIteratorApp {
    public static void main(String[] args) {
        // Создали наш список
        MySpaceHashSet solarSystemObject = new MySpaceHashSet();
        System.out.println("------------------- Тест метода *.isEmpty() на пустом Set-е -------------------");
        System.out.println(solarSystemObject.isEmpty());
        // Создали объекты списка
        SpaceObject mercury = new Planet("планета","Меркурий", 2439.7);
        SpaceObject venus = new Planet("планета","Венера", 6051.8);
        SpaceObject earth = new Planet("планета","Земля", 6378.1);
        SpaceObject mars = new Planet("планета","Марс", 3396.2);
        SpaceObject jupiter = new Planet("планета","Юпитер", 71492.1);
        SpaceObject saturn = new Planet("планета","Сатурн", 60268.4);
        SpaceObject uranus = new Planet("планета","Уран", 25559.5);

        SpaceObject ceres= new Asteroid("астероид","Церера", 481.2);
        SpaceObject uranusTwo = new Planet("планета","Уран", 25559.5);
        SpaceObject sun = new Star("звезда","Солнце", 695510.4);
        // Заполняем список объектами
        solarSystemObject.add(mercury);
        solarSystemObject.add(venus);
        solarSystemObject.add(earth);
        solarSystemObject.add(mars);
        solarSystemObject.add(jupiter);
        solarSystemObject.add(saturn);
        solarSystemObject.add(uranus);
        solarSystemObject.add(sun);
        System.out.println("-------------------- Вывод элементов списка при помощи forEach --------------------");
        solarSystemObject.forEach(System.out::println);
        System.out.println("-------------------- Вывод элементов списка при помощи forEach и Iterator --------------------");
        Iterator<SpaceObject> myHashSetIterator = solarSystemObject.iterator();
        while (myHashSetIterator.hasNext()){
            System.out.println(myHashSetIterator.next());
        }
        System.out.println("-------------------- Проверка метода *.remove() реализованного в Iterator --------------------");
        Iterator<SpaceObject> myIterator = solarSystemObject.iterator();
        while (myIterator.hasNext()){
            SpaceObject prn = myIterator.next();
            // Удалим из коллекции объекты 'mars', 'mercury' и 'venus'
            if(!prn.equals(mars) && !prn.equals(mercury) && !prn.equals(venus)){
                System.out.println(prn);
            } else {
                myIterator.remove();
            }
        }
    }
}
