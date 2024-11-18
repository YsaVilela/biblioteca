package com.fatec.biblioteca.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.biblioteca.dto.autor.DadosAutor;
import com.fatec.biblioteca.dto.autor.DadosDetalhamentoAutor;
import com.fatec.biblioteca.entity.Autor;
import com.fatec.biblioteca.service.AutorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("autor")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AutorController {
	
	private AutorService service;

	@PostMapping("cadastrar")
	public ResponseEntity<Autor> cadastrar(
			@RequestBody @Valid DadosAutor dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAutor(dados));
	}

	@GetMapping("/buscarId/{id}")
	public ResponseEntity<Optional<DadosDetalhamentoAutor>> buscarId(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@GetMapping("/buscarNome/{nome}")
	public ResponseEntity<Page<DadosDetalhamentoAutor>> buscarNome(@PathVariable String nome,
			@PageableDefault(size = 1000, sort = { "id" }) Pageable paginacao) throws Exception {
		return ResponseEntity.ok(service.buscarPorNome(nome, paginacao));
	}
	
	@GetMapping("listarTodos")
	public ResponseEntity<Page<DadosDetalhamentoAutor>> listarTodos(
			@PageableDefault(size = 10) Pageable paginacao) {
		return ResponseEntity.ok(service.listarTodos(paginacao));
	}
	
}
