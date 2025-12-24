package shukshin.reflection;
import shukshin.annotations.ToString;
import java.lang.reflect.Field;
/**
 * Обработчик аннотации @ToString
 * Формирует строковое представление объекта на основе аннотаций.
 */
public class ToStringReflection {
    /**
     * Включает только те поля, которые помечены как Mode.YES или не имеют аннотации.
     * @param object объект для обработки
     * @return строковое представление
     */
    public static String generateToString(Object object){
        StringBuilder result = new StringBuilder();
        Class<?> myClass = object.getClass();

        result.append(myClass.getSimpleName()).append("{");

        Field[] fields = myClass.getDeclaredFields();
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
