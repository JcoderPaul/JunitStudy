Продолжаем изучать фреймворк Junit4, при помощи 
самописных коллекций, аналогов уже готовых в Java. 

На этот раз мы изучаем коллекцию Queue - очередь, 
ее упрощенную реализацию, расточенную из нашего 
LinkedList - а. Мы добавили методы *.peek(), 
*.poll() и *.element(). И естественно протестируем 
реализованные методы при помощи Junit тестов.

И так, как всегда:
- Шаг 0 - пишем тесты под будущие реализации методов коллекций;
- Шаг 1 - пишем собственные реализации коллекций;
- Шаг 2 - тестируем написанный код при помощи Junit 4;

Пример содержит классы:
- [SpaceObject](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFive/src/Junit_Less_5/main/java/MyClasses/SpaceObject.java) - класс для создания объектов 'Космическое тело'; 
- [Asteroid](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFive/src/Junit_Less_5/main/java/MyClasses/Asteroid.java) - наследник класса SpaceObject, не имеет особых полей;
- [Planet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFive/src/Junit_Less_5/main/java/MyClasses/Planet.java) - наследник класса SpaceObject, имеет поле 'количество спутников';
- [Star](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFive/src/Junit_Less_5/main/java/MyClasses/Star.java) - наследник класса SpaceObject, имеет поле 'спектральный класс';

Пример содержит интерфейсы:
- [SpaceObjectQueue](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFive/src/Junit_Less_5/main/java/MyInterfaces/SpaceObjectQueue.java) - интерфейс описывает возможности нашей будущей очереди;
- [SpaceObjectCollection](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFive/src/Junit_Less_5/main/java/MyInterfaces/SpaceObjectCollection.java) - наш супер-интерфейс от которого наследуются все остальные коллекции; 

Пример содержит классы реализующие идею коллекций:
- [MySpaceObjectQueue](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFive/src/Junit_Less_5/main/java/MySimpleLinkedList/MySpaceQueue/MySpaceObjectQueue.java) - простая коллекция, класс подписанный на интерфейс SpaceObjectQueue и реализующий его методы;  

Пример содержит тесты:
- [SpaceObjectCollectionTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFive/src/Junit_Less_5/test/java/MyInterfaces/SpaceObjectCollectionTest.java) - тестовый класс для проверки работоспособности методов класса MySpaceObjectQueue; 


