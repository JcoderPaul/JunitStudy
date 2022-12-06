Продолжаем изучать фреймворк Junit4, при помощи 
самописных коллекций, аналогов уже готовых в Java. 

Отличие текущего примера от предыдущего в том, что 
наш супер-интерфейс, имплементирует интерфейс Iterable. 
Это привело к тому, что его наследники, и классы 
подписанные на этих наследников должны реализовать
метод *.iterator() или 'переборщик'. Что позволит
перебирать по элементно любую из наших коллекций.

Каждая коллекция имея свои внутренние особенности
реализации будет иметь самостоятельные реализации
этого метода.

Поскольку метод возвращаем объект Iterator<T> в каждом
из реализованных методов, мы создаем данный объект и 
реализуем три метода: *.hasNext(), *.next(), *.remove()
(см. описание в каждом из классов коллекций)

В данном примере мы будем тестировать только реализацию
методов Iterator - а, т.к. в предыдущих примерах, тесты
для других методов обкатаны по два раза. Однако в реальном
проекте, как я понимаю, необходимо каждое изменение и
возможные ошибки ретестировать по-максимому, даже в 
обкатанном методе.

И так:
- Шаг 0 - пишем тесты под будущие реализации методов коллекций;
- Шаг 1 - пишем собственные реализации коллекций;
- Шаг 2 - тестируем написанный код при помощи Junit 4;

Пример содержит классы:
- [SpaceObject](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MyClasses/SpaceObject.java) - класс для создания объектов 'Космическое тело', которые мы будем добавлять в коллекции.
- [Asteroid](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MyClasses/Asteroid.java) - наследник класса SpaceObject, не имеет особых полей;
- [Planet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MyClasses/Planet.java) - наследник класса SpaceObject, имеет поле 'количество спутников';
- [Star](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MyClasses/Star.java) - наследник класса SpaceObject, имеет поле 'спектральный класс';

Пример содержит интерфейсы:
- [SpaceList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MyInterfaces/SpaceList.java) - интерфейс, который будут имплементировать наши самописные коллекции типа List и LinkedList;
- [SpaceSet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MyInterfaces/SpaceSet.java) - интерфейс, который будет имплементировать наша самописная коллекция HashSet;
- [SpaceObjectCollection](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MyInterfaces/SpaceObjectCollection.java) - супер-интерфейс для всех коллекций;

Пример содержит классы реализующие идею коллекций:
- [MySpaceArrayList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MySimpleArrayList/MySpaceList/MySpaceArrayList.java) - простой лист или коллекция ArrayList;
- [MySpaceLinkedList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MySimpleLinkedList/MySpaceLinkedList/MySpaceLinkedList.java) - простой двусвязный список, наша реализация LinkedList;
- [MySpaceHashSet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/main/java/MySimpleHashSet/MySpaceHashSet/MySpaceHashSet.java) - простая коллекция неповторяющихся элементов Set или HashSet;

Пример содержит тесты:
- [SpaceObjectCollectionTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskThree/src/Junit_Less_3/test/java/MyInterfaces/SpaceObjectCollectionTest.java) - тестирование методов супер-интерфейса в котором задействован Iterator.


