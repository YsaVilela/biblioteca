package com.fatec.biblioteca.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_Emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDLocacao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDExemplar", nullable = false)
    private Exemplar exemplar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDLeitor", nullable = false)
    private Leitor leitor;

    @Column(name = "DataEmprestimo", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "DataPrevistaDevolucao", nullable = false)
    private LocalDate dataPrevistaDevolucao;

    @Column(name = "DataDevolucao")
    private LocalDate dataDevolucao;

    @Column(name = "Status", nullable = false, length = 255)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
