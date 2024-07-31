package messenger.exeption_handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice
{
    @ExceptionHandler
    public String handleException(Exception exception,Model model)
    {
        model.addAttribute("exception",exception.getMessage());
        return "exception";
    }
}
