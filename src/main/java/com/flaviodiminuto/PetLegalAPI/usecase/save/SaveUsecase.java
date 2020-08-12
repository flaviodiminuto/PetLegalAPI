package com.flaviodiminuto.PetLegalAPI.usecase.save;


import com.flaviodiminuto.PetLegalAPI.exception.SalvarIdentificadorExistente;
import com.flaviodiminuto.PetLegalAPI.restcontroller.post.LogTrace;

public interface SaveUsecase<T> extends LogTrace {
    boolean save(T entity) throws SalvarIdentificadorExistente, NoSuchMethodException;
}
