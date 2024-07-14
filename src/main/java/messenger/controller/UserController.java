package messenger.controller;

import jakarta.validation.Valid;
import messenger.service.UserService;
import messenger.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
     public String showAuthorizationPage(Model model){
        model.addAttribute("user",new User());
        return "authorization";
    }

    @GetMapping("/registration")
    public String showRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/menu")
    public String showMenuAfterRegistration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){ return "registration"; }
        else { userService.saveUser(user); }
        return "menu";
    }

    @PostMapping("/check")
    public String showMenuAfterAuthorization(@ModelAttribute("user") User user){
        if( userService.isExist(user)){ return "menu";}
        return "authorization";
    }

}

/*
    1. Написать нормальную валидацию для email
    2. Написать нормальную валидацию для sex
    3. Залить коммит с обновами + валидацией + рабочим registration, authorization
    4. Написать в OneNote почему я использовал service p.s чтобы в контроллере было только одно поле service, а не N - ое количество DAO
 */
