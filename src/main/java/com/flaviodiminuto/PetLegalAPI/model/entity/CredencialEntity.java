package com.flaviodiminuto.PetLegalAPI.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "credencial")
public class CredencialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String passe;
    private LocalDateTime dataEmissao;
    private LocalDateTime dataExpiracao;

    public CredencialEntity() {
    }

    public CredencialEntity(Long id, String passe, LocalDateTime dataEmissao, LocalDateTime dataExpiracao) {
        this.id = id;
        this.passe = passe;
        this.dataEmissao = dataEmissao;
        this.dataExpiracao = dataExpiracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    @Override
    public String toString() {
        return "credencial={" +
                "id : " + id +
                ", passe : '" + passe + '\'' +
                ", dataEmissao : " + dataEmissao +
                ", dataExpiracao : " + dataExpiracao +
                '}';
    }
}
