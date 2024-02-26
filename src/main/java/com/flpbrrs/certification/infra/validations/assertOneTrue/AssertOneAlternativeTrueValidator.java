package com.flpbrrs.certification.infra.validations.assertOneTrue;

import com.flpbrrs.certification.domain.questions.dtos.AlternativeDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;

public class AssertOneAlternativeTrueValidator implements ConstraintValidator<AssertOneAlternativeTrue, Collection<?>> {

    @Override
    public boolean isValid(Collection<?> alternatives, ConstraintValidatorContext constraintValidatorContext) {
        if (alternatives == null) {
            return false;
        }

        for (Object alternative: alternatives) {
            if (alternative != null && ((AlternativeDTO) alternative).getIsCorrect()) {
                return true;
            }
        }

        return false;
    }
}
