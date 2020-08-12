package com.flaviodiminuto.PetLegalAPI.enumeradores;

public enum Mensagem {
    INTERNAL_ERROR ("Ocorreu um erro inexperado, tente novamente mais tarde"),
    IDENTIFICADOR_INDISPONIVEL ("Identificador indisponivel,por favor tente outro"),
    SALVO_COM_SUCESSO ("Salvo com sucesso!"),
    NA0_AUTORIZADO("Não autorizado");

    private String message;
    Mensagem(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
