package MySimpleArrayList.MySpaceList;

import MyClasses.SpaceObject;
import MyInterfaces.SpaceList;

import java.util.Arrays;

public class MySpaceArrayList implements SpaceList {
    // Наш специализированный список содержит массив космических тел
    private SpaceObject[] array = new SpaceObject[10];
    // Начальный размер ноль
    private int size = 0;
    /*
    Метод проверяет введенный индекс, он не может
    быть меньше нуля или больше размера списка
    иначе вылетит исключение.
    */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    // Получаем элемент списка по индексу
    @Override
    public SpaceObject get(int index) {
        checkIndex(index);
        // Возвращаем элемент массива под индексом index
        return array[index];
    }
    // Метод возвращает текущий размер списка
    @Override
    public int size() {
        return size;
    }
    // Убираем дублирование кода в методах *.add()
    private void increaseArray() {
        /*
        Если текущий размер списка больше или равен длине массива,
        то запускаем статический метод класса Arrays:
        static <T> T[] copyOf(T[] original, int newLength) - копируем
        указанный массив, усекая или дополняя нулями (при необходимости),
        чтобы копия имела указанную длину. В нашем случае увеличиваем
        текущий размер массива в 2-а раза.
        */
        if (size >= array.length) {
            /*
            Данный метод заменяет следующий код:
            ---------------------------------------------------
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            ---------------------------------------------------
            */
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
    // Добавляем элемент в список
    @Override
    public boolean add(SpaceObject spaceObject) {
        // При необходимости увеличиваем список
        increaseArray();
        boolean successfulAddition = false;
        /*
        Если размер списка меньше длины массива вставляем элемент в список
        */
        array[size] = spaceObject;
        if (array[size] != null){
            successfulAddition = true;
        }
        /*
        И увеличиваем его размер на +1 (нужно помнить, что у списка
        (у объекта коллекция) есть емкость capacity, а есть длина
        length и это разные вещи)
        */
        size++;
        return successfulAddition;
    }

    @Override
    public boolean add(SpaceObject spaceObject, int index) {
        increaseArray();
        boolean successfulAddition = false;
        // Проверяем не ошиблись ли мы со значением index
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        /*
        Метод класса System, позволяет: static void arraycopy
        (Object src, int srcPos, Object dest, int destPos, int length) -
        копировать массив из указанного исходного массива 'src',
        начиная с указанной позиции 'srcPos', в указанную позицию
        целевого массива 'dest', т.е. мы указываем в какой массив
        хотим переместить элементы и на какую позицию 'destPos' и
        самое главное мы указываем сколько элементов нужно
        переместить 'length'.

        У нас массив источник является так же и массивом приемником,
        позиция с которой начинаем перемещать элементы полученный
        index, а т.к. мы текущий элемент смещаем вправо, то это
        позиция index + 1, ну и количество переносимых элементов,
        это наш размер списка минус значение индекса.

        В данном случае мы сдвигаем часть массива, вправо от
        вставляемого элемента.

        Данная строка заменяет код (двигаемся с конца):
        for(int i = size; i > index; i--){
            array[i] = array[i - 1];
        }
        */
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = spaceObject;
        if (array[index] != null){
            successfulAddition = true;
        }
        size++;
        return successfulAddition;
    }
    // Удаляем элемент коллекции по индексу
    @Override
    public boolean removeAt(int index) {
        // Проверяем, есть ли такой индекс
        checkIndex(index);
        // Перебираем список начиная с i-го элемента, и до size - 1
        for (int i = index; i < size - 1; i++) {
            /*
            Перемещаем на место текущего i - го элемента массива
            следующий за ним i + 1. Т.е. смещаем элементы массива
            влево. Если бы цикл работал от i до size, то мы вылетели
            бы за границы списка.
            */
            array[i] = array[i + 1];
        }
        // Уменьшаем размер списка на -1
        size--;
        // Возвращаем true
        return true;
    }

    // Удаляем элемент коллекции по содержимому
    @Override
    public boolean remove(SpaceObject spaceObject) {
        // Перебираем элементы списка в цикле, от 0 до размера size
        for (int i = 0; i < size; i++) {
            /*
            Если i-ый элемент списка совпал с переданным
            в аргументах объектом, удаляем его используя
            метод удаления по полученному индексу.
            */
            if (array[i].equals(spaceObject)) {
                /*
                Если тут все прошло нормально и элемент нашелся,
                то он будет удален, а текущий метод *.remove()
                вернет true, вслед за методом *.removeAt(). Если
                нет, то текущий метод вернет false.
                */
                return removeAt(i);
            }
        }
        return false;
    }
    // Метод полностью зачищает наш список, создав новый массив
    @Override
    public void clear() {
        array = new SpaceObject[16];
        size = 0;
    }

    @Override
    public boolean contains(SpaceObject spaceObject) {
        SpaceObject[] currentArray = this.array; // Обращаемся к текущему массиву
        SpaceObject elementForFind = spaceObject; // Выделяем искомый объект
        boolean contains = false; // Определяем возвращаемое состояние по умолчанию
          for (int i = 0; i < this.array.length; i++) {
                if (currentArray[i] != null) {
                   if (elementForFind.equals(currentArray[i])){
                            // Искомый элемент найден, ключ - true, поиск окончен, т.к. это Set.
                            contains = true;
                            if (contains){
                                break;
                            }
                   }
                }
          }
        return contains; // Возвращаем результат
    }

    public SpaceObject[] getArray() {
        SpaceObject[] arrayForView = new SpaceObject[size];
        for (int i = 0; i < size; i++){
            if(!array[i].equals(null)){
                arrayForView[i] = array[i];
            }
        }
        return arrayForView;
    }
}
