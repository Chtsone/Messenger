package messenger.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail,String> {
    private String endsOfEmail;

    @Override
    public void initialize(CheckEmail constraintAnnotation) {
        endsOfEmail = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.endsWith(endsOfEmail);
    }
}
