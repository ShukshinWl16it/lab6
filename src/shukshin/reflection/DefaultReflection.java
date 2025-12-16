package shukshin.reflection;
import shukshin.annotations.Default;
/**
 * Обработчик аннотации @Default.
 * Показывает тип по умолчанию.
 */
public class DefaultReflection {
    /**
     * Показывает тип по умолчанию из аннотации @Default.
     * <p>
     * Метод получает аннотацию @Default у класса объекта
     * и выводит информацию о типе по умолчанию.
     * </p>
     *
     * @param object объект для обработки
     * @throws IllegalArgumentException если аннотация не найдена
     */
    public static void showDefault(Object object) {
        Class<?> clazz = object.getClass();
        Default annotation = clazz.getAnnotation(Default.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Default не найдена.");
        }
        Class<?> defaultType = annotation.value();
        System.out.println("Тип по умолчанию: " + defaultType.getName());
    }
}
