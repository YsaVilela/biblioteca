package com.fatec.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatec.biblioteca.dto.leitor.DadosDetalhamentoLeitor;
import com.fatec.biblioteca.dto.leitor.DadosLeitor;
import com.fatec.biblioteca.entity.Endereco;
import com.fatec.biblioteca.entity.Leitor;
import com.fatec.biblioteca.repository.EnderecoRepository;
import com.fatec.biblioteca.repository.LeitorRepository;

import jakarta.validation.Valid;

@Service
public class LeitorService {

    @Autowired
	private LeitorRepository leitorRepository;
    
    @Autowired
	private EnderecoRepository enderecoRepository;

	public Leitor cadastrarLeitor(@Valid DadosLeitor dados) {
		Endereco endereco = new Endereco();
		endereco.setRua(dados.endereco().rua());
		endereco.setBairro(dados.endereco().bairro());
		endereco.setNumero(dados.endereco().numero());
		endereco.setComplemento(dados.endereco().complemento());
		endereco.setCep(dados.endereco().cep());
		
		enderecoRepository.save(endereco);
		
		Leitor leitor = new Leitor();
		leitor.setNome(dados.nome());
		leitor.setEmail(dados.email());
		leitor.setTelefone(dados.telefone());
		leitor.setEndereco(endereco);
		leitor.setDataNascimento(dados.dataNascimento());
		leitor.setStatus(true);
		
		leitorRepository.save(leitor);
		
		return leitorRepository.getReferenceById(leitor.getId());
	}
	
	public Page<DadosDetalhamentoLeitor> buscarPorId(Long id, Pageable paginacao) {
		return leitorRepository.findById(id, paginacao).map(DadosDetalhamentoLeitor::new);
	}
	
	public Page<DadosDetalhamentoLeitor> buscarPorEmail(String email, Pageable paginacao) {
		return leitorRepository.findByEmail(email, paginacao).map(DadosDetalhamentoLeitor::new);
	}
	
	public Page<DadosDetalhamentoLeitor> buscarPorNome(String nome, Pageable paginacao) throws Exception {		
		return leitorRepository.findByAllNome(nome, paginacao).map(DadosDetalhamentoLeitor::new);
	}
	
	public Page<DadosDetalhamentoLeitor> listarTodos(Pageable paginacao) {
		return leitorRepository.findAll(paginacao).map(DadosDetalhamentoLeitor::new);
	}
	
	public void desativarLeitor(Long id) {
		Leitor leitor = leitorRepository.getReferenceById(id);
		boolean statusLeitor = leitor.getStatus();
		leitor.setStatus(!statusLeitor);
	}
}
