package com.sulimann.dimensa.utils.validators.cpforcnpj;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfOrCnpjValidator implements ConstraintValidator<CpfOrCnpj, String>{

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext context) {
        if(!StringUtils.hasText(documento)){
            return false;
        }
        return isCpfValido(documento) || isCnpjValido(documento);
    }

    private boolean isCpfValido(String documento) {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);
        return cpfValidator.isValid(documento, null);
    }

    private boolean isCnpjValido(String documento) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);
        return cnpjValidator.isValid(documento, null);
    }

}
