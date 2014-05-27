package net.codeorbecoded.mytwitter.constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordMatchValidator.class)
@Documented
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface PasswordMatch {
	
	String message() default "Password and Password Confirmation do not match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    String passwordField();
    
    String passwordConfirmationField();

}
