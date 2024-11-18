package com.fatec.biblioteca.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

    @NotBlank(message = "A rua é obrigatória")
    String rua,

    @NotBlank(message = "O bairro é obrigatório")
    String bairro,

    @NotNull(message = "O número é obrigatório")
    Integer numero,

    String complemento,

    @NotNull(message = "O CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 'XXXXX-XXX'")
    String cep
) {}
