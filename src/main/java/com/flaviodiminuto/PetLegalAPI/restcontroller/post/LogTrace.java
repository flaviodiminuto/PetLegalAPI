package com.flaviodiminuto.PetLegalAPI.restcontroller.post;

public interface LogTrace {
    void logMetodoAtual(String mensagem, String method) throws NoSuchMethodException;
}
