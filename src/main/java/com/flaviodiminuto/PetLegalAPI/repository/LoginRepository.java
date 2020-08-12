package com.flaviodiminuto.PetLegalAPI.repository;

import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    @Query("SELECT le FROM login le WHERE le.identificador = ?1")
    LoginEntity findByIdentificador(String identificador);

    @Query("SELECT le FROM login le WHERE le.identificador = :identificador AND le.senha = :senha")
    LoginEntity findByIdentificadorSenha(@Param("identificador") String identificador,
                                         @Param("senha") String senha);
}
