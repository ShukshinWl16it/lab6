package shukshin.classes;

import shukshin.annotations.Validate;
import shukshin.annotations.Cache;
import shukshin.annotations.ToString;
/**
 * Класс пользователя системы.
 * Демонстрирует использование нескольких аннотаций одновременно:
 * @Validate, @Cache и @ToString
 *
 * @see Validate
 * @see Cache
 * @see ToString
 */
@Validate({String.class, Integer.class, Boolean.class})
@Cache({"users", "profiles", "auth"})
@ToString
public class User {
    /** Имя пользователя */
    private String username;

    /** Email пользователя */
    private String email;

    /** Хэш пароля пользователя, исключается из строкового представления */
    @ToString(ToString.Mode.NO)
    private String passwordHash;

    /** Возраст пользователя */
    private int age;

    /** Статус активности пользователя */
    private boolean isActive;

    /**
     * Создает пользователя со значениями по умолчанию.
     * Используется для тестирования и демонстрационных целей.
     */
    public User() {
        this("user1", "user@yandex.ru", "hash123", 25, true);
    }

    /**
     * Создает пользователя с указанными параметрами.
     *
     * @param username имя пользователя
     * @param email email пользователя
     * @param passwordHash хэш пароля пользователя
     * @param age возраст пользователя
     * @param isActive статус активности пользователя
     */
    public User(String username, String email, String passwordHash, int age, boolean isActive) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.age = age;
        this.isActive = isActive;
    }
}
