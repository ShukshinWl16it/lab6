package shukshin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * Массив строк, представляющих кешируемые области
     *
     * @return массив названий кешируемых областей
     */
    String[] value() default {};
}