package MySimpleArrayList;
/*
В данном примере мы создаем и тестируем
полуфункциональную модель списка космических тел.
*/

import MyClasses.Asteroid;
import MyClasses.Planet;
import MyClasses.SpaceObject;
import MyClasses.Star;
import MySimpleArrayList.MySpaceList.MySpaceArrayList;

public class Less_SimpleListMainApp {
    public static void main(String[] args) {
        // Создали наш список
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
        // Выводим список на печать
        System.out.println("-------------- Печать списка --------------");
        for (SpaceObject myList: solarSystemList.getArray()) {
            System.out.println(myList);
        }
        System.out.println(solarSystemList.size());
        System.out.println("-------------- Добавляем Нептун --------------");
        SpaceObject neptune = new SpaceObject("планета","Нептун",24764.2);
        solarSystemList.add(neptune);
        System.out.println("-------------- Печать после добавления Нептуна --------------");
        for (SpaceObject myList: solarSystemList.getArray()) {
            System.out.println(myList);
        }
        System.out.println("-------------- Испытываем метод *.size() и *.get(Index) --------------");
        System.out.println("Размер списка : " + solarSystemList.size());
        System.out.println("Планета под индексом 4 -> " + solarSystemList.get(4));
        System.out.println("-------------- Испытываем метод *.removeAt(Index) --------------");
        System.out.println("Удалось удалить объект с индексом 2 - > " + solarSystemList.removeAt(2));
        System.out.println("-------------- Печать списка после удаления элемента со 2 - м индексом --------------");
        for (SpaceObject myList: solarSystemList.getArray()) {
            System.out.println(myList);
        }
        System.out.println("-------------- Чистим весь список *.clear() --------------");
        solarSystemList.clear();
        System.out.println("-------------- Печать списка после полной чистки --------------");
        for (SpaceObject myList: solarSystemList.getArray()) {
            System.out.println(myList);
        }
        System.out.println("-------------- Добавляем звездный объект в пустой список и выводим на экран --------------");
        earth = new Planet("планета","Земля",6378.1);
        SpaceObject astra = new Asteroid("астероид","Астрея",384.9);
        SpaceObject sun = new Star("звезда","Солнце",695510.4);
        ((Planet) earth).setCountOfSatellite(1);
        ((Star) sun).setSpectralClass("G2V");
        solarSystemList.add(earth);
        solarSystemList.add(astra);
        solarSystemList.add(sun);
        for (SpaceObject myList: solarSystemList.getArray()) {
            System.out.print("Вид объекта: '" + myList.getKindOfSpaceObject() +
                               "' название '" + myList.getNameOfSpaceObject() +
                               "' радиус '" + myList.getRadius() + "'");
            if(myList.getClass() == Planet.class){
                System.out.println(" имеет спутники: " + ((Planet) myList).getCountOfSatellite() + " шт.");
            }
            if(myList.getClass() == Star.class){
                System.out.println(" спектральный класс: " + ((Star) myList).getSpectralClass());
            }
            if(myList.getClass() == Asteroid.class){
                System.out.println("");
            }
        }
        System.out.println("\n-------------- Простой вывод списка на экран --------------");
        for (SpaceObject myList: solarSystemList.getArray()) {
            System.out.println(myList);
        }
    }
}
