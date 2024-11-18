package com.fatec.biblioteca.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_Exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDExemplar")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDLivro", nullable = false)
    private Livro livro;

    @Column(name = "Status", length = 255, nullable = false)
    private String status;
    
    @Column(name = "EstadoConservacao")
    private Integer estadoConservacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public Integer getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(Integer estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }
}
