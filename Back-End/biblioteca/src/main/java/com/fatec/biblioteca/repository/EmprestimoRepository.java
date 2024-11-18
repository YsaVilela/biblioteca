package com.fatec.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.biblioteca.entity.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
