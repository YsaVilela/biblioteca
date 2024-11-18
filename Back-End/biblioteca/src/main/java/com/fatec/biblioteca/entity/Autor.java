package com.fatec.biblioteca.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDAutor")
    private Long id;

    @Column(name = "Nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "DataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "Nacionalidade", length = 255)
    private String nacionalidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
