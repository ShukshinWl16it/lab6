package shukshin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    /**
     * Перечисление возможных режимов отображения
     */
    enum Mode {
        /** Включить поле/тип в строковое представление */
        YES,
        /** Исключить поле/тип из строкового представления */
        NO
    }

    /**
     * Определяет, должно ли поле или тип включаться
     * в строковое представление
     *
     * @return режим отображения (по умолчанию YES)
     */
    Mode value() default Mode.YES;
}
