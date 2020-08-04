package com.flaviodiminuto.PetLegalAPI.repository;

import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginEntity, Long> {

    @Query("SELECT le FROM login le WHERE le.identificador = ?1")
    LoginEntity findByIdentificador(String identificador);
}
