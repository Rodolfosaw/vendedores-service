package com.casasbahia.vendedores.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class VendedorDTO {

    private Long id;

    private String matricula;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @PastOrPresent(message = "Data de nascimento não pode ser futura")
    private LocalDate dataNascimento;

    @NotBlank(message = "Documento (CPF ou CNPJ) é obrigatório")
    private String documento;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "Tipo de contratação é obrigatório")
    private String tipoContratacao;

    @NotNull(message = "Filial é obrigatória")
    private Long filialId;

    // --- GETTERS and SETTERS ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTipoContratacao() { return tipoContratacao; }
    public void setTipoContratacao(String tipoContratacao) { this.tipoContratacao = tipoContratacao; }

    public Long getFilialId() { return filialId; }
    public void setFilialId(Long filialId) { this.filialId = filialId; }
}
