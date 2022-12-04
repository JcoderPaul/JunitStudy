package MyInterfaces;

/*
Снова создаем интерфейс, который описывает
способности нашего Set-а (нашей коллекции
содержащей только оригинальные элементы) на
уровне абстракции. Конкретная реализация
каждого метода описывается в конкретном
классе подписанном на данный интерфейс.
*/

import MyClasses.SpaceObject;

public interface SpaceSet extends SpaceObjectCollection{
    // Добавляем элемент
    boolean add(SpaceObject spaceObject);
    // Удаляем элемент
    boolean remove(SpaceObject spaceObject);
    // Отображаем размер коллекции
    int size();
    // Удаляем все элементы коллекции
    void clear();
    // Возвращает true если переданный в аргументах элемент есть в коллекции
    boolean contains(SpaceObject spaceObject);
    // Возвращает true если наш SpaceSet пустой
    boolean isEmpty();
}
