package MyInterfaces;

import MyClasses.*;
import MySimpleLinkedList.MySpaceQueue.MySpaceObjectQueue;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
/*
Если наследоваться от junit.framework.TestCase, т.е. сделать текущий
тестовый класс SpaceObjectCollectionTest extends TestCase, то методы
с параметрами в аннотации, например:
--------------------------------------------------------------------
@Test(expected = NoSuchElementException.class)
    public void testElement_IfQueueIsEmptyThrowsAnException()
--------------------------------------------------------------------
будут при верной сработке возвращать провал.
Версии Junit3,Junit4 и Junit5 хоть и похожи, имеют некие отличия.

Используем вариант без импорта и наследования:
- import junit.framework.TestCase;
используем вариант с импортом:
- import static org.junit.Assert.*;
*/
import static org.junit.Assert.*;

/*
Тестируем методы интерфейса SpaceObjectQueue.
В данной реализации класса коллекции, мы оставили
много методов из коллекции LinkedList и дополнили
функционал методами интерфейса Queue:
- *.peek();
- *.poll();
- *.element()();
*/
public class SpaceObjectCollectionTest {
    // Создаем ссылки на первоначальные коллекции
    private SpaceObjectQueue spaceObjectQueueTest;
    // Метод предварительной настройки, грузится перед каждым тестовым методом
    @Before
    public void setUp() throws Exception {
        // Инициализировали коллекции
        spaceObjectQueueTest = new MySpaceObjectQueue();
        // Загрузили коллекции элементами по 10 шт. в каждую
        for (int i = 0; i < 100; i++) {
            spaceObjectQueueTest.add(new Asteroid("asteroid",
                                                 "PlanetsKiller" + i, i * 100));
            }
    }
    /*
    Загружаем в коллекцию сто элементов и проверяем
    их количество простым поэлементным перебором,
    через forEach.
    */
    @Test
    public void testForeachForMySpaceObjectQueue() {
        int index = 0;
        for (SpaceObject spaceObject: spaceObjectQueueTest) {
            index++;
        }
        assertEquals(100, index);
    }

    /*
    Загружаем в коллекцию сто элементов, далее используя
    фильтр и удаляем из них 'четные элементы' методом
    *.remove(), предоставленным Iterator - ом.

    Далее в цикле forEach подсчитываем количество оставшихся
    элементов в коллекции.
    */
    @Test
    public void testForeachWithRemoveByIteratorMethodInMyQueue() {
        int index = 0;
        // Перебираем элементы списка и удаляем все кратные 200 без остатка
        Iterator<SpaceObject> testIterator = spaceObjectQueueTest.iterator();
        while (testIterator.hasNext()){
            if(testIterator.next().getRadius() % 200 == 0){
                testIterator.remove();
            }
        }
        // Их должно остаться 50
        for (SpaceObject spaceObject: spaceObjectQueueTest) {
            index++;
        }
        // Проверяем соответствие
        assertEquals(50, index);
    }

    // Проверяем метод *.size()
    @Test
    public void testSize_If_100_ElementsArePlacedInTheCollectionsThenSize_100() {
        /*
        Первичная загрузка 100 элементов, должна
        совпадать с ожидаемым аргументом - 'expected'.
        */
        assertEquals(100, spaceObjectQueueTest.size());
    }
    // Проверка метода *.add()
    @Test
    public void testAdd_IfElementIsPlacedInTheCollectionsThenSizeShouldIncrease() {
        SpaceObject elementAddedToCollection =
                new SpaceObject("star","AlphaTantala", 82581.3);
        /*
        В примере Junit_Less_1 мы не возвращали true/false
        в методах типа *.add(), в данном случае это реализовано
        и кроме факта добавления мы проверяем возвращаемый флаг.
        */
        assertTrue(spaceObjectQueueTest.add(elementAddedToCollection));
        /*
        Тестируем добавление элементов в каждую коллекцию по 1 - ой
        шт., и тут же проверяем изменение значения size на такую же
        величину.
         */
        assertEquals(101, spaceObjectQueueTest.size());
    }
    // Тестируем метод *.remove() на true
    @Test
    public void testRemove_IfRemoveOneElementFromCollectionsThenSizeShouldDecrease() {
        // При удачном удалении элемента из коллекции, метод должен вернуть true
        assertTrue(spaceObjectQueueTest.remove(new Asteroid("asteroid",
                "PlanetsKiller1", 100)));
        // При удачном удалении одно элемента из коллекции, размер должен уменьшиться на 1
        assertEquals(99, spaceObjectQueueTest.size());
    }

    /*
    Тестируем метод *.remove() на true. Данного метода
    в такой конфигурации в стандартной коллекции Queue
    нет. Есть метод *.remove(), без аргументов на входе,
    который возвращает с удалением элемент из начала очереди.
    Если очередь пуста, генерирует исключение NoSuchElementException.
    Мы не стали реализовывать данный код, оставив старый от
    LinkedList
    */
    @Test
    public void testRemove_IfTryDeleteNonExistentElementFromCollectionsThenSizeWillNotChange() {
        // При не удачном удалении элемента из коллекции, метод должен вернуть false
        assertFalse(spaceObjectQueueTest.remove(new Asteroid("asteroid",
                "StarShipKiller", 10)));
        // При не удачном удалении одно элемента из коллекции, ее размер не должен измениться
        assertEquals(100, spaceObjectQueueTest.size());
    }
    // Тестируем метод *.clear()
    @Test
    public void testClear_whenQueueClearedThenSizeMustBeZero() {
        // Применяем очистку ко всем доступным тестовым коллекциям
        spaceObjectQueueTest.clear();
        // Проверяем соответствие нулю после очистки
        assertEquals(0, spaceObjectQueueTest.size());
    }
    // Если искомый элемент в коллекции есть вернется true
    @Test
    public void testContains_IfDesiredElementIsInCollectionsThenTruthWillReturn() {
        // Передаем в метод объект, который точно в коллекции есть
        assertTrue(spaceObjectQueueTest.contains(
                new Asteroid("asteroid",
                            "PlanetsKiller3", 300)));
    }
    // Если искомого элемента в коллекции нет вернется false
    @Test
    public void testContains_IfDesiredElementIsNotInCollectionsThenFalseWillReturn() {
        // Передаем в метод объект, которого точно в коллекции нет
        assertFalse(spaceObjectQueueTest.contains(
                new Asteroid("planetoid",
                            "Beldyashki", 450.3)));
    }
    // Проверяем метод *.poll() - возвращаем первый элемент очереди и удаляем его.
    @Test
    public void testPoll_IfRemoveElementFromFrontOfQueueSizeOfCollectionWillDecreaseByOne() {
        // Определяем элемент из начала очереди
        SpaceObject testObject = new Asteroid("asteroid",
                "PlanetsKiller0", 0);
        // Запускаем метод *.pool() и проверяем соответствие
        assertEquals(testObject,spaceObjectQueueTest.poll());
        // Элемент возвращен и удален
        assertEquals(99,spaceObjectQueueTest.size());
        // Переназначаем элемент и повторяем операции
        testObject = new Asteroid("asteroid",
                "PlanetsKiller1", 100);
        assertEquals(testObject,spaceObjectQueueTest.poll());
        assertEquals(98,spaceObjectQueueTest.size());
    }
    // Тестируем метод *.poll() на возврат null
    @Test
    public void testPoll_IfQueueIsEmptyThePollMethodWillReturnNull() {
        // Чисти коллекцию
        spaceObjectQueueTest.clear();
        // Запускаем метод *.pool() и проверяем соответствие
        assertEquals(null,spaceObjectQueueTest.poll());
    }
    // Проверяем метод *.peek(), возвращаем элемент из головы очереди без удаления
    @Test
    public void testPeek_GetElementFromHeadOfQueueWithoutDeletingItSizeOfCollectionHasNotChanged() {
        // Определяем элемент из начала очереди
        SpaceObject testObject = new Asteroid("asteroid",
                "PlanetsKiller0", 0);
        // Запускаем метод и проверяем соответствие
        assertEquals(testObject,spaceObjectQueueTest.peek());
        assertEquals(100,spaceObjectQueueTest.size());
    }
    /*
    Проверяем метод *.peek(), возвращаем элемент из головы
    очереди без удаления, если очередь пуста возвращаем null
    */
    @Test
    public void testPeek_IfQueueIsEmptyMethodPeekWillReturnNull() {
        // Чистим очередь
        spaceObjectQueueTest.clear();
        assertEquals(null,spaceObjectQueueTest.peek());
    }
    /*
    Тестируем метод *.element(), который возвращает элемент
    из головы очереди, но если коллекция пуста метод выбрасывает
    исключение.
    */
    @Test(expected = NoSuchElementException.class)
    public void testElement_IfQueueIsEmptyElementMethodThrowsAnException() {
        // Очистим коллекцию
        spaceObjectQueueTest.clear();
        // Пытаемся получить первый элемент очереди
        spaceObjectQueueTest.element();
    }
    /*
    Тестируем метод *.element(), который возвращает элемент
    из головы очереди, на этот раз очередь не пуста и мы
    должны получить элемент буз удаления его из головы очереди.
    */
    @Test
    public void testElement_IfQueueIsNotEmptyElementMethodReturnHeadOfQueue() {
        SpaceObject testObject = new Asteroid("asteroid",
                                             "PlanetsKiller0", 0);
        // Пытаемся получить первый элемент очереди
        assertEquals(testObject,spaceObjectQueueTest.element());
        // Элемент возвращен и не удален
        assertEquals(100,spaceObjectQueueTest.size());
    }

}