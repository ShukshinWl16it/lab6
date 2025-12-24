package shukshin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания типа по умолчанию для класса или поля.
 * Может применяться к классам и полям, доступна во время выполнения.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    /**
     * Класс, представляющий тип по умолчанию
     * Используется для определения типа при отсутствии явного указания.
     *
     * @return класс типа по умолчанию
     */
    Class<?> value();
}
