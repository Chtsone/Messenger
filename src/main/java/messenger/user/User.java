package messenger.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import messenger.validation.CheckEmail;
import messenger.validation.CheckSex;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "login")
    @NotBlank(message = "Поле не должно быть пустым")
    private String login;

    @Column(name = "password")
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 8, max = 100, message = "Пароль не должен быть короче 8 символов")
    private String password;

    @NotBlank
    @Column(name = "email")
    @CheckEmail(value = "esp.ru", message = "Почта должна оканчиваться на esp.ru")
    private String email;

    @Column(name = "sex")
    @CheckSex
    private String sex;

    @Column(name = "age")
    @Min(value = 1, message = "Возраст не может быть меньше 1" )
    @Max(value = 140, message = "Возраст не может быть больше 140")
    private int age;

    public User(){}

    public User(String email, String sex, int age, String password, String login) {
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
