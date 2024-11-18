package com.fatec.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.biblioteca.dto.leitor.DadosDetalhamentoLeitor;
import com.fatec.biblioteca.dto.leitor.DadosLeitor;
import com.fatec.biblioteca.entity.Leitor;
import com.fatec.biblioteca.service.LeitorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("leitor")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LeitorController {

    @Autowired
	private LeitorService service;
	
	@PostMapping("cadastrar")
	public ResponseEntity<Leitor> cadastrar(
			@RequestBody @Valid DadosLeitor dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarLeitor(dados));
	}

	@GetMapping("/buscarId/{id}")
	public ResponseEntity<Page<DadosDetalhamentoLeitor>> buscarId(@PathVariable Long id,
			@PageableDefault(size = 10, sort = { "id" }) Pageable paginacao) {
		return ResponseEntity.ok(service.buscarPorId(id, paginacao));
	}
	
	@GetMapping("/buscarNome/{nome}")
	public ResponseEntity<Page<DadosDetalhamentoLeitor>> buscarNome(@PathVariable String nome,
			@PageableDefault(size = 1000, sort = { "id" }) Pageable paginacao) throws Exception {
		return ResponseEntity.ok(service.buscarPorNome(nome, paginacao));
	}

	@GetMapping("/buscarEmail/{email}")
	public ResponseEntity<Page<DadosDetalhamentoLeitor>> buscarCpf(@PathVariable String email,
			@PageableDefault(size = 10, sort = { "id" }) Pageable paginacao) {
		return ResponseEntity.ok(service.buscarPorEmail(email, paginacao));
	}
	
	@GetMapping("listarTodos")
	public ResponseEntity<Page<DadosDetalhamentoLeitor>> listarTodos(
			@PageableDefault(size = 10) Pageable paginacao) {
		return ResponseEntity.ok(service.listarTodos(paginacao));
	}
	
	@DeleteMapping("desativar/{id}")
	public ResponseEntity<HttpStatus> desativarLeitor(@PathVariable Long id) {
		service.desativarLeitor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
