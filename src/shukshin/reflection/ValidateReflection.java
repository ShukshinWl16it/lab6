package shukshin.reflection;
import shukshin.annotations.Validate;
import java.util.Arrays;
/**
 * Обработчик аннотации @Validate.
 * Извлекает и отображает типы, указанные для валидации в аннотации.
 */
public class ValidateReflection {
/**
 * Отображает типы для валидации из аннотации @Validate.
 * Метод получает аннотацию @Validate у класса объекта
 * и выводит список типов, которые должны быть проверены.
 *
 * @param object объект для анализа
 * @throws IllegalArgumentException если аннотация @Validate не найдена у класса
 * @see Validate
 */
    public static void showValidate(Object object) {
        Class<?> myClass = object.getClass();
        Validate annotation = myClass.getAnnotation(Validate.class);

        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Validate не найдена.");
        }

        Class<?>[] types = annotation.value();
        if (types.length == 0) {
            throw new IllegalArgumentException("Массив типов для валидации пустой.");
        }

        System.out.println("Типы для валидации:");
        for (Class <?> current : types) {
            System.out.println(current.getSimpleName()+ ".class");
        }
    }
}
