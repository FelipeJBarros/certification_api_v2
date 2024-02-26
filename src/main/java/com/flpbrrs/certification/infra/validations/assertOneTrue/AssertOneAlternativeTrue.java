package com.flpbrrs.certification.infra.validations.assertOneTrue;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {AssertOneAlternativeTrueValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface AssertOneAlternativeTrue{
    String message() default "At least one must be true";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
