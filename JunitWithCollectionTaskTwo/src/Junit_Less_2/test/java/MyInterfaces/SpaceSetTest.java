package MyInterfaces;

import MyClasses.Asteroid;
import MyClasses.SpaceObject;
import MyClasses.Star;
import MySimpleHashSet.MySpaceHashSet.MySpaceHashSet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpaceSetTest {
    // Объявляем нашу будущую тестовую коллекцию
    private MySpaceHashSet hashSetOfSpaseObject;
    /*
    Описываем что нужно сделать перед каждым нашим тестом.
    В нашем случае мы заполняем коллекцию 50 объектами SpaceObject.
    */
    @Before
    public void setUp() throws Exception {
        hashSetOfSpaseObject = new MySpaceHashSet();
        for (int i = 0; i < 50; i++) {
            hashSetOfSpaseObject.add(
                    new Asteroid("астероид",
                                "Asteroid" + i,
                                          i * 100.4));
        }
    }
    /*
    Простой тест, на проверку метода *.size().
    Если в коллекцию залили 50 элементов, размер
    должен соответствовать.
    */
    @Test
    public void whenAdded50ElementsThenSizeMustBe50() {
        assertEquals(50, hashSetOfSpaseObject.size());
    }
    /*
    Тестируем метод *.remove(Object obj) удаляющий
    элемент из коллекции по-содержимому. Первое -
    если удаление прошло удачно, то возвращаем true -
    метод 'assertTrue'. Второе - если удаление прошло
    на ура, размер коллекции уменьшился -1 и стал 49,
    значит метод 'assertEquals' выявит соответствие или
    расхождение.
    */
    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
            assertTrue(hashSetOfSpaseObject.remove(
                    new Asteroid("астероид",
                                "Asteroid0",
                                           0)));
            assertEquals(49, hashSetOfSpaseObject.size());
    }
    /*
    Повторная проверка метода *.size(), зная исходный
    размер коллекции, мы можем изменять ее размер,
    добавляя и удаляя элементы из нее. Параллельно
    тестируя методы *.add() и *.remove(), которые лучше
    тестировать отдельно и в определенной, логической
    последовательности.
    */
    @Test
    public void size() {
        SpaceObject elementAddedToTheList =
                new SpaceObject("звезда","Альфа Эридана", 821581.3);
        hashSetOfSpaseObject.add(elementAddedToTheList);
        assertEquals(51, hashSetOfSpaseObject.size());
        assertTrue(hashSetOfSpaseObject.remove(
                new Asteroid("астероид","Asteroid1",100.4)));
        assertTrue(hashSetOfSpaseObject.remove(elementAddedToTheList));
        assertEquals(49, hashSetOfSpaseObject.size());
    }
    /*
    Проверяем удаление не существующего объекта из коллекции.
    */
    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        SpaceObject nonExistentListItem =
                new SpaceObject("планета","Yaper 762-2389-45 ZQ", 41452.4);
        assertFalse(hashSetOfSpaseObject.remove(nonExistentListItem));
        assertEquals(50, hashSetOfSpaseObject.size());
    }
    /* Проверяем работу метода *.add() */
    @Test
    public void whenElementAddThenSizeMustBeIncrease() {
        SpaceObject elementAddedToTheList =
                new Asteroid("астероид","Ichikava Q2-Z133", 281.3);
        hashSetOfSpaseObject.add(elementAddedToTheList);
        assertEquals(51, hashSetOfSpaseObject.size());
    }
    /* Проверяем работу метода *.remove() */
    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        SpaceObject elementToBeRemovedFromTheList =
                new Asteroid("астероид","Asteroid2", 200.8);
        assertTrue(hashSetOfSpaseObject.remove(elementToBeRemovedFromTheList));
        assertEquals(49, hashSetOfSpaseObject.size());
    }
    /* Проверяем метод *.clear() */
    @Test
    public void whenListClearedThenSizeMustBe0() {
        hashSetOfSpaseObject.clear();
        assertEquals(0, hashSetOfSpaseObject.size());
    }
    /* Проверяем метод *.isEmpty() */
    @Test
    public void testIsEmptyMethod() {
        /*
        Перед запуском теста, метод *.setUp() загрузит коллекцию,
        значит она будет не пуста, и метод *.isEmpty() вернет false,
        Далее мы чистим коллекцию и снова проверяем ее заполненность,
        на этот раз мы должны получить true из метода *.isEmpty()
         */
        assertFalse(hashSetOfSpaseObject.isEmpty());
        hashSetOfSpaseObject.clear();
        assertEquals(0, hashSetOfSpaseObject.size());
        assertTrue(hashSetOfSpaseObject.isEmpty());
    }

    @Test
    public void testContainsMethod() {
        /*
        Метод *.contains() возвращает true если, элемент
        переданный в аргументах есть в коллекции и false,
        если таковой не найден.
        */
        assertTrue(hashSetOfSpaseObject.contains(
                new Asteroid("астероид","Asteroid2", 200.8)));
        assertFalse(hashSetOfSpaseObject.contains(
                new Star("звезда","Wolf 342-12-K", 83581.3)));
    }
    /*
    Проверяем действительно ли мы создали Set из оригинальных
    объектов, которые в данной коллекции не повторяются.
    */
    @Test
    public void whenSameElementRemovedTwiceSizeDecreasedOne() {
        /*
        Помним, что при старте всех тестов мы инициализируем наш
        Set и там точно есть объект с описанными ниже характеристиками.
        Но мы добавим его еще раз, ожидая в случае правильной работы
        нашей коллекции неудачу.

        Далее удаляем объект два раза, каждый раз проверяя размер коллекции.
        В идеале:
        - добавляем существующий в коллекции объект - размер ее не изменится,
        т.к. объект не добавится.
        - удаляем существующий объект из коллекции - размер меняется на -1
        - повторно удаляем тот же объект (или возможную его копию) и ничего
        не происходит - размер коллекции не меняется.
        */
        hashSetOfSpaseObject.add(
                new Asteroid("астероид","Asteroid2", 200.8));
        assertEquals(50, hashSetOfSpaseObject.size());
        assertTrue(hashSetOfSpaseObject.remove(
                new Asteroid("астероид","Asteroid2", 200.8)));
        assertEquals(49, hashSetOfSpaseObject.size());
        assertFalse(hashSetOfSpaseObject.remove(
                new SpaceObject("астероид","Asteroid2", 200.8)));
        assertEquals(49, hashSetOfSpaseObject.size());
    }
}