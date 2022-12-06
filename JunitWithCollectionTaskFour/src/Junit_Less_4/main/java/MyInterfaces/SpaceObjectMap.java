package MyInterfaces;
/*
Поскольку это учебная реализация Map,
мы немного побудем читерами, применим
уже реализованные в Java интерфейсы
коллекций Set и List, при написании
методов keySet() и values().

Снова реализация на уровне абстракции,
т.е. указываем, что должен уметь класс
имплементирующий данный интерфейс.
*/

import MyClasses.Discoverer;
import MyClasses.SpaceObject.SpaceObject;

import java.util.List;
import java.util.Set;

// Интерфейс описывающий способности нашего списка
public interface SpaceObjectMap {
    void put(Discoverer key, SpaceObject value); // Метод загрузки данных в Map (ключ + объект)
    SpaceObject get(Discoverer key); // Метод извлечения объекта из коллекции по ключу
    Set<Discoverer> keySet(); // Метод возвращающий коллекцию ключей (не могут повторяться)
    List<SpaceObject> values(); // Метод возвращающий список всех объектов под ключами (могут повторяться)
    boolean remove(Discoverer key); // Метод удаляющий элемент из Map по ключу
    int size(); // Размер Map
    void clear(); // Полная очистка коллекции Map
}
