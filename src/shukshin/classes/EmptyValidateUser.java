package shukshin.classes;

import shukshin.annotations.Validate;
/**
 * Класс пользователя с пустым массивом валидации.
 * Демонстрирует использование аннотации @Validate с пустым массивом классов.
 */
@Validate({})
public class EmptyValidateUser {
    /** Имя пользователя */
    private String username;

    /**
     * Создает пользователя с указанным именем.
     *
     * @param username имя пользователя
     */
    public EmptyValidateUser(String username) {
        this.username = username;
    }
}