package shukshin.reflection;
import shukshin.annotations.Invoke;
import java.lang.reflect.Method;
/**
 * Вызывает все методы объекта, помеченные аннотацией @Invoke.
 * Метод использует Reflection API для поиска всех методов класса,
 * проверяет наличие аннотации @Invoke и вызывает найденные методы.
 * Для методов с параметрами используются значения по умолчанию.
 */
public class InvokeReflection {
    /**
     * Если метод вызывает исключение, оно перехватывается и выводится сообщение об ошибке.
     *
     * @param object объект, методы которого нужно вызвать
     * @throws IllegalArgumentException если не найдено ни одного метода с аннотацией @Invoke
     * @see Invoke
     */
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
