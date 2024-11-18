package com.fatec.biblioteca.dto.emprestimo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

public record DadosEmprestimo(

    @NotNull(message = "O ID da locação é obrigatório")
    Long idLocacao,

    @NotNull(message = "O ID do exemplar é obrigatório")
    Long idExemplar,  

    @NotNull(message = "O ID do leitor é obrigatório")
    Long idLeitor,  

    @NotNull(message = "A data de empréstimo é obrigatória")
    LocalDate dataEmprestimo,

    @NotNull(message = "A data prevista de devolução é obrigatória")
    LocalDate dataPrevistaDevolucao,

    LocalDate dataDevolucao, 

    @Pattern(regexp = "^(Ativo|Concluído|Atrasado)$", message = "O status deve ser um dos seguintes: 'Ativo', 'Concluído', ou 'Atrasado'")
    String status
) {}

