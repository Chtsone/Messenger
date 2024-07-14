package messenger.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CheckSexValidator implements ConstraintValidator<CheckSex,String> {
    private String[] acceptableValues;

    @Override
    public void initialize(CheckSex constraintAnnotation) {
        this.acceptableValues = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(acceptableValues).anyMatch(el -> el.equals(s));
    }
}
