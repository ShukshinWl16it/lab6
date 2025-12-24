package shukshin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для пометки методов, которые должны быть автоматически вызваны.
 * Применяется только к методам и доступна во время выполнения.
 * Не имеет параметров - используется как маркер.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
    // Аннотация не имеет свойств
}
