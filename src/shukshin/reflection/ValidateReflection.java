package shukshin.reflection;
import shukshin.annotations.Validate;
import java.util.Arrays;
/**
 * Обработчик аннотации @Validate.
 * <p>
 * Извлекает и отображает типы, указанные для валидации в аннотации @Validate.
 * </p>
 */
public class ValidateReflection {
/**
 * Отображает типы для валидации из аннотации @Validate.
 * <p>
 * Метод получает аннотацию @Validate у класса объекта
 * и выводит список типов, которые должны быть проверены.
 * </p>
 *
 * @param object объект для анализа
 * @throws IllegalArgumentException если аннотация @Validate не найдена у класса
 */
    public static void showValidate(Object object) {
        Class<?> clazz = object.getClass();
        Validate annotation = clazz.getAnnotation(Validate.class);

        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Validate не найдена.");
        }

        Class<?>[] types = annotation.value();
        System.out.println("Типы для валидации: " + Arrays.toString(types));
    }
}
