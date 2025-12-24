package shukshin.test;

import org.junit.Test;
import shukshin.classes.User;
import shukshin.classes.EmptyValidateUser;
import shukshin.annotations.Validate;
import shukshin.reflection.ValidateReflection;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Тестовый класс для проверки работы аннотации @Validate и соответствующего
 * обработчика ValidateReflection.
 * Содержит тесты для проверки корректности извлечения и обработки типов валидации,
 * а также обработки различных сценариев (пустой массив, отсутствие аннотации).
 *
 * Класс проверяет следующие аспекты:
 * <ul>
 *   <li>Корректное извлечение типов из аннотации @Validate</li>
 *   <li>Правильный формат вывода информации о типах валидации</li>
 *   <li>Обработку пустого массива типов валидации</li>
 *   <li>Обработку отсутствия аннотации @Validate</li>
 *   <li>Сообщения исключений в различных сценариях</li>
 * </ul>
 *
 * @see Validate
 * @see ValidateReflection
 * @see User
 * @see EmptyValidateUser
 */
public class testValidate {

    /**
     * Тест проверяет корректное извлечение типов из аннотации @Validate
     * и их вывод методом ValidateReflection#showValidate(Object).
     * Класс User имеет аннотацию {@code @Validate({String.class, Integer.class, Boolean.class})},
     * поэтому метод должен вывести все три типа.
     *
     * <p>Проверяемые условия:</p>
     * <ol>
     *   <li>Вывод содержит String.class</li>
     *   <li>Вывод содержит Integer.class</li>
     *   <li>Вывод содержит Boolean.class</li>
     *   <li>Вывод содержит заголовок "Типы для валидации:"</li>
     * </ol>
     *
     * Метод использует перенаправление System.out для проверки вывода в консоль.
     *
     * @throws AssertionError если вывод не содержит ожидаемые типы
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
     * выбрасывается исключение IllegalArgumentException.
     * Класс EmptyValidateUser имеет аннотацию {@code @Validate({})}
     * с пустым массивом типов.
     * Проверяемое условие:
     * <ol>
     *   <li>При вызове showValidate() с объектом EmptyValidateUser должно быть
     *       выброшено IllegalArgumentException</li>
     * </ol>
     *
     * Используется параметр {@code expected} аннотации {@code @Test}
     * для проверки типа исключения.
     *
     * @throws IllegalArgumentException ожидаемое исключение при пустом массиве валидации
     */
    @Test(expected = IllegalArgumentException.class)
    public void testShowValidateWithEmptyArrayThrowsException() {
        EmptyValidateUser user = new EmptyValidateUser("test");
        ValidateReflection.showValidate(user);
    }

    /**
     * Тест проверяет конкретное сообщение исключения при пустом массиве типов валидации.
     * Проверяемые условия:
     * <ol>
     *   <li>При пустом массиве типов выбрасывается IllegalArgumentException</li>
     *   <li>Сообщение исключения равно "Массив типов для валидации пустой."</li>
     * </ol>
     *
     * Этот тест проверяет не только тип исключения, но и его сообщение.
     *
     * @throws AssertionError если исключение не выбрасывается или имеет неверное сообщение
     */
    @Test
    public void testShowValidateEmptyArrayMessage() {
        try {
            EmptyValidateUser user = new EmptyValidateUser("test");
            ValidateReflection.showValidate(user);
            fail("Ожидалось исключение IllegalArgumentException для пустого массива");
        } catch (IllegalArgumentException e) {
            assertEquals("Массив типов для валидации пустой.", e.getMessage());
        }
    }

    /**
     * Тест проверяет, что при отсутствии аннотации @Validate у класса
     * выбрасывается исключение IllegalArgumentException.
     * Создается локальный класс без аннотации @Validate для проверки этого сценария.
     *Проверяемое условие:
     * <ol>
     *   <li>При вызове showValidate() с объектом без аннотации @Validate должно быть
     *       выброшено IllegalArgumentException</li>
     * </ol>
     *
     * Используется параметр {@code expected} аннотации {@code @Test}
     * для проверки типа исключения.
     *
     * @throws IllegalArgumentException ожидаемое исключение при отсутствии аннотации
     */
    @Test(expected = IllegalArgumentException.class)
    public void testShowValidateWithoutAnnotation() {
        // Создаем тестовый класс без аннотации @Validate
        class TestClassWithoutAnnotation {}
        TestClassWithoutAnnotation obj = new TestClassWithoutAnnotation();
        ValidateReflection.showValidate(obj);
    }
}
