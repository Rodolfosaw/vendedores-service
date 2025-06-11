package com.mercantiservice.vendedores.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TipoContratacaoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TipoContratacaoValida {
    String message() default "Tipo de contratação inválido (deve ser CLT, OUTSOURCING ou PESSOA JURÍDICA)";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
