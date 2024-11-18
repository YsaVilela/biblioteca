package com.fatec.biblioteca.dto.leitor;

import java.time.LocalDate;

import com.fatec.biblioteca.entity.Endereco;
import com.fatec.biblioteca.entity.Leitor;

public record DadosDetalhamentoLeitor(
		Long id,
		String nome,
		String email,
		String telefone,
		LocalDate dataNascimento,
		Boolean status,
		Endereco endereco) {
	
	public DadosDetalhamentoLeitor (Leitor leitor) {
		this(leitor.getId(),
				leitor.getNome(),
				leitor.getEmail(),
				leitor.getTelefone(),
				leitor.getDataNascimento(),
				leitor.getStatus(),
				leitor.getEndereco());
	}
}
