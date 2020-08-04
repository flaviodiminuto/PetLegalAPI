package com.flaviodiminuto.PetLegalAPI.restcontroller;

import com.flaviodiminuto.PetLegalAPI.model.build.LoginBuilder;
import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import com.flaviodiminuto.PetLegalAPI.usecase.interfaces.SaveUsecase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
//import static io.restassured.module.mockmvc.matcher.RestAssuredMockMvcMatchers.*;

public class SalvarLoginEntity {
    private final String recurso = "/credencial";

    @Test
    public void testCadastroCredencial(){
        String identificador = UUID.randomUUID().toString();
        String senha = "senha_teste";

        LoginEntity loginEntity = new LoginBuilder().identificador(identificador)
                .senha(senha)
                .dataCriacao(LocalDateTime.now())
                .build();
        given().
                body(loginEntity).
                contentType(ContentType.JSON).
        when().
                post(recurso).
        then()
                .statusCode(201);
    }

}
