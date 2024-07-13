package messenger.controller;

import jakarta.validation.Valid;
import messenger.dao.UserDAO;
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
    private UserDAO registeredUserDAO;

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
        else { registeredUserDAO.saveUser(user); }
        return "menu";
    }

    @PostMapping("/check")
    public String showMenuAfterAuthorization(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){ return "authorization";}
        if(registeredUserDAO.isExist(user)){ return "menu";}
        return "authorization";
    }

}
