import MyClasses.Asteroid;
import MyClasses.SpaceObject;
/*
Повторение мать всех учений.
Создаем объекты разными способами
и тестируем их эквивалентность.
*/
public class RepetitionOOPApp {
    public static void main(String[] args) {
        SpaceObject asteroid1 = new SpaceObject("астероид","Яффет",123.1);
        SpaceObject asteroid2 = new Asteroid("астероид","Яффет",123.1);
        Asteroid asteroid3 = new Asteroid("астероид","Яффет",123.1);
        System.out.println(asteroid1.equals(asteroid2));
        System.out.println(asteroid2.equals(asteroid3));
        System.out.println(asteroid3.equals(asteroid1));
    }
}
