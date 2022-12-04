package MySimpleLinkedList.MySpaceLinkedList;

import MyClasses.SpaceObject;
import MyInterfaces.SpaceList;

public class MySpaceLinkedList implements SpaceList {
    /*
    Первая нода списка, мы объявили ссылку,
    но пока она никуда не указывает, первую
    ноду еще предстоит создать.
    */
    private Node first;
    /*
    Последняя нода списка, мы объявили ссылку,
    но пока она никуда не указывает, последнюю
    ноду (как и первую) еще предстоит создать.
    */
    private Node last;
    private int size = 0; // Размер списка
    /*
    Метод извлекающий значение из связного списка по индексу
    */
    @Override
    public SpaceObject get(int index) {
        // Метод извлекающий объект из ноды по индексу
        return getNode(index).value;
    }
    // Добавляем элемент в конец списка
    @Override
    public boolean add(SpaceObject spaceObject) {
        // Если размер списка ноль
        if (size == 0) {
            // Первая нода ни на кого не ссылается, но уже содержит хранимый объект
            first = new Node(null, spaceObject, null);
            /*
            Последняя нода, она же и первая в ситуации когда в списке один элемент,
            в данном случае последняя нода ссылается на первую.
            */
            last = first; // Тут идут ссылки на объекты (ссылочные поля внутри них назначаются позже)
        } else {
            /*
            Если размер списка не ноль, то при помощи данного метода,
            мы можем добавить только в конец списка, а значит нам нужно
            переназначить ссылку, на бывший последний элемент, идущую от
            текущего последнего элемента, на предыдущий. А сам текущий
            последний элемент будет ссылаться на пустоту впереди и
            предыдущий последний элемент позади, пока сам не станет
            предпоследним и т.д...
            */
            Node prevLast = last; // И снова переназначаются ссылки на объекты
            /*
            Текущая ссылка last указывает на объект класса Node, который
            содержит ссылку на предыдущий элемент списка и ссылку в пустоту,
            как последний элемент списка.
            */
            last = new Node(prevLast, spaceObject, null);
            /*
            А теперь, заполняется ссылка у предыдущего элемента на последующий.
            Т.е. если у нас в списке один элемент то обе его ссылки указывают в
            никуда. При появлении второго элемента, добавленного в конец списка,
            у первого элемента появляется ссылка на последний элемент (только что
            добавленный).

            И вот только тут, ссылочное поле внутри объекта prevLast стало указывать
            на последний элемент. Т.е. если бы у нас было только два элемента в
            списке, именно тут у первого элемента Node появилась ссылка на второй
            элемент списка, как на последний (вместо null)...
            */
            prevLast.next = last;
        }
        // С каждым добавленным элементов увеличиваем размер списка
        size++;
        return true;
    }
    // Метод добавления элемента в список по индексу
    @Override
    public boolean add(SpaceObject spaceObject, int index) {
        // Проверяем не вышли ли за пределы списка
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        /*
        Если индекс равен размеру списка, то
        это фактически добавление в его конец
        */
        if (index == size) {
            /*
            Запускаем метод *.add() описанный выше,
            возвращаем то, что возвращает он.
            */
            return add(spaceObject);
        }
        /*
        Если же для переданного индекса есть соседи
        с обеих сторон, нам нужно переназначить ссылки
        previous и next в обоих нодах соседях, ну и во
        внедряемой ноде конечно.
        */
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, spaceObject, nodeNext);
        nodeNext.previous = newNode;
        /*
        Переназначаем ссылки в предыдущем элементе,
        на последующий, если же он находится в голове
        списка, и мы хотим поставить элемент на его
        место (т.е. его ссылка на предыдущий элемент
        идет в пустоту) мы добавляем вставленный элемент
        со сдвигом вправо.
        */
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }
    // Метод удаления элемента из списка по содержимому ячейки (ноды)
    @Override
    public boolean remove(SpaceObject spaceObject) {
        /*
        Наш лист упрощенный и перебор (поиск) элементов
        идет с головы списка, до тех пор пока не будет
        найдено совпадение с искомым элементом.
        */
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(spaceObject)) {
                /*
                Как только совпадение по-содержимому ноды
                найдено, мы фактически находим и индекс искомой
                ноды и запускаем метод удаления по индексу.
                */
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }
    // Удаление элемента списка по индексу
    @Override
    public boolean removeAt(int index) {
        // Находим ноду по индексу
        Node node = getNode(index);
        // Забираем из нее ссылки на предыдущий и последующий объект (ноду)
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        // Определяем не последнюю ли ноду му хотим удалить
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        // Определяем не первую ли ноду му хотим удалить
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }
    /*
    Двусвязный список штука интересная, т.к. удаление
    элементов из него происходит переназначением ссылок.
    Т.е. все как в жизни - пока о тебе кто-то еще помнит
    ты вроде бы даже есть, на тебя есть ссылка. Но как
    только о тебе все забыли - на тебя нет ссылок,
    приходит она - сборщик мусора...
    */
    @Override
    public void clear() {
        first = null; // Обнуляем ссылку на первую ноду списка
        last = null; // Обнуляем ссылку на последнюю ноду списка
        size = 0; // Обнуляем счетчик
        // Так вот в пустоту уходят целые цивилизации, кто-то обнуляет счетчики и ссылки
    }

    @Override
    public boolean contains(SpaceObject spaceObject) {
        return findElement(spaceObject) != -1;
    }

    private int findElement(SpaceObject spaceObject) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(spaceObject)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }
    // Извлекаем ноду из списка по индексу.
    private Node getNode(int index) {
        /*
        Нужно помнить, что у коллекций индексация идет с нуля.
        Если на вход метода поступает отрицательное число или
        число равное (а тем более больше) размера списка, то
        выбрасывается исключение 'выход индекса за границы'

        Естественно, если список пуст и мы хотим, например
        получить некий элемент, выбросится исключение.
        */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        /*
        И вот интересный момент. Как такового, значения index
        в качестве поля мы не объявляли ни у Node ни у
        MySpaceLinkedList. У нас есть только значение size,
        размер нашего связного списка. И вот от него мы и
        можем отталкиваться.

        Для того чтобы найти элемент в нашем списке, нам
        придется перебрать его от первого значения до
        искомого.

        В идеале, нам нужно пройти либо, от начала списка
        к искомому элементу, либо от конца, все зависит
        от того откуда ближе.

        Но у нас простая учебная реализация и мы идем от
        начала списка до элемента index, перебирая нашу
        связную цепочку в цикле.
        */
        Node node = first; // Присваиваем возвращаемой ноде значение первой
        for (int i = 0; i < index; i++) {
            /*
            и продолжаем процесс переприсваивания до тех
            пор, пока не дойдем до искомого элемента
            */
            node = node.next;
        }
        // Возвращаем ноду найденную по индексу.
        return node;
    }
    /*
    Метод превращает наш двусвязный список в массив,
    применяется в тестах и выводе на печать элементов
    коллекции.
    */
    public SpaceObject[] linkedListToArray() {
        SpaceObject[] arrayForView = new SpaceObject[size];
        for (int i = 0; i < size; i++){
             arrayForView[i] = get(i);
        }
        return arrayForView;
    }

    /*
    Особенностью линкед листа являются элементы - 'НОДЫ',
    которые имеют три параметра:
    - ссылка на последующую ноду;
    - ссылка на предыдущую ноду;
    - сам объект, который хранит текущая нода.
    Таким образом, как бы цепляясь друг за друга объекты
    класса 'нода' Node образуют связный список. Данный класс
    нужен только в пределах класса MySpaceLinkedList, для
    обеспечения его работы.

    Этот класс внутренний и приватный - ни кто другой, не
    должен иметь к нему доступ. Т.к. сам класс не обращается
    к методам внешнего класса и не использует переменные
    (поля) его экземпляров, то мы можем сделать его static.
    Фактически задача ноды хранить ссылки и данные.
    */
    private static class Node {
        /*
        Профессионалам проще, чем начинающим, т.к. у них в мозгу
        уже есть ссылка (выжженная словно в ПЗУ) на информацию о
        том, что синтаксическая конструкция, вида "Node previous"
        или "Node next" всего лишь ссылка в одной области памяти,
        на другую область памяти, где теоретически, должен лежать
        объект, созданный при помощи конструкции "new Node()", хотя
        его вполне может и не быть. Но планы по его созданию есть.
        */
        private Node previous; // Ссылка на предыдущую ноду
        private SpaceObject value; // Объект хранимый данной нодой
        private Node next; // Ссылка на следующую ноду

        public Node(Node previous, SpaceObject value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}