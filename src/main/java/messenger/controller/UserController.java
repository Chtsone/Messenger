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

    private String getModelAndView(Model model,String viewName)
        {
            model.addAttribute("user",new User());
            return viewName;
        }
    @GetMapping("/")
     public String showAuthorizationPage(Model model){
        return getModelAndView(model, "authorization");
    }

    @GetMapping("/registration")
    public String showRegistrationPage(Model model){
        return getModelAndView(model, "registration");
    }

    @PostMapping("/menu")
    public String showMenuAfterRegistration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){ return "registration"; }
        else {
            if(!userService.loginIsExist(user)){userService.saveUser(user);return "menu";}
            else {return "registration";}
        }

    }

    @PostMapping("/check")
    public String showMenuAfterAuthorization(@ModelAttribute("user") User user){
        if(userService.loginIsExist(user) && userService.passwordIsExist(user)){ return "menu";}
        return "authorization";
    }

}

/*
    1. Написать нормальную валидацию для email
    2. Написать нормальную валидацию для sex
    3. Залить коммит с обновами + валидацией + рабочим registration, authorization
    4. Написать в OneNote почему я использовал service p.s чтобы в контроллере было только одно поле service, а не N - ое количество DAO
 */
