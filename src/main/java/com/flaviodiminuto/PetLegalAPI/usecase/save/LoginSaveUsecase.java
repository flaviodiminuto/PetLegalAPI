package com.flaviodiminuto.PetLegalAPI.usecase.save;

import com.flaviodiminuto.PetLegalAPI.exception.SalvarIdentificadorExistente;
import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import com.flaviodiminuto.PetLegalAPI.repository.LoginRepository;
import com.flaviodiminuto.PetLegalAPI.usecase.save.SaveUsecase;
import com.flaviodiminuto.PetLegalAPI.util.TraceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import java.time.LocalDateTime;

@Component
public class LoginSaveUsecase implements SaveUsecase<LoginEntity> {

    @Autowired
    LoginRepository repository;

    @Override
    public boolean save(LoginEntity entity) throws SalvarIdentificadorExistente, NoSuchMethodException {
        logMetodoAtual("Preparando para salver Login", "save");

        entity.setIdentificador(Base64Utils.encodeToString(entity.getIdentificador().getBytes()));
        entity.setSenha(Base64Utils.encodeToString(entity.getSenha().getBytes()));
        entity.setDataCriacao(LocalDateTime.now());

        if(repository.findByIdentificador(entity.getIdentificador()) != null)
            throw new SalvarIdentificadorExistente();
        else {
            return repository.save(entity).getId() != null;
        }
    }

    @Override
    public void logMetodoAtual(String mensagem, String metodo) throws NoSuchMethodException {
        TraceUtil.logTrace(this.getClass(), this.getClass().getMethod(metodo, LoginEntity.class).getName(),mensagem);
    }
}
