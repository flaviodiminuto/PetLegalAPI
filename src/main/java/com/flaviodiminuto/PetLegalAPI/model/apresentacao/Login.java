package com.flaviodiminuto.PetLegalAPI.model.apresentacao;

import com.fasterxml.jackson.annotation.JsonProperty;

//DTO
public class Login {
    @JsonProperty("identificador")
    public String identificador;
    @JsonProperty("senha")
    public String senha;
}
