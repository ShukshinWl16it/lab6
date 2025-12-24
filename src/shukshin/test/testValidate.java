package shukshin.test;

import org.junit.Test;
import shukshin.classes.User;
import shukshin.classes.EmptyValidateUser;
import shukshin.annotations.Validate;
import shukshin.reflection.ValidateReflection;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class testValidate {

    /**
     * Тест проверяет корректное извлечение типов из аннотации @Validate
     * и их вывод методом showValidate
     */
    @Test
    public void testShowValidateWithCorrectTypes() {
        // Перенаправляем System.out для проверки вывода
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            User user = new User("Vova","vovash@yandex.ru","123456789",19,true);
            ValidateReflection.showValidate(user);

            String output = outputStream.toString();

            // Проверяем, что вывод содержит ожидаемые типы
            assertTrue("Вывод должен содержать String.class", output.contains("String.class"));
            assertTrue("Вывод должен содержать Integer.class", output.contains("Integer.class"));
            assertTrue("Вывод должен содержать Boolean.class", output.contains("Boolean.class"));
            assertTrue("Вывод должен содержать 'Типы для валидации:'", output.contains("Типы для валидации:"));

        } finally {
            // Возвращаем System.out обратно
            System.setOut(originalOut);
        }
    }

    /**
     * Тест проверяет, что при пустом массиве в аннотации @Validate
     * выбрасывается исключение IllegalArgumentException
     * Используем параметр expected
     */
    @Test(expected = IllegalArgumentException.class)
    public void testShowValidateWithEmptyArrayThrowsException() {
        EmptyValidateUser user = new EmptyValidateUser("test");
        ValidateReflection.showValidate(user);
    }

    /**
     * Тест проверяет сообщение исключения при пустом массиве
     */
    @Test
    public void testShowValidateEmptyArrayExceptionMessage() {
        try {
            EmptyValidateUser user = new EmptyValidateUser("test");
            ValidateReflection.showValidate(user);
            fail("Ожидалось исключение IllegalArgumentException для пустого массива");
        } catch (IllegalArgumentException e) {
            assertEquals("Массив типов для валидации пустой.", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShowValidateWithoutAnnotation() {
        // Создаем тестовый класс без аннотации @Validate
        class TestClassWithoutAnnotation {}
        TestClassWithoutAnnotation obj = new TestClassWithoutAnnotation();
        ValidateReflection.showValidate(obj);
    }
}
