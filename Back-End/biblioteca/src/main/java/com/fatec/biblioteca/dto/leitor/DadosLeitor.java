package com.fatec.biblioteca.dto.leitor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

import com.fatec.biblioteca.dto.endereco.DadosEndereco;

public record DadosLeitor(
    @NotBlank(message = "O nome é obrigatório")
    String nome,

    @Email(message = "O e-mail deve ser válido")
    @NotBlank(message = "O e-mail é obrigatório")
    String email,

    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve ter 10 ou 11 dígitos")
    String telefone,

    @Valid
    @NotNull(message = "O endereço é obrigatório")
    DadosEndereco endereco, 

    @NotNull(message = "A data de nascimento é obrigatória")
    LocalDate dataNascimento
) {}

