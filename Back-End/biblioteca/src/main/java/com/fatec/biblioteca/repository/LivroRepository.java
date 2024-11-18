package com.fatec.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	@Query("""
	        select l from Livro l
	        where lower(l.nome) like lower(concat('%', :nome, '%'))
	        """)
    Page<Livro> findByAllNome(@Param("nome") String nome, Pageable paginacao);
	
	@Query("""
            select l from Livro l
            join l.autor a
            where lower(a.nome) like lower(concat('%', :nome, '%'))
			""")
	Page<Livro> findByAllNomeAutor(@Param("nome") String nomeAutor, Pageable paginacao);
	
	@Query("""
	        select l from Livro l
	        where l.genero = :genero
	        """)
    Page<Livro> findByAllGenero(@Param("genero") String genero, Pageable paginacao);
	
	@Query("""
            select l from Livro l
            join l.autor a
            where a.id = :idAutor
			""")
	Page<Livro> findByAllIdAutor(@Param("idAutor") Long idAutor, Pageable paginacao);
}
