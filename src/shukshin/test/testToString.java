package shukshin.test;

import org.junit.Test;
import static org.junit.Assert.*;
import shukshin.classes.Book;

public class testToString {
    @Test
    public void testToStringIncludesFieldsWithModeYES() {
        Book book = new Book("Мертвые души", "Гоголь", 11.15, 10);

        String result = book.toString();

        assertTrue("Поле price с аннотацией @ToString(Mode.YES) должно быть в строке", result.contains("11.15"));
        assertTrue("Название поля price должно быть в строке", result.contains("price="));
    }

    @Test
    public void testToStringExcludesFieldsWithModeNO() {
        Book book = new Book("Мертвые души", "Гоголь", 11.15, 10);

        String result = book.toString();

        assertFalse("Поле stock с аннотацией @ToString(Mode.NO) не должно быть в строке", result.contains("10"));
        assertFalse("Название поля stock не должно появляться в строке",result.contains("stock="));
    }
}
