package shukshin.reflection;
import shukshin.annotations.Two;
/**
 * Обработчик аннотации @Two.
 * Показывает значения свойств first и second.
 */
public class TwoReflection {
    /**
     * Отображает значения свойств first и second из аннотации @Two.
     * Метод получает аннотацию @Two у класса объекта
     * и выводит значения строкового и числового свойств.
     *
     * @param object объект для обработки
     * @throws IllegalArgumentException если аннотация не найдена
     */
    public static void showTwo(Object object) {
        Class<?> myClass = object.getClass();
        Two annotation = myClass.getAnnotation(Two.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Two не найдена.");
        }
        System.out.println("first:" + annotation.first() + " ");
        System.out.println();
        System.out.println("second: " + annotation.second());
    }
}
