package com.casasbahia.vendedores.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class VendedorDTO {

    @NotBlank
    @Pattern(
            regexp = "\\d+-(OUT|CLT|PJ)",
            message = "Matrícula inválida (deve terminar em -OUT, -CLT ou -PJ)"
    )
    private String matricula;

    @NotBlank
    private String nome;

    @PastOrPresent(message = "Data de nascimento não pode ser futura")
    private LocalDate dataNascimento;

    @NotBlank
    @Pattern(
            regexp = "\\d{11}|\\d{14}",
            message = "Documento deve ser CPF (11 dígitos) ou CNPJ (14 dígitos)"
    )
    private String documento;

    @NotBlank
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank
    @Pattern(
            regexp = "Outsourcing|CLT|Pessoa Jurídica",
            message = "Tipo de contratação deve ser Outsourcing, CLT ou Pessoa Jurídica"
    )
    private String tipoContratacao;

    @NotNull
    private Long filialId;

    // --- Getters e Setters ---

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(String tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Long getFilialId() {
        return filialId;
    }

    public void setFilialId(Long filialId) {
        this.filialId = filialId;
    }
}
