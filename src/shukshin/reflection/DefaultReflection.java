package shukshin.reflection;
import shukshin.annotations.Default;
/**
 * Обработчик аннотации @Default.
 * Предоставляет методы для получения информации о типе по умолчанию.
 */
public class DefaultReflection {
    /**
     * Показывает тип по умолчанию из аннотации @Default.
     * Метод получает аннотацию @Default у класса объекта
     * и выводит информацию о типе по умолчанию.
     *
     * @param object объект для обработки
     * @throws IllegalArgumentException если аннотация @Default не найдена
     */
    public static void showDefault(Object object) {
        Class<?> myClass = object.getClass();
        Default annotation = myClass.getAnnotation(Default.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Default не найдена.");
        }
        Class<?> defaultType = annotation.value();
        System.out.println("Тип по умолчанию: " + defaultType.getName());
    }
}
