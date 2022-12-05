package MyInterfaces;

import MyClasses.Asteroid;
import MyClasses.Planet;
import MyClasses.SpaceObject;
import MyClasses.Star;
import MySimpleArrayList.MySpaceList.MySpaceArrayList;
import MySimpleHashSet.MySpaceHashSet.MySpaceHashSet;
import MySimpleLinkedList.MySpaceLinkedList.MySpaceLinkedList;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/*
Тестируем методы интерфейса SpaceObjectCollection,
но в данной реализации он имплиментирует интерфейс
Iterable и значит все классы подписанные на него
должны реализовать метод *.iterator() и реализовывать
соответствующие методы интерфейса Iterator. И по
большей части, именно их мы тут и тестируем.
*/
public class SpaceObjectCollectionTest extends TestCase {
    // Создаем ссылки на первоначальные коллекции
    private SpaceObjectCollection spaceListTest;
    private SpaceObjectCollection spaceLinkedListTest;
    private SpaceObjectCollection spaceHashSetTest;
    // Метод предварительной настройки, грузится перед каждым тестовым методом
    @Before
    public void setUp() throws Exception {
        // Инициализировали коллекции
        spaceListTest = new MySpaceArrayList();
        spaceLinkedListTest = new MySpaceLinkedList();
        spaceHashSetTest = new MySpaceHashSet();
        // Загрузили коллекции элементами по 10 шт. в каждую
        for (int i = 0; i < 100; i++) {
            spaceListTest.add(new Asteroid("asteroid",
                                          "PlanetsKiller" + i, i * 100));
            spaceLinkedListTest.add(new Planet("planet",
                                              "Exoplanet" + i, i * 1000));
            spaceHashSetTest.add(new Star("star",
                                         "RedDwarf" + i, i * 10000));
        }
    }
    /*
    Три последующих теста повторяют друг-друга,
    но для разных коллекций. Одна коллекция,
    один метод, один тест. Загружаем в коллекции
    по сто элементов и проверяем их количество
    простым поэлементным перебором, через forEach.
    */
    @Test
    public void testForeachForMySpaceObjectList() {
        int index = 0;
        for (SpaceObject spaceObject: spaceListTest) {
            index++;
        }
        assertEquals(100, index);
    }

    @Test
    public void testForeachForMySpaceObjectLinkedList() {
        int index = 0;
        for (SpaceObject spaceObject: spaceLinkedListTest) {
            index++;
        }
        assertEquals(100, index);
    }

    @Test
    public void testForeachForMySpaceObjectHashSet() {
        int index = 0;
        for (SpaceObject spaceObject: spaceHashSetTest) {
            index++;
        }
        assertEquals(100, index);
    }
    /*
    Три последующих теста снова повторяют друг-друга,
    и снова для разных коллекций. Одна коллекция, один
    метод, один тест.

    Загружаем в коллекции по сто элементов, далее используя
    фильтр и удаляем из них 'четные элементы' методом *.remove(),
    предоставленным Iterator - ом.

    Далее в цикле forEach подсчитываем количество оставшихся
    элементов в коллекции.
    */
    @Test
    public void testForeachWithRemoveByIteratorMethodInMyArrayList() {
        int index = 0;
        // Перебираем элементы списка и удаляем все кратные 200 без остатка
        Iterator<SpaceObject> testIterator = spaceListTest.iterator();
        while (testIterator.hasNext()){
            if(testIterator.next().getRadius() % 200 == 0){
                testIterator.remove();
            }
        }
        // Их должно остаться 50
        for (SpaceObject spaceObject: spaceListTest) {
            index++;
        }
        // Проверяем соответствие
        assertEquals(50, index);
    }

    @Test
    public void testForeachWithRemoveByIteratorMethodInMyLinkedList() {
        int index = 0;
        // Перебираем элементы списка и удаляем все кратные 200 без остатка
        Iterator<SpaceObject> testIterator = spaceLinkedListTest.iterator();
        while (testIterator.hasNext()){
            if(testIterator.next().getRadius() % 2000 == 0){
                testIterator.remove();
            }
        }
        // Их должно остаться 50
        for (SpaceObject spaceObject: spaceLinkedListTest) {
            index++;
        }
        // Проверяем соответствие
        assertEquals(50, index);
    }

    @Test
    public void testForeachWithRemoveByIteratorMethodInMyHashSet() {
        int index = 0;
        // Перебираем элементы списка и удаляем все кратные 200 без остатка
        Iterator<SpaceObject> testIterator = spaceHashSetTest.iterator();
        while (testIterator.hasNext()){
            if(testIterator.next().getRadius() % 20000 == 0){
                testIterator.remove();
            }
        }
        // Их должно остаться 50
        for (SpaceObject spaceObject: spaceHashSetTest) {
            index++;
        }
        // Проверяем соответствие
        assertEquals(50, index);
    }

    // Проверяем метод *.size()
    @Test
    public void testSize_If_10_ElementsArePlacedInTheCollectionsThenSize_10() {
        /*
        Первичная загрузка каждой коллекции 10 элементов,
        должно совпадать с ожидаемым аргументом - 'expected'.
        */
        assertEquals(100, spaceListTest.size());
        assertEquals(100, spaceLinkedListTest.size());
        assertEquals(100, spaceHashSetTest.size());
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
        assertTrue(spaceListTest.add(elementAddedToCollection));
        assertTrue(spaceLinkedListTest.add(elementAddedToCollection));
        assertTrue(spaceHashSetTest.add(elementAddedToCollection));
        /*
        Тестируем добавление элементов в каждую коллекцию по 1 - ой
        шт., и тут же проверяем изменение значения size на такую же
        величину.
         */
        assertEquals(101, spaceListTest.size());
        assertEquals(101, spaceListTest.size());
        assertEquals(101, spaceHashSetTest.size());
    }
    // Тестируем метод *.remove() на true
    @Test
    public void testRemove_IfRemoveOneElementFromCollectionsThenSizeShouldDecrease() {
        // При удачном удалении элемента из коллекции, метод должен вернуть true
        assertTrue(spaceListTest.remove(new Asteroid("asteroid",
                "PlanetsKiller1", 100)));
        assertTrue(spaceLinkedListTest.remove(new Planet("planet",
                "Exoplanet1", 1000)));
        assertTrue(spaceHashSetTest.remove(new Star("star",
                "RedDwarf1", 10000)));
        // При удачном удалении одно элемента из коллекции, размер должен уменьшиться на 1
        assertEquals(99, spaceListTest.size());
        assertEquals(99, spaceListTest.size());
        assertEquals(99, spaceHashSetTest.size());
    }

    // Тестируем метод *.remove() на true
    @Test
    public void testRemove_IfTryDeleteNonExistentElementFromCollectionsThenSizeWillNotChange() {
        // При не удачном удалении элемента из коллекции, метод должен вернуть false
        assertFalse(spaceListTest.remove(new Asteroid("asteroid",
                "StarShipKiller", 10)));
        assertFalse(spaceLinkedListTest.remove(new Planet("planet",
                "GasGiant", 100000)));
        assertFalse(spaceHashSetTest.remove(new Star("star",
                "BlackHole", 10000000)));
        // При не удачном удалении одно элемента из коллекции, ее размер не должен измениться
        assertEquals(100, spaceListTest.size());
        assertEquals(100, spaceListTest.size());
        assertEquals(100, spaceHashSetTest.size());
    }
    // Тестируем метод *.clear()
    @Test
    public void testClear_whenListClearedThenSizeMustBeZero() {
        // Применяем очистку ко всем доступным тестовым коллекциям
        spaceListTest.clear();
        spaceLinkedListTest.clear();
        spaceHashSetTest.clear();
        // Проверяем соответствие нулю после очистки
        assertEquals(0, spaceListTest.size());
        assertEquals(0, spaceLinkedListTest.size());
        assertEquals(0, spaceHashSetTest.size());
    }
    // Если искомый элемент в коллекции есть вернется true
    @Test
    public void testContains_IfDesiredElementIsInCollectionsThenTruthWillReturn() {
        // Передаем в метод объект, который точно в коллекции есть
        assertTrue(spaceListTest.contains(
                new Asteroid("asteroid",
                            "PlanetsKiller3", 300)));
        assertTrue(spaceLinkedListTest.contains(
                new Planet("planet",
                          "Exoplanet4", 4000)));
        assertTrue(spaceHashSetTest.contains(
                new Star("star",
                        "RedDwarf5", 50000)));
    }
    // Если искомого элемента в коллекции нет вернется false
    @Test
    public void testContains_IfDesiredElementIsNotInCollectionsThenFalseWillReturn() {
        // Передаем в метод объект, которого точно в коллекции нет
        assertFalse(spaceListTest.contains(
                new Asteroid("planetoid",
                            "Beldyashki", 450.3)));
        assertFalse(spaceLinkedListTest.contains(
                new Planet("planet",
                          "Tones", 48009.3)));
        assertFalse(spaceHashSetTest.contains(
                new Star("star",
                        "Arkalis", 684400.3)));
    }
}