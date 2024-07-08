package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

//    @GetMapping("/")
//    public String showMainPage(){
//        return "login";
//    }

    @GetMapping("/")
     public String showAuthorizationPage(){
        return "authorization";
    }

    @GetMapping("/registration")
    public String showRegistrationPage(){
        return "registration";
    }

    @PostMapping("/menu")
    public String showMenuPage(){
        return "menu";
    }

}