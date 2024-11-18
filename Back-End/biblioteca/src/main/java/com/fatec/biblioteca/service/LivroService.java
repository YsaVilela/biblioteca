package com.fatec.biblioteca.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatec.biblioteca.dto.livro.DadosDetalhamentoLivro;
import com.fatec.biblioteca.dto.livro.DadosLivro;
import com.fatec.biblioteca.entity.Autor;
import com.fatec.biblioteca.entity.Livro;
import com.fatec.biblioteca.repository.AutorRepository;
import com.fatec.biblioteca.repository.LivroRepository;

import jakarta.validation.Valid;

@Service
public class LivroService {

	private LivroRepository livroRepository;
	private AutorRepository autorRepository;

	public Livro cadastrarLeitor(@Valid DadosLivro dados) {
		Livro livro = new Livro();
		Autor autor = autorRepository.findById(dados.idAutor()).get();
		
		livro.setNome(dados.nome());
		livro.setSinopse(dados.sinopse());
		livro.setVersao(dados.versao());
		livro.setDataLancamento(dados.dataLancamento());
		livro.setAutor(autor);
		livro.setGenero(dados.genero());
		livro.setIndicacaoIdade(dados.indicacaoIdade());
		
		livroRepository.save(livro);
		
		return livroRepository.getReferenceById(livro.getId());
	}
	
	public Optional<DadosDetalhamentoLivro> buscarPorId(Long id) {
		return livroRepository.findById(id).map(DadosDetalhamentoLivro::new);
	}
	
	public Page<DadosDetalhamentoLivro> buscarPorNome(String nome, Pageable paginacao) throws Exception {		
		if (livroRepository.findByAllNome(nome, paginacao).isEmpty())
			throw new Exception("Nenhuma pessoa encontrada");

		return livroRepository.findByAllNome(nome, paginacao).map(DadosDetalhamentoLivro::new);
	}
	
	public Page<DadosDetalhamentoLivro> listarTodos(Pageable paginacao) {
		return livroRepository.findAll(paginacao).map(DadosDetalhamentoLivro::new);
	}
	
	public Page<DadosDetalhamentoLivro> buscarPorNomeAutor(String nomeAutor, Pageable paginacao) throws Exception {		
		if (livroRepository.findByAllNomeAutor(nomeAutor, paginacao).isEmpty())
			throw new Exception("Nenhuma pessoa encontrada");

		return livroRepository.findByAllNomeAutor(nomeAutor, paginacao).map(DadosDetalhamentoLivro::new);
	}
	
	public Page<DadosDetalhamentoLivro> buscarPorGenero(String genero, Pageable paginacao) throws Exception {		
		if (livroRepository.findByAllGenero(genero, paginacao).isEmpty())
			throw new Exception("Nenhuma pessoa encontrada");

		return livroRepository.findByAllGenero(genero, paginacao).map(DadosDetalhamentoLivro::new);
	}
}
