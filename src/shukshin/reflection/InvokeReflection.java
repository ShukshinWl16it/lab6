package shukshin.reflection;
import shukshin.annotations.Invoke;
import java.lang.reflect.Method;
/**
 * Вызывает все методы объекта, помеченные аннотацией @Invoke.
 * <p>
 * Метод использует Reflection API для поиска всех методов класса,
 * проверяет наличие аннотации @Invoke и вызывает найденные методы.
 * Для методов с параметрами используются значения по умолчанию.
 * </p>
 * @throws IllegalArgumentException если не найдено ни одного метода с аннотацией @Invoke
 */
public class InvokeReflection {
    public static void showInvoke(Object object) {
        Class<?> myClass = object.getClass();
        for (Method method : myClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Invoke.class)) {
                method.setAccessible(true);
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    System.out.println("Ошибка вызова метода: " + e.getMessage());
                }
            }
        }
    }
}
