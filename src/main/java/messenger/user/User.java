package messenger.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "login")
    @NotBlank(message = "Поле не должно быть пустым")
    private String login;

    @Column(name = "password")
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 8, max = 100, message = "Пароль не должен быть короче 8 символов")
    private String password;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "email")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$"
    , message = "enter data like this xx@xx.xx")
    private String email;

    @Column(name = "sex")
    @Pattern(regexp = "(?: m | M|male | Male | f| female | Female | FEMALE | MALE ) $")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
