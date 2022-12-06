package MyInterfaces;
/*
Для того чтобы мы могли извлекать из наших
коллекций элементы не имея метода *.get(Index)
нам необходимо иметь возможность перебирать
нашу самописную коллекцию по-элементно.

Для этого мы должны, либо написать некий метод
реализующий данный функционал, либо подписать
наши коллекции на интерфейс Iterable и
реализовать в них два метода *.hasNext() и
*.next().
*/
import MyClasses.SpaceObject;

public interface SpaceObjectCollection extends Iterable<SpaceObject>{
        boolean add(SpaceObject spaceObject);

        boolean remove(SpaceObject spaceObject);

        int size();

        void clear();

        boolean contains(SpaceObject spaceObject);
}
