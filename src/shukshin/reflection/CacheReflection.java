package shukshin.reflection;
import shukshin.annotations.Cache;
import java.util.Arrays;
/**
 * Утилитный класс для работы с аннотацией @Cache через Reflection API.
 * Предоставляет методы для извлечения информации о кешируемых областях.
 */
public class CacheReflection {
    /**
     * Показывает список кешируемых областей, указанных в аннотации @Cache,
     * расположенной над классом переданного объекта.
     * Выводит результат в консоль.
     *
     * @param object Объект, класс которого должен быть проверен на наличие аннотации @Cache
     * @throws IllegalArgumentException если аннотация @Cache не найдена у класса объекта
     * @see Cache
     */
    public static void showCache(Object object) {
        Class <?> myClass = object.getClass();
        Cache annotation = myClass.getAnnotation(Cache.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Аннотация @Cache не найдена.");
        }
        String[] areas = annotation.value();
        if (areas.length == 0) {
            System.out.println("Список кэшируемых областей пуст.");
        } else {
            System.out.println("Кэшируемые области: " + Arrays.toString(areas));
        }
    }
}
