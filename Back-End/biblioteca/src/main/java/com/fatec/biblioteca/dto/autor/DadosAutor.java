package com.fatec.biblioteca.dto.autor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record DadosAutor(
    
    @NotNull(message = "O ID do autor é obrigatório")
    Long idAutor,
    
    @NotBlank(message = "Nome é obrigatório")
    String nome,
    
    @PastOrPresent(message = "A data de nascimento não pode ser no futuro")
    LocalDate dataNascimento,
    
    String nacionalidade
) {}
