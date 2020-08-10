package com.flaviodiminuto.PetLegalAPI.exception;

import com.flaviodiminuto.PetLegalAPI.enumeradores.Mensagem;

import static com.flaviodiminuto.PetLegalAPI.enumeradores.Mensagem.IDENTIFICADOR_INDISPONIVEL;

public class SalvarIdentificadorExistente extends Throwable {

    public Mensagem getMenssagemSImples(){
        return IDENTIFICADOR_INDISPONIVEL;
    }
}
