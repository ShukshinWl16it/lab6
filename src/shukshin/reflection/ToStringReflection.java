package shukshin.reflection;
import shukshin.annotations.ToString;
import java.lang.reflect.Field;

public class ToStringReflection {
    /**
     * Обработчик аннотации @ToString.
     * Формирует строковое представление объекта.
     */
    /**
     * Создает строковое представление объекта на основе аннотаций @ToString.
     *
     * @param object объект для обработки
     * @return строковое представление
     */
    public static String generateToString(Object object){
        StringBuilder result = new StringBuilder();
        Class<?> clazz = object.getClass();

        result.append(clazz.getSimpleName()).append("{");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            boolean include = true;
            if (field.isAnnotationPresent(ToString.class)) {
                include = field.getAnnotation(ToString.class).value() == ToString.Mode.YES;
            }

            if (include) {
                try {
                    if (i > 0) result.append(", ");
                    result.append(field.getName()).append("=").append(field.get(object));
                } catch (Exception e) {
                    result.append(field.getName()).append("=error");
                }
            }
        }

        result.append("}");
        return result.toString();
    }
}
