package MyInterfaces;
/*
Формируем нашу будущую очередь не зависимо от
фактической реализации, как и в предыдущих
примерах на уровне абстракции, описываем, что
же наша очередь должна уметь делать.
*/

import MyClasses.SpaceObject;

// Интерфейс описывающий способности нашей очереди
public interface SpaceObjectQueue extends SpaceObjectCollection{
    boolean add(SpaceObject spaceObject); // Добавить элемент в очередь
    SpaceObject peek(); // Возвращает без удаления элемент из начала очереди
    SpaceObject poll(); // Возвращает с удалением элемент из начала очереди.
    SpaceObject get(int index); // Получить элемент очереди по индексу (неспецифический метод)
    boolean removeAt(int index); // Удалить элемент по индексу (неспецифический метод)
    int size(); // Определяем размер нашей очереди
    void clear(); // Полностью чистим нашу очередь
    SpaceObject element(); // Возвращает, но не удаляет, элемент из начала очереди.
}
