package com.fatec.biblioteca.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_Livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDLivro")
    private Long id;

    @Column(name = "Nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "Sinopse")
    private String sinopse;

    @Column(name = "Versao", length = 255)
    private String versao;

    @Column(name = "DataLancamento")
    private LocalDate dataLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDAutor", nullable = false)
    private Autor autor;

    @Column(name = "Genero", length = 255)
    private String genero;

    @Column(name = "IndicacaoIdade")
    private Integer indicacaoIdade;

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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIndicacaoIdade() {
        return indicacaoIdade;
    }

    public void setIndicacaoIdade(Integer indicacaoIdade) {
        this.indicacaoIdade = indicacaoIdade;
    }
}
