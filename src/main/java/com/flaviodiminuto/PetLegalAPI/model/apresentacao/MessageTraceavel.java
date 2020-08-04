package com.flaviodiminuto.PetLegalAPI.model.apresentacao;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

//Aprensentacao - DTO
public class MessageTraceavel {
    @JsonProperty("trace")
    public String trace;
    @JsonProperty("mensagem")
    public String mensagem;
    @JsonProperty("data_hora")
    public LocalDateTime dataHora = LocalDateTime.now();
}
