Продолжаем изучать фреймворк Junit4, при помощи 
самописных коллекций, аналогов уже готовых в Java. 

На этот раз мы изучаем коллекцию Map и ее упрощенную
реализацию, а также протестируем реализованные методы
при помощи Junit тестов.

И так, как всегда:
- Шаг 0 - пишем тесты под будущие реализации методов коллекций;
- Шаг 1 - пишем собственные реализации коллекций;
- Шаг 2 - тестируем написанный код при помощи Junit 4;

Пример содержит классы:
- [SpaceObject](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFour/src/Junit_Less_4/main/java/MyClasses/SpaceObject/SpaceObject.java) - класс для создания объектов 'Космическое тело', которые 
мы будем добавлять в коллекции. Объекты данного класса и его 
наследники станут 'value' вторым объектом в паре <key, value> 
хранящихся в коллекции Map; 
- [Asteroid](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFour/src/Junit_Less_4/main/java/MyClasses/SpaceObject/Asteroid.java) - наследник класса SpaceObject, не имеет особых полей;
- [Planet](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFour/src/Junit_Less_4/main/java/MyClasses/SpaceObject/Planet.java) - наследник класса SpaceObject, имеет поле 'количество спутников';
- [Star](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFour/src/Junit_Less_4/main/java/MyClasses/SpaceObject/Star.java) - наследник класса SpaceObject, имеет поле 'спектральный класс';

- [Discoverer](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFour/src/Junit_Less_4/main/java/MyClasses/Discoverer.java) - класс 'первооткрыватель' для нашей коллекции Map, объекты 
этого класса будут ключами key. Поля данного класса помечены 
как private final, что в определенной степени застрахует нас 
от потери данных при попытке изменить значения полей из которых 
рассчитывается HashCode. Поскольку смена даже одного поля приведет 
к смене HashCode, а следовательно неверному расчету местоположения 
в хэш таблице и всех дальнейших проблем с поиском хранимых данных.

Пример содержит интерфейсы:
- [SpaceObjectMap](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFour/src/Junit_Less_4/main/java/MyInterfaces/SpaceObjectMap.java) - интерфейс описывает возможности нашей будущей коллекции Map;

Пример содержит классы реализующие идею коллекций:
- [SpaceObjectHashMap](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFour/src/Junit_Less_4/main/java/MyCollectionMap/SpaceObjectHashMap.java) - простая коллекция имплементирующая 
интерфейс SpaceObjectMap и реализующая его методы, аналог 
HashMap существующий в готовой библиотеке Java;

Пример содержит тесты:
- [SpaceObjectHashMapTest](https://github.com/JcoderPaul/JunitStudy/blob/master/JunitWithCollectionTaskFour/src/Junit_Less_4/test/java/MyCollectionMap/SpaceObjectHashMapTest.java) - тестирование методов интерфейса SpaceObjectMap.


