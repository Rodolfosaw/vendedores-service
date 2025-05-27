package com.casasbahia.vendedores.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    private String documento;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String tipoContratacao;

    @Column(nullable = false)
    private Long filialId;

    // getters e setters
}
