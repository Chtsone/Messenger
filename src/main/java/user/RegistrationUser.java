package user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RegistrationUser extends AuthorizationUser{

    @NotBlank
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")
    private String email;

    @Pattern(regexp = "(?: m | M|male | Male | f| female | Female | FEMALE | MALE ) $")
    private String sex;

    @Min(value = 1, message = "Возраст не может быть меньше 1" )
    @Max(value = 140, message = "Возраст не может быть больше 140")
    private int age;

    public RegistrationUser(String login, String password, String email, String sex, int age){
        super(login,password);
        this.email = email;
        this.age = age;
        this.sex =sex;
    }
}
