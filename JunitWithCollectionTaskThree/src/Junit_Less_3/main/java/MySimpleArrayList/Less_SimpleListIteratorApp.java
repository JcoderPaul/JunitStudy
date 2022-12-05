package MySimpleArrayList;

import MyClasses.SpaceObject;
import MySimpleArrayList.MySpaceList.MySpaceArrayList;

import java.util.Iterator;

public class Less_SimpleListIteratorApp {
    public static void main(String[] args) {
        MySpaceArrayList solarSystemList = new MySpaceArrayList();
        // Создали объекты списка
        SpaceObject mercury = new SpaceObject("планета","Меркурий",2439.7);
        SpaceObject venus = new SpaceObject("планета","Венера",6051.8);
        SpaceObject earth = new SpaceObject("планета","Земля",6378.1);
        SpaceObject mars = new SpaceObject("планета","Марс",3396.2);
        SpaceObject jupiter = new SpaceObject("планета","Юпитер",71492.1);
        SpaceObject saturn = new SpaceObject("планета","Сатурн",60268.4);
        SpaceObject uranus = new SpaceObject("планета","Уран",25559.5);
        // Заполняем список объектами
        solarSystemList.add(mercury);
        solarSystemList.add(venus);
        solarSystemList.add(earth);
        solarSystemList.add(mars);
        solarSystemList.add(jupiter);
        solarSystemList.add(saturn);
        solarSystemList.add(uranus);
        System.out.println("----------------- Вывод на экран через цикл forEach -----------------");
        for (SpaceObject prn: solarSystemList) {
            System.out.println(prn);
        }
        System.out.println("----------------- Вывод на экран через цикл while + Iterator -----------------");
        Iterator<SpaceObject> myIterator = solarSystemList.iterator();
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
        solarSystemList.forEach(System.out::println);
    }
}
