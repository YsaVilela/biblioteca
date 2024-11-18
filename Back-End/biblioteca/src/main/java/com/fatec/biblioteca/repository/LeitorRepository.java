package com.fatec.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.biblioteca.dto.leitor.DadosDetalhamentoLeitor;
import com.fatec.biblioteca.entity.Leitor;

public interface LeitorRepository extends JpaRepository<Leitor, Long>{

	@Query("""
	        select l from Leitor l
	        where lower(l.nome) like lower(concat('%', :nome, '%'))
	        """)
    Page<Leitor> findByAllNome(@Param("nome") String nome, Pageable paginacao);
	
	@Query("""
			select r from Leitor r
			where r.email = :email 
			""")
	Page<Leitor> findByEmail(String email, Pageable paginacao);

	Page<Leitor> findById(Long id, Pageable paginacao);
}
