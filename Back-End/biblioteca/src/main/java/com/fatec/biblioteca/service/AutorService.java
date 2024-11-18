package com.fatec.biblioteca.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatec.biblioteca.dto.autor.DadosAutor;
import com.fatec.biblioteca.dto.autor.DadosDetalhamentoAutor;
import com.fatec.biblioteca.entity.Autor;
import com.fatec.biblioteca.repository.AutorRepository;

import jakarta.validation.Valid;

@Service
public class AutorService {

	private AutorRepository autorRepository;
	
	public Autor cadastrarAutor(@Valid DadosAutor dados) {
		Autor autor = new Autor();
		autor.setNome(dados.nome());
		autor.setDataNascimento(dados.dataNascimento());
		autor.setNacionalidade(dados.nacionalidade());
		
		autorRepository.save(autor);
		
		return autorRepository.getReferenceById(autor.getId());
	}
	
	public Optional<DadosDetalhamentoAutor> buscarPorId(Long id) {
		return autorRepository.findById(id).map(DadosDetalhamentoAutor::new);
	}
	
	public Page<DadosDetalhamentoAutor> listarTodos(Pageable paginacao) {
		return autorRepository.findAll(paginacao).map(DadosDetalhamentoAutor::new);
	}
	
	public Page<DadosDetalhamentoAutor> buscarPorNome(String nome, Pageable paginacao) throws Exception {		
		if (autorRepository.findByAllNome(nome, paginacao).isEmpty())
			throw new Exception("Nenhuma pessoa encontrada");

		return autorRepository.findByAllNome(nome, paginacao).map(DadosDetalhamentoAutor::new);
	}
	
	
}
