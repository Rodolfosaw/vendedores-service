package com.casasbahia.vendedores.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class VendedorDTO {

    private Long id;

    @NotBlank
    private String nome;

    private LocalDate dataNascimento;

    @NotBlank
    private String documento;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private String tipoContratacao;

    @NotNull
    private Long filialId;

    // getters e setters
}
