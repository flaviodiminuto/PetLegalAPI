package com.flaviodiminuto.PetLegalAPI.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "login")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "identificador")
    private String identificador;
    @Column(name = "senha")
    private String senha;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public LoginEntity() {
    }

    public LoginEntity(Long id, String identificador, String senha, LocalDateTime dataCriacao) {
        this.id = id;
        this.identificador = identificador;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
