package com.fatec.biblioteca.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_Leitor")
public class Leitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCliente")
    private Long id;

    @Column(name = "Nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "Email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "Telefone")
    private String telefone;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ENDERECO")
    private Endereco endereco;

    @Column(name = "DataNascimento")
    private LocalDate dataNascimento;

    @Column(name = "Status", nullable = false)
    private Boolean status;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
