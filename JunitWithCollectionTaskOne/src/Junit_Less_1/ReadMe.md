В данном задании, как и в последующих в этом разделе,
мы совмещаем полезное с очень полезным. Повторение
коллекций Java и написание собственных простых реализаций
этих коллекций заточенных под однотипные объекты класса
SpaceObject с изучением фреймворка Junit, предназначенного
для тестирования написанного кода.

И так:
- Шаг 0 - пишем тесты под будущие реализации методов коллекций;
- Шаг 1 - пишем собственные реализации коллекций;
- Шаг 2 - тестируем написанный код при помощи Junit 4 (уже есть 5, но про него позже);

Пример содержит классы:
- [SpaceObject](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/main/java/JunitCollectionsTasksOne/MyClasses/SpaceObject.java) - класс для создания объектов 'Космическое тело', которые мы будем добавлять в коллекции.

- [SpaceList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/main/java/JunitCollectionsTasksOne/MyInterfaces/SpaceList.java) - интерфейс, который будут имплементировать наши самописные коллекции типа List и LinkedList;
- [SpaceSet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/main/java/JunitCollectionsTasksOne/MyInterfaces/SpaceSet.java) - интерфейс, который будет имплементировать наша самописная коллекция HashSet;

- [MySpaceList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/main/java/JunitCollectionsTasksOne/MySimpleList/MySpaceList/MySpaceList.java) - простой лист или коллекция ArrayList;
- [MySpaceLinkedList](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/main/java/JunitCollectionsTasksOne/MySimpleLinkedList/MySpaceLinkedList/MySpaceLinkedList.java) - простой двусвязный список, наша реализация LinkedList;
- [MySpaceHashSet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/main/java/JunitCollectionsTasksOne/MySimpleHashSet/MySpaceHashSet/MySpaceHashSet.java) - простая коллекция неповторяющихся элементов Set или HashSet;

Пример содержит тесты:
- [SpaceListTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/test/java/MyInterfaces/SpaceListTest.java) - набор тестов для проверки работоспособности методов коллекции MySpaceList;
- [SpaceLinkedListTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/test/java/MyInterfaces/SpaceLinkedListTest.java) - набор тестов для проверки работоспособности методов коллекции MySpaceLinkedList;
- [SpaceSetTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskOne/src/Junit_Less_1/test/java/MyInterfaces/SpaceSetTest.java) - набор тестов для проверки работоспособности методов коллекции MySpaceHashSet;


