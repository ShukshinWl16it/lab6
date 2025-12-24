package shukshin.classes;

import shukshin.annotations.Validate;

// Класс с пустым массивом в аннотации @Validate
@Validate({})
public class EmptyValidateUser {
    private String username;

    public EmptyValidateUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}