package com.fatec.biblioteca.dto.exemplar;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosExemplar(

    @NotNull(message = "O ID do exemplar é obrigatório")
    Long idExemplar,

    @NotNull(message = "O ID do livro é obrigatório")
    Long idLivro,  
    
    @NotNull(message = "O estado de conservação é obrigatório")
    Integer estadoConservacao,

    @Pattern(regexp = "^(Disponível|Indisponível|Em manutenção)$", message = "O status deve ser um dos seguintes: 'Disponível', 'Indisponível' ou 'Em manutenção'")
    String status
) {}
