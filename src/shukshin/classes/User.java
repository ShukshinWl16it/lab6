package shukshin.classes;

import shukshin.annotations.Validate;
import shukshin.annotations.Cache;
import shukshin.annotations.ToString;
@Validate({String.class, Integer.class, Boolean.class})
@Cache({"users", "profiles", "auth"})
@ToString
public class User {
    private String username;
    private String email;

    @ToString(ToString.Mode.NO)
    private String passwordHash;

    private int age;
    private boolean isActive;
    public User() {
        this("user1", "user@yandex.ru", "hash123", 25, true);
    }

    public User(String username, String email, String passwordHash, int age, boolean isActive) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.age = age;
        this.isActive = isActive;
    }
}
