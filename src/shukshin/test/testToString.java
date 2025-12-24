package shukshin.test;

import org.junit.Test;
import static org.junit.Assert.*;
import shukshin.classes.Book;
/**
 * Тестовый класс для проверки работы аннотации @shukshin.annotations.ToString
 * Содержит тесты для проверки корректности формирования строкового представления
 * объектов класса @Book в соответствии с аннотациями @ToString
 *
 * <p>Класс проверяет следующие аспекты:</p>
 * <ul>
 *   <li>Включение полей, помеченных как {@code @ToString(ToString.Mode.YES)}</li>
 *   <li>Исключение полей, помеченных как {@code @ToString(ToString.Mode.NO)}</li>
 *   <li>Корректность форматирования строкового представления</li>
 * </ul>
 *
 * @see Book
 * @see shukshin.annotations.ToString
 */
public class testToString {
    /**
     * Тест проверяет, что поля, помеченные аннотацией {@code @ToString(ToString.Mode.YES)},
     * включаются в строковое представление объекта.
     *
     * В классе {@link Book} поле {@code price} помечено как {@code @ToString(ToString.Mode.YES)},
     * поэтому оно должно присутствовать в результате метода {@code toString()}.
     *
     * <p>Проверяемые условия:</p>
     * <ol>
     *   <li>Значение поля price (11.15) присутствует в строке</li>
     *   <li>Название поля "price=" присутствует в строке</li>
     * </ol>
     *
     * @throws AssertionError если поле price не включено в строковое представление
     */
    @Test
    public void testToStringIncludesFieldsWithModeYES() {
        Book book = new Book("Мертвые души", "Гоголь", 11.15, 10);

        String result = book.toString();

        assertTrue("Поле price с аннотацией @ToString(Mode.YES) должно быть в строке", result.contains("11.15"));
        assertTrue("Название поля price должно быть в строке", result.contains("price="));
    }

    /**
     * Тест проверяет, что поля, помеченные аннотацией {@code @ToString(ToString.Mode.NO)},
     * исключаются из строкового представления объекта.
     *
     * В классе {@link Book} поле {@code stock} помечено как {@code @ToString(ToString.Mode.NO)},
     * поэтому оно не должно присутствовать в результате метода {@code toString()}.
     *
     * <p>Проверяемые условия:</p>
     * <ol>
     *   <li>Значение поля stock (10) отсутствует в строке</li>
     *   <li>Название поля "stock=" отсутствует в строке</li>
     * </ol>
     *
     * @throws AssertionError если поле stock включено в строковое представление
     */
    @Test
    public void testToStringExcludesFieldsWithModeNO() {
        Book book = new Book("Мертвые души", "Гоголь", 11.15, 10);

        String result = book.toString();

        assertFalse("Поле stock с аннотацией @ToString(Mode.NO) не должно быть в строке", result.contains("10"));
        assertFalse("Название поля stock не должно появляться в строке",result.contains("stock="));
    }
}
