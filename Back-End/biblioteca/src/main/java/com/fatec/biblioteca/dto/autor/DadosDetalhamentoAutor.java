package com.fatec.biblioteca.dto.autor;

import java.time.LocalDate;

import com.fatec.biblioteca.entity.Autor;

public record DadosDetalhamentoAutor(
		Long id,
		String nome,
		LocalDate dataNascimento,
		String nacionalidade) {
	
	public DadosDetalhamentoAutor (Autor autor) {
		this(autor.getId(),
				autor.getNome(),
				autor.getDataNascimento(),
				autor.getNacionalidade());
	}

}
