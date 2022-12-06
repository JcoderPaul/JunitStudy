### *** Тестирование программ при помощи JUnit ***

В данном разделе приведены примеры простых реализаций 
коллекций ArrayList, HashSet, HashMap. Каждая коллекция
после написания покрывается тестами на базе Junit4.

(отрывок wiki-статьи)
Разработка через тестирование (англ. test-driven development, TDD) — 
техника разработки программного обеспечения, которая основывается 
на повторении очень коротких циклов разработки: 
- сначала пишется тест, покрывающий желаемое изменение; 
- затем пишется код, который позволит пройти тест;
- наконец проводится рефакторинг нового кода к соответствующим стандартам. 

Кент Бек, считающийся изобретателем этой техники, утверждал в 2003 году, 
что разработка через тестирование поощряет простой дизайн и внушает 
уверенность (англ. inspires confidence).

В 1999 году при своём появлении разработка через тестирование была тесно 
связана с концепцией «сначала тест» (англ. test-first), применяемой в 
экстремальном программировании, однако позже выделилась как независимая 
методология.

Тест — это процедура, которая позволяет либо подтвердить, либо опровергнуть 
работоспособность кода. Когда программист проверяет работоспособность 
разработанного им кода, он выполняет тестирование вручную.

Разработка через тестирование требует от разработчика создания автоматизированных 
модульных тестов, определяющих требования к коду непосредственно перед написанием 
самого кода. 

Тест содержит проверки условий, которые могут либо выполняться, либо нет. 
Когда они выполняются, говорят, что тест пройден. Прохождение теста подтверждает 
поведение, предполагаемое программистом. Разработчики часто пользуются 
библиотеками для тестирования (англ. testing frameworks) для создания и 
автоматизации запуска наборов тестов. Н

На практике модульные тесты покрывают критические и нетривиальные участки кода. 
Это может быть код, который подвержен частым изменениям, код, от работы которого 
зависит работоспособность большого количества другого кода, или код с большим 
количеством зависимостей.

### *** FRAMEWORK JUNIT ***

JUnit — библиотека для модульного тестирования программ Java. Созданный Кентом 
Беком и Эриком Гаммой, JUnit принадлежит семье фреймворков xUnit для разных 
языков программирования, берущей начало в SUnit Кента Бека для Smalltalk. 
JUnit породил экосистему расширений — JMock, EasyMock, DbUnit, HttpUnit и т. д.

Библиотека JUnit была портирована на другие языки, включая PHP (PHPUnit), C# 
(NUnit), Python (PyUnit), Fortran (fUnit), Delphi (DUnit), Free Pascal (FPCUnit), 
Perl (Test::Unit), C++ (CPPUnit), Flex (FlexUnit), JavaScript (JSUnit).

JUnit – это Java фреймворк для тестирования, т. е. тестирования отдельных участков 
кода, например, методов или классов. Опыт, полученный при работе с JUnit, важен в 
разработке концепций тестирования программного обеспечения.

JUnit позволяет в любой момент быстро убедиться в работоспособности кода. 
Если программа не является совсем простой и включает множество классов и методов, 
то для её проверки может потребоваться значительное время. Естественно, что 
данный процесс лучше автоматизировать. Использование JUnit позволяет проверить 
код программы без значительных усилий и не занимает много времени.

Юнит тесты классов и функций являются своего рода документацией к тому, что 
ожидается в результате их выполнения. И не просто документацией, а документацией 
которая может автоматически проверять код на соответствие предъявленным функциям.

### *** Виды тестирования ***

Тестирование программного обеспечение можно разделить на два вида:
- тестирование черного ящика;
- тестирование белого ящика.

Во время тестирования программы как черного ящика внутренняя структура 
приложения в расчет не принимается. Все, что имеет значение, это функциональность, 
которую приложение должно обеспечить. 

При тестировании программы, как белого ящика, во внимание принимается внутренняя 
структура, т.е. класс и методы. Кроме этого, тестирование можно разделить на четыре 
уровня:
- юнит тесты — тестирование отдельных участков кода;
- интеграционное тестирование — тестирование взаимодействия и совместной работы компонентов;
- системное тестирование — тестирование всей системы как целого;
- приемное тестирование — итоговое тестирование готовой системы на соответствие требованиям.

Юнит тестирование по определению является тестированием белого ящика.

Также см.
- [Документация по Junit5 (ENG)](https://junit.org/junit5/docs/current/user-guide/);
- [GitHub команды разработчиков Junit](https://github.com/junit-team/junit5/);

В данном разделе содержаться:
- [JunitWithCollectionTaskOne](https://github.com/JcoderPaul/JunitStudy/tree/master/JunitWithCollectionTaskOne) - простые реализации коллекций ArrayList, ArrayLinkedList и HashSet;
- [JunitWithCollectionTaskTwo](https://github.com/JcoderPaul/JunitStudy/tree/master/JunitWithCollectionTaskTwo) - чуть усложненная реализация тех же коллекций;
- [JunitWithCollectionTaskThree](https://github.com/JcoderPaul/JunitStudy/tree/master/JunitWithCollectionTaskThree) - те же коллекции, но уже реализующие Iterable;
- [JunitWithCollectionTaskFour](https://github.com/JcoderPaul/JunitStudy/tree/master/JunitWithCollectionTaskFour) - простая реализация коллекции HashMap;
