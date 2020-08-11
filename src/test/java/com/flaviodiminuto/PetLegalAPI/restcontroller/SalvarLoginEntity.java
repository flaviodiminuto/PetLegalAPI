package com.flaviodiminuto.PetLegalAPI.restcontroller;

import com.flaviodiminuto.PetLegalAPI.enumeradores.Mensagem;
import com.flaviodiminuto.PetLegalAPI.model.build.LoginBuilder;
import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import com.flaviodiminuto.PetLegalAPI.restcontroller.post.LoginController;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SalvarLoginEntity {
    private final String recurso = "/credencial";
    private static final LoginEntity entity = setup();
    private final String campoMensagem = "mensagem";


    public static LoginEntity setup(){
        String identificador = UUID.randomUUID().toString();
        String senha = "senha_teste";
        return  new LoginBuilder().identificador(identificador)
                .senha(senha)
                .dataCriacao(LocalDateTime.now())
                .build();
    }

    @Test
    public void testCadastroCredencial200(){
        setup();
        given().
                body(entity).
                contentType(ContentType.JSON).
        when().
                post(recurso).
        then()
                .assertThat()
                .contentType(ContentType.JSON)
                .body(campoMensagem, equalTo(Mensagem.SALVO_COM_SUCESSO.toString()))
                .statusCode(201);
    }

    @Test
    public void testCadastroIdentificadorExistente406(){
        given().
                body(entity).
                contentType(ContentType.JSON).
        when().
                post(recurso).
        then().
                assertThat().
                body(campoMensagem, equalTo(Mensagem.IDENTIFICADOR_INDISPONIVEL.toString())).
                contentType(ContentType.JSON).
                statusCode(406);
    }

    @Test
    public void testCadastroException500(){
        RestAssuredMockMvc.given().
                standaloneSetup(LoginController.class).
                body(entity).
                contentType(ContentType.JSON).
        when().
                post(recurso).
        then().
                assertThat().
                contentType(ContentType.JSON).
                body(campoMensagem, equalTo(Mensagem.INTERNAL_ERROR.toString())).
                statusCode(500);
    }

}
