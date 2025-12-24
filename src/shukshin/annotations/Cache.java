package shukshin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания кешируемых областей для класса.
 * Применяется только к типам (классам) и доступна во время выполнения.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * Массив строк, представляющих названия кешируемых областей.
     * Каждая строка определяет отдельную область кеширования.
     * Если массив пустой, используется конфигурация по умолчанию.
     *
     * @return массив названий кешируемых областей
     */
    String[] value() default {};
}