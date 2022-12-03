package JunitCollectionsTasksOne.MySimpleList;
/*
В данном примере мы создаем и тестируем
полуфункциональную модель списка космических тел.
*/
import JunitCollectionsTasksOne.MyClasses.SpaceObject;
import JunitCollectionsTasksOne.MySimpleList.MySpaceList.MySpaceList;

public class Less_SimpleListMainApp {
    public static void main(String[] args) {
        // Создали наш список
        MySpaceList solarSystemPlanet = new MySpaceList();
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
        // Выводим список на печать
        System.out.println("-------------- Печать списка --------------");
        for (SpaceObject myList: solarSystemPlanet.getArray()) {
            System.out.println(myList);
        }
        System.out.println(solarSystemPlanet.size());
        System.out.println("-------------- Добавляем Нептун --------------");
        SpaceObject neptune = new SpaceObject("Нептун",24764.2);
        solarSystemPlanet.add(neptune);
        System.out.println("-------------- Печать после добавления Нептуна --------------");
        for (SpaceObject myList: solarSystemPlanet.getArray()) {
            System.out.println(myList);
        }
        System.out.println("-------------- Испытываем метод *.size() и *.get(Index) --------------");
        System.out.println("Размер списка : " + solarSystemPlanet.size());
        System.out.println("Планета под индексом 4 -> " + solarSystemPlanet.get(4));
        System.out.println("-------------- Испытываем метод *.removeAt(Index) --------------");
        System.out.println("Удалось удалить объект с индексом 2 - > " + solarSystemPlanet.removeAt(2));
        System.out.println("-------------- Печать списка после удаления элемента со 2 - м индексом --------------");
        for (SpaceObject myList: solarSystemPlanet.getArray()) {
            System.out.println(myList);
        }
        System.out.println("-------------- Чистим весь список *.clear() --------------");
        solarSystemPlanet.clear();
        System.out.println("-------------- Печать списка после полной чистки --------------");
        for (SpaceObject myList: solarSystemPlanet.getArray()) {
            System.out.println(myList);
        }

    }
}
