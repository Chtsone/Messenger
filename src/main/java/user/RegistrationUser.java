package user;

public class RegistrationUser extends AuthorizationUser{

    private String email;
    private String sex;
    private int age;

    public RegistrationUser(String login, String password, String email, String sex, int age){
        super(login,password);
        this.email = email;
        this.age = age;
        this.sex =sex;
    }
}
