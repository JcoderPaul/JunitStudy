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
/*
Тестируем методы интерфейса SpaceObjectCollection.
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
        for (int i = 0; i < 10; i++) {
            spaceListTest.add(new Asteroid("asteroid",
                                          "PlanetsKiller" + i, i * 100));
            spaceLinkedListTest.add(new Planet("planet",
                                              "Exoplanet" + i, i * 1000));
            spaceHashSetTest.add(new Star("star",
                                         "RedDwarf" + i, i * 10000));
        }
    }
    // Проверяем метод *.size()
    @Test
    public void testSize_If_10_ElementsArePlacedInTheCollectionsThenSize_10() {
        /*
        Первичная загрузка каждой коллекции 10 элементов,
        должно совпадать с ожидаемым аргументом - 'expected'.
        */
        assertEquals(10, spaceListTest.size());
        assertEquals(10, spaceLinkedListTest.size());
        assertEquals(10, spaceHashSetTest.size());
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
        assertEquals(11, spaceListTest.size());
        assertEquals(11, spaceListTest.size());
        assertEquals(11, spaceHashSetTest.size());
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
        assertEquals(9, spaceListTest.size());
        assertEquals(9, spaceListTest.size());
        assertEquals(9, spaceHashSetTest.size());
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
        assertEquals(10, spaceListTest.size());
        assertEquals(10, spaceListTest.size());
        assertEquals(10, spaceHashSetTest.size());
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