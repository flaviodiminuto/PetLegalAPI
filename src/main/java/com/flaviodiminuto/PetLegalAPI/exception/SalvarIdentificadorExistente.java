package com.flaviodiminuto.PetLegalAPI.exception;

import com.flaviodiminuto.PetLegalAPI.enumeradores.Mensagem;

public class SalvarIdentificadorExistente extends Throwable {

    public String getMenssagemSImples(){
        return Mensagem.IDENTIFICADOR_INDISPONIVEL;
    }
}
