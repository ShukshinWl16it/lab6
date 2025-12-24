package shukshin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация для указания двух значений: строкового и числового.
 * Применяется только к классам, доступна во время выполнения.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * Строковое значение, используемое для различных целей
     *
     * @return строковое значение
     */
    String first();

    /**
     * Числовое значение, используемое совместно со строковым.
     * Может представлять собой версию, количество или другой числовой параметр.
     *
     * @return числовое значение
     */
    int second();
}
