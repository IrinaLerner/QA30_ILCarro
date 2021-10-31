package models;

public class User {
    private String name;
    private String lastname;
    private String email;
    private String password;

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

