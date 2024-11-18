package com.fatec.biblioteca.dto.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record DadosLivro(
    @NotBlank(message = "O nome do livro é obrigatório")
    String nome,

    @Size(max = 1000, message = "A sinopse não pode ter mais de 1000 caracteres")
    String sinopse,

    String versao,

    @NotNull(message = "A data de lançamento é obrigatória")
    LocalDate dataLancamento,

    @NotNull(message = "O ID do autor é obrigatório")
    Long idAutor,

    String genero,

    Integer indicacaoIdade
) {}
