package MyInterfaces;
/*
Поскольку SpaceList интерфейс, а MySpaceArrayList и MySpaceLinkedList
это классы реализующие его, то тесты на проверку работоспособности
их методов, будут практически похожи (если не идентичными).

И тогда, написав полный тест-лист для проверки, например, MySpaceArrayList
мы легко можем заменить класс ссылки listOfSpaseObject с одной
реализации списка на другую, скорректировав создаваемый объект в классе
*.setUp() на требуемый в тесте.

Но для простоты (пока учимся) мы создали 2-а файла:
- SpaceLinkedListTest;
- SpaceListTest;
Содержащих 99% дублирующего кода, отличие только в тестируемом классе.
*/
import MyClasses.Asteroid;
import MyClasses.Planet;
import MyClasses.SpaceObject;
import MySimpleArrayList.MySpaceList.MySpaceArrayList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceArrayListTest {
    /*
    Задаем имя нашего будущего списка с которым
    будут работать все наши будущие тесты.
    */
    private MySpaceArrayList listOfSpaseObject;

    /*
    Метод setUp() имеет аннотацию @Before - эта
    аннотация означает, что данный метод, с
    говорящим названием 'настраивать', будет
    запускаться перед каждым тестом, в данном
    тест-листе.
    */
    @Before
    public void setUp() throws Exception {
        /*
        Присваиваем нашей переменной ссылку на тестовый список,
        именно с ним будут проходить все тестовые манипуляции.
        */
        listOfSpaseObject = new MySpaceArrayList();
        // Заполняем его 50-ю элементами класса SpaceObject
        for (int i = 0; i < 50; i++) {
            listOfSpaseObject.add(
                    new SpaceObject("астероид",
                                   "Asteroid" + i,
                                              i * 100.4));
        }
    }
    /*
    Первый тест.
    Проверяем работоспособность трех методов одновременно
    (что не правильно):
    - Если все прошло нормально на стадии заполнения списка,
      то метод *.add() работает и мы проверяем, как себя ведет
      метод *.size().

      Т.к. мы добавили 50 элементов в список, то метод *.size()
      должен вернуть 50. Т.е. ожидаем 50 - получаем 50 - все
      нормально.

    - Запускаем метод *.clear() и чистим наш список, т.е. его
      размер становится равным 0. Снова проверяем соответствие.

    */
    @Test
    public void testSizeAndTestClearInOneStep() {
        assertEquals(50, listOfSpaseObject.size());
        listOfSpaseObject.clear();
        assertEquals(0, listOfSpaseObject.size());
    }

    /*
    Второй тест.
    Проверяем работоспособность метода *.clear() отдельно.
    */
    @Test
    public void whenListClearedThenSizeMustBe0() {
        listOfSpaseObject.clear();
        assertEquals(0, listOfSpaseObject.size());
    }
    /*
    Третий тест.
    Метод *.getArray() не прописан в интерфейсе, а
    принадлежит классу MySpaceArrayList, и возвращает
    массив не нулевых элементов списка. Значит мы
    можем получить фактический размер списка,
    но стандартными, проверенными, методами Java,
    например, получить размер массива, т.к. именно
    его (массив) и возвращает метод.
    */
    @Test
    public void whenAdded50NotNullElementsThenSizeMustBeLikeSizeOfGetArraySize() {
        int count = listOfSpaseObject.getArray().length;
        assertEquals(50, count);
    }
    /*
    Четвертый тест.
    Проверяем, как самостоятельно, без дополнительного обвеса,
    работает метод *.size()
    */
    @Test
    public void whenAdded50ElementsThenSizeMustBe50() {
        assertEquals(50, listOfSpaseObject.size());
    }
    /*
    Пятый тест.
    Проверяем как работает метод *.remove(index) - удаление
    элемента по индексу из нашего листа. Если мы удачно
    добавили 50 элементов в список и удалим 1, то останется 49.
    */
    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        /*
        Данная проверка должна вернуть true, если элемент
        удачно удален, т.к. сам метод *.removeAt(index)
        при удачном удалении возвращает true.
        */
        assertTrue(listOfSpaseObject.removeAt(9));
        /*
        Метод вернет соответствие ожидаемого значения
        49 и реального, если наш метод удаления по индексу
        сработал, метод *.size() мы оттестировали выше.
        */
        assertEquals(49, listOfSpaseObject.size());
    }
    /*
    Шестой тест.
    Пытаемся удалить не существующий в нашем списке объект.
    Поскольку его нет, то результат удаления будет false,
    и размер списка не измениться 50 было - 50 осталось.
    */
    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        SpaceObject nonExistentListItem =
                new Planet("планета",
                          "Kapella 542-23-45 Q",
                                     49452.4, 15);
        assertFalse(listOfSpaseObject.remove(nonExistentListItem));
        assertEquals(50, listOfSpaseObject.size());
    }
    /*
    Седьмой тест.
    Добавляем элемент в наш список методом *.add().
    Хотя данный метод был проверен на этапе
    инициализации, тут мы могли бы протестировать
    все перегруженные методы, если бы они были.

    И так, добавляем элемент и размер нашего списка
    должен стать 51, проверяем соответствие.
    */
    @Test
    public void whenElementAddThenSizeMustBeIncrease() {
        SpaceObject elementAddedToTheList =
                new Asteroid("астероид",
                            "Aminar 2271342-Q12",
                                       235.3);
        listOfSpaseObject.add(elementAddedToTheList);
        assertEquals(51, listOfSpaseObject.size());
    }
    /*
    Восьмой тест.
    Проверяем работу метода *.remove() - удаление конкретного
    объекта из коллекции, при его наличии. Метод должен удалить
    элемент и вернуть true, если все прошло хорошо.
    */
    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        /*
        Задаем значение заранее известного элемента,
        который точно есть в коллекции и его можно
        будет удачно удалить, т.е. с исходом true.
        */
        SpaceObject elementToBeRemovedFromTheList =
                new SpaceObject("астероид","Asteroid0", 0.0);
        // Удаляем и получаем возвращаемое значение boolean
        assertTrue(listOfSpaseObject.remove(elementToBeRemovedFromTheList));
        // Проверяем соответствие 50 было, -1, осталось 49.
        assertEquals(49, listOfSpaseObject.size());
    }
    /*
    Девятый тест.
    Тут мы тестируем метод *.get(), который возвращает
    элемент по индексу, но если мы пытаемся получить
    элемент списка явно из-за его пределов (index < 0
    или index > size), то метод должен бросить исключение.

    И вот тут в работу идет описание в скобочках, которое
    следует после аннотации. Мы ожидаем исключение.
    */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        listOfSpaseObject.get(67);
    }
    /*
    Десятый тест.
    Тут мы проверяем работу метода *.get(index),
    который возвращает объект списка по индексу.
    Мы сравниваем соответствие ожидаемого имени
    объекта и полученного при помощи метода.
    */
    @Test
    public void methodGetReturnedRightValue() {
        SpaceObject getZeroTestElementOfArray = listOfSpaseObject.get(0);
        assertEquals("Asteroid0", getZeroTestElementOfArray.getKindOfSpaceObject());
    }
}