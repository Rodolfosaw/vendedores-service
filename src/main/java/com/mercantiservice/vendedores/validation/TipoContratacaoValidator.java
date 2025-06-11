package com.mercantiservice.vendedores.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.mercantiservice.vendedores.enums.TipoContratacao;

public class TipoContratacaoValidator implements ConstraintValidator<TipoContratacaoValida, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return TipoContratacao.isValid(value);
    }
}
