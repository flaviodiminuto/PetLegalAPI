package com.flaviodiminuto.PetLegalAPI.usecase;

import com.flaviodiminuto.PetLegalAPI.model.entity.CredencialEntity;
import com.flaviodiminuto.PetLegalAPI.usecase.interfaces.SaveUsecase;
import com.flaviodiminuto.PetLegalAPI.util.TraceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.Base64Utils;

import static com.flaviodiminuto.PetLegalAPI.util.TraceUtil.logTrace;

public class CredencialSaveUsecase implements SaveUsecase<CredencialEntity> {
    @Autowired
    CrudRepository<CredencialEntity,Long> repository;

    @Override
    public boolean save(CredencialEntity credencial) {
        String encrypt = Base64Utils.encodeToString(credencial.getPasse().getBytes());
        credencial.setPasse(encrypt);
        return repository.save(credencial).getId() != null;
    }

    @Override
    public void logMetodoAtual(String mensagem) throws NoSuchMethodException {
        logTrace(getClass(),getClass().getMethod("save", CredencialEntity.class).getName(), mensagem);
    }
}
