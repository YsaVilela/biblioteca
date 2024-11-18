package com.fatec.biblioteca.dto.livro;

import java.time.LocalDate;

import com.fatec.biblioteca.entity.Autor;
import com.fatec.biblioteca.entity.Livro;

public record DadosDetalhamentoLivro(
	    Long idLivro,
	    String nome,
	    String sinopse,
	    String versao,
	    LocalDate dataLancamento,
	    Autor autor,
	    String genero,
	    Integer indicacaoIdade
		) {
	
	public DadosDetalhamentoLivro (Livro livro) {
		this(livro.getId(),
				livro.getNome(),
				livro.getSinopse(),
				livro.getVersao(),
				livro.getDataLancamento(),
				livro.getAutor(),
				livro.getGenero(),
				livro.getIndicacaoIdade());
	}

}
