package com.flaviodiminuto.PetLegalAPI.exception;

public class SemConteudoEncontrado extends Throwable {
    String message = "Sem conteudo encontrado";

    @Override
    public String getMessage() {
        return message;
    }
}
