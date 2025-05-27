package com.casasbahia.vendedores.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DocumentoValidator implements ConstraintValidator<DocumentoValido, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        String doc = value.replaceAll("\\D", "");
        return isCpfValido(doc) || isCnpjValido(doc);
    }

    private boolean isCpfValido(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.chars().distinct().count() == 1) return false;
        try {
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                d1 += digito * (10 - i);
                d2 += digito * (11 - i);
            }
            d1 = 11 - (d1 % 11);
            if (d1 >= 10) d1 = 0;
            d2 += d1 * 2;
            d2 = 11 - (d2 % 11);
            if (d2 >= 10) d2 = 0;
            return d1 == Character.getNumericValue(cpf.charAt(9)) && d2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isCnpjValido(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || cnpj.chars().distinct().count() == 1) return false;
        try {
            int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int soma = 0, dig1, dig2;
            for (int i = 0; i < 12; i++)
                soma += Character.getNumericValue(cnpj.charAt(i)) * pesos1[i];
            dig1 = soma % 11;
            dig1 = dig1 < 2 ? 0 : 11 - dig1;
            soma = 0;
            for (int i = 0; i < 13; i++)
                soma += Character.getNumericValue(cnpj.charAt(i)) * pesos2[i];
            dig2 = soma % 11;
            dig2 = dig2 < 2 ? 0 : 11 - dig2;
            return dig1 == Character.getNumericValue(cnpj.charAt(12)) && dig2 == Character.getNumericValue(cnpj.charAt(13));
        } catch (Exception e) {
            return false;
        }
    }
}
