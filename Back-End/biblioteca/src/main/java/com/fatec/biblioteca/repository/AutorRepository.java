package com.fatec.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.biblioteca.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	@Query("""
	        select l from Autor l
	        where lower(l.nome) like lower(concat('%', :nome, '%'))
	        """)
    Page<Autor> findByAllNome(@Param("nome") String nome, Pageable paginacao);

}
