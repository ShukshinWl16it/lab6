package shukshin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для указания классов, которые должны быть проверены.
 * Может применяться к классам и другим аннотациям, доступна во время выполнения.
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    /**
     * Массив классов, которые должны быть проверены
     * Каждый класс представляет определенный тип валидации.
     *
     * @return массив классов для валидации
     */
    Class<?>[] value();
}
