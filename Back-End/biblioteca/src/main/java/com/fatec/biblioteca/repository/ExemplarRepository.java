package com.fatec.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.biblioteca.entity.Exemplar;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long>{

}
