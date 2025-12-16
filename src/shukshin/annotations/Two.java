package shukshin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * Строковое значение
     *
     * @return строковое значение
     */
    String first();

    /**
     * Числовое значение
     *
     * @return числовое значение
     */
    int second();
}
