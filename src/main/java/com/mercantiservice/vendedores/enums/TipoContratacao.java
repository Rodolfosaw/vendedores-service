package com.mercantiservice.vendedores.enums;

public enum TipoContratacao {
    OUTSOURCING, CLT, PESSOA_JURIDICA;

    public static boolean isValid(String value) {
        if (value == null) return false;
        return value.equalsIgnoreCase("OUTSOURCING") ||
                value.equalsIgnoreCase("CLT") ||
                value.equalsIgnoreCase("PESSOA JURÍDICA") ||
                value.equalsIgnoreCase("PESSOA_JURIDICA");
    }
}
