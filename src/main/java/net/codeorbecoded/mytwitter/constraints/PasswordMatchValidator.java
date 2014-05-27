package net.codeorbecoded.mytwitter.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {
	
	private String firstField;
	private String secondField;

	@Override
	public void initialize(PasswordMatch constraintAnnotation) {
		firstField = constraintAnnotation.passwordField();
		secondField = constraintAnnotation.passwordConfirmationField();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		try {
            Object pw = BeanUtils.getProperty(obj, firstField);
            Object rpw = BeanUtils.getProperty(obj, secondField);
 
            return pw != null && rpw != null && pw.equals(rpw);
        } catch (Exception ex) {
            return false;
        }
	}

}
