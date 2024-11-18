package com.fatec.biblioteca.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_Endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Rua", nullable = false, length = 255)
    private String rua;

    @Column(name = "Bairro", nullable = false, length = 255)
    private String bairro;

    @Column(name = "Numero", nullable = false)
    private Integer numero;

    @Column(name = "Complemento", length = 255)
    private String complemento;

    @Column(name = "CEP", nullable = false)
    private String cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
