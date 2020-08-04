package com.flaviodiminuto.PetLegalAPI.mapper;

import com.flaviodiminuto.PetLegalAPI.model.apresentacao.Login;
import com.flaviodiminuto.PetLegalAPI.model.build.LoginBuilder;
import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper implements ApresentacaoToEntity<Login, LoginEntity> {
    @Override
    public LoginEntity toEntity(Login apresentacao) {
        return new LoginBuilder()
                .identificador(apresentacao.identificador)
                .senha(apresentacao.senha)
                .build();
    }
}
