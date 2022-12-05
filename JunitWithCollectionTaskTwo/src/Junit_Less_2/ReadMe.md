В данном задании, как и в предыдущем, так и в последующих этого разделе,
мы совмещаем полезное с очень полезным. Повторяем
коллекций Java и пишем собственные простые реализации
этих коллекций заточенных под однотипные объекты класса
SpaceObject с изучаем фреймворк Junit, предназначенный
для тестирования написанного кода.

Отличие от предыдущего примера в том, что мы создали
супер-интерфейс, который имплементируют наши варианты 
реализации интерфейсов List и Set. Так же наш класс
SpaceObject получил трех наследников, с которыми мы
будем работать в тестах Junit.

Т.е. потихоньку усложняем, шаг за шагом.

И так:
- Шаг 0 - пишем тесты под будущие реализации методов коллекций;
- Шаг 1 - пишем собственные реализации коллекций;
- Шаг 2 - тестируем написанный код при помощи Junit 4 (про 5 версию позже);

Пример содержит классы:
- [SpaceObject](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/MyClasses/SpaceObject.java) - класс для создания объектов 'Космическое тело', которые мы будем добавлять в коллекции.
- [Asteroid](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/MyClasses/Asteroid.java) - наследник класса SpaceObject, не имеет особых полей;
- [Planet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/MyClasses/Planet.java) - наследник класса SpaceObject, имеет поле 'количество спутников';
- [Star](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/MyClasses/Star.java) - наследник класса SpaceObject, имеет поле 'спектральный класс';

Пример содержит интерфейсы:
- [SpaceList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/MyInterfaces/SpaceList.java) - интерфейс, который будут имплементировать наши самописные коллекции типа List и LinkedList;
- [SpaceSet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/MyInterfaces/SpaceSet.java) - интерфейс, который будет имплементировать наша самописная коллекция HashSet;
- [SpaceObjectCollection](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/MyInterfaces/SpaceObjectCollection.java) - супер-интерфейс для всех коллекций;

Пример содержит классы реализующие идею коллекций:
- [MySpaceList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/JunitWithCollectionTaskTwo/MySimpleList/MySpaceList/MySpaceList.java) - простой лист или коллекция ArrayList;
- [MySpaceLinkedList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/JunitWithCollectionTaskTwo/MySimpleLinkedList/MySpaceLinkedList/MySpaceLinkedList.java) - простой двусвязный список, наша реализация LinkedList;
- [MySpaceHashSet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/main/java/JunitWithCollectionTaskTwo/MySimpleHashSet/MySpaceHashSet/MySpaceHashSet.java) - простая коллекция неповторяющихся элементов Set или HashSet;

Пример содержит тесты:
- [SpaceListTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/test/java/MyInterfaces/SpaceListTest.java) - набор тестов для проверки работоспособности методов коллекции MySpaceList;
- [SpaceLinkedListTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/test/java/MyInterfaces/SpaceLinkedListTest.java) - набор тестов для проверки работоспособности методов коллекции MySpaceLinkedList;
- [SpaceSetTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskTwo/src/Junit_Less_2/test/java/MyInterfaces/SpaceSetTest.java) - набор тестов для проверки работоспособности методов коллекции MySpaceHashSet;


