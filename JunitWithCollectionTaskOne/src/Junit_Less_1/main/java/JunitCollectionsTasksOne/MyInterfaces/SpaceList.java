package JunitCollectionsTasksOne.MyInterfaces;
/*
Формируем наш будущие списки не зависимо от
фактической реализации на уровне абстракции,
т.е. описываем, что же наши списки должны
уметь делать.
*/
import JunitCollectionsTasksOne.MyClasses.SpaceObject;
// Интерфейс описывающий способности нашего списка
public interface SpaceList {
    SpaceObject get(int index); // Получить элемент списка по индексу
    void add(SpaceObject spaceObject); // Добавить элемент в конец списка
    void add(SpaceObject spaceObject, int index); // Добавить элемент в определенное место списка
    boolean remove(SpaceObject spaceObject); // Удалить элемент
    boolean removeAt(int index); // Удалить элемент по индексу
    int size(); // Определяем размер нашего списка
    void clear(); // Полностью чистим наш список
}
