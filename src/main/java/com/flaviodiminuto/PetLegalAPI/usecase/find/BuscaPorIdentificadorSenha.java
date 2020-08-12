package com.flaviodiminuto.PetLegalAPI.usecase.find;

import com.flaviodiminuto.PetLegalAPI.exception.SemConteudoEncontrado;
import com.flaviodiminuto.PetLegalAPI.model.apresentacao.Login;
import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import com.flaviodiminuto.PetLegalAPI.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class BuscaPorIdentificadorSenha {

    @Autowired
    LoginRepository repository;

    public Login find(String identificador, String senha) throws SemConteudoEncontrado {
        String identificadorCifrado = Base64Utils.encodeToString(identificador.getBytes());
        String senhaCifrada = Base64Utils.encodeToString(senha.getBytes());
        LoginEntity entity =  repository.findByIdentificadorSenha(identificadorCifrado,senhaCifrada);
        if(entity == null)
            throw new SemConteudoEncontrado();
        Login login = new Login();
        login.identificador = Base64Utils.encodeToString(entity.getIdentificador().getBytes());
        login.senha = Base64Utils.encodeToString(entity.getSenha().getBytes());

        return login;
    }
}
