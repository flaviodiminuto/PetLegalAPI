package com.flaviodiminuto.PetLegalAPI.model.build;

import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;

import java.time.LocalDateTime;

public class LoginBuilder {
    private Long id;
    private String identificador;
    private String senha;
    private LocalDateTime dataCriacao;

    public LoginBuilder id(Long id){
        this.id = id;
        return this;
    }
    public LoginBuilder identificador(String identificador){
        this.identificador = identificador;
        return this;
    }
    public LoginBuilder senha(String senha){
        this.senha = senha;
        return this;
    }
    public LoginBuilder dataCriacao(LocalDateTime dataCriacao){
        this.dataCriacao = dataCriacao;
        return this;
    }

    public LoginEntity build(){
        return new LoginEntity(id,identificador,senha,dataCriacao);
    }
}
