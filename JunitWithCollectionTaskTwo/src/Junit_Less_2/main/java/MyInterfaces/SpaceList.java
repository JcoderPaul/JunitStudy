package MyInterfaces;
/*
Формируем наш будущие списки не зависимо от
фактической реализации на уровне абстракции,
т.е. описываем, что же наши списки должны
уметь делать.
*/

import MyClasses.SpaceObject;

// Интерфейс описывающий способности нашего списка
public interface SpaceList extends SpaceObjectCollection{
    SpaceObject get(int index); // Получить элемент списка по индексу
    boolean add(SpaceObject spaceObject, int index); // Добавить элемент в определенное место списка
    boolean removeAt(int index); // Удалить элемент по индексу

    boolean add(SpaceObject spaceObject); // Добавить элемент в определенное место списка
    boolean remove(SpaceObject spaceObject); // Удалить элемент
    int size(); // Определяем размер нашего списка
    void clear(); // Полностью чистим наш список
}
