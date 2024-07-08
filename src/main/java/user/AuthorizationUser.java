package user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthorizationUser {
    @NotBlank(message = "Поле не должно быть пустым")
    private String login;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 8, max = 100, message = "Пароль не должен быть короче 8 символов")
    private String password;

    public AuthorizationUser(String login, String password){
        this.login = login;
        this.password = password;
    }
}
