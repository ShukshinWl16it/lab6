package shukshin.reflection;
import shukshin.annotations.Cache;
import java.util.Arrays;

public class CacheReflection {
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
