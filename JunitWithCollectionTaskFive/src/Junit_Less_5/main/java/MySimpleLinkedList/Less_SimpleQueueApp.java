package MySimpleLinkedList;

import MyClasses.Planet;
import MyClasses.SpaceObject;
import MySimpleLinkedList.MySpaceQueue.MySpaceObjectQueue;

import java.util.Iterator;

public class Less_SimpleQueueApp {
    public static void main(String[] args) {
        System.out.println("----------------- РУЧНОЕ ТЕСТИРОВАНИЕ КОЛЛЕКЦИИ -----------------");
        // Создали наш список
        MySpaceObjectQueue solarSystemPlanet = new MySpaceObjectQueue();
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

        System.out.println("------------- Вывод коллекции на экран при помощи forEach -------------");
        solarSystemPlanet.forEach(SpaceObject-> System.out.println(SpaceObject));
        System.out.println("------------- Вывод коллекции на экран при помощи forEach + Iterator -------------");
        Iterator<SpaceObject> myIterator = solarSystemPlanet.iterator();
        while (myIterator.hasNext()){
            SpaceObject prn = myIterator.next();
            // Удалим из коллекции объекты 'mars' и 'mercury'
            if(!prn.equals(mars) && !prn.equals(mercury)){
                System.out.println(prn);
            } else {
                myIterator.remove();
            }
        }
        System.out.println("----------------- Повторный вывод на экран через цикл forEach -----------------");
        solarSystemPlanet.forEach(System.out::println);
        System.out.println("----------------- Испытываем методы коллекции Queue -----------------");
        // Чистим коллекцию - очередь 'под ноль'
        solarSystemPlanet.clear();
        // Заполняем очередь объектами
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
        System.out.println("Методы *.element() и *.peek() :");
        System.out.println("Элемент в начале коллекции: " + solarSystemPlanet.element() +
                           " вернули, но не удалили.");
        System.out.println("Элемент в начале коллекции: " + solarSystemPlanet.peek() +
                " вернули, но не удалили.");
        System.out.println("----------------- Текущее состояние коллекции -----------------");
        solarSystemPlanet.forEach(System.out::println);
        System.out.println("----------------- Испытываем методы коллекции Queue -----------------");
        System.out.println("Метод *.poll() :");
        System.out.println("Элемент в начале коллекции: " + solarSystemPlanet.poll() +
                " вернули, и удалили.");
        System.out.println("Элемент в начале коллекции: " + solarSystemPlanet.poll() +
                " вернули, и удалили.");
        System.out.println("----------------- Текущее состояние коллекции -----------------");
        solarSystemPlanet.forEach(System.out::println);
    }
}
