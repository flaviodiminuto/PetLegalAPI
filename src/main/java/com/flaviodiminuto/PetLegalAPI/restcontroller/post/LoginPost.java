package com.flaviodiminuto.PetLegalAPI.restcontroller.post;

import com.flaviodiminuto.PetLegalAPI.enumeradores.Mensagem;
import com.flaviodiminuto.PetLegalAPI.exception.SalvarIdentificadorExistente;
import com.flaviodiminuto.PetLegalAPI.mapper.ApresentacaoToEntity;
import com.flaviodiminuto.PetLegalAPI.model.apresentacao.Login;
import com.flaviodiminuto.PetLegalAPI.model.apresentacao.MessageTraceavel;
import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import com.flaviodiminuto.PetLegalAPI.usecase.interfaces.SaveUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.flaviodiminuto.PetLegalAPI.util.TraceUtil.*;

@RestController
@RequestMapping("/credencial")
public class LoginPost implements LogTrace {

    @Autowired
    SaveUsecase<LoginEntity> usecase;

    @Autowired
    ApresentacaoToEntity<Login, LoginEntity> mapper;

    @PostMapping
    public ResponseEntity<MessageTraceavel> post(@RequestBody Login login) throws NoSuchMethodException {
        initTrace(this.getClass());
        MessageTraceavel eMessage ;
        HttpStatus status;
        logMetodoAtual("Inicio");
        try{
            LoginEntity entity = mapper.toEntity(login);
            usecase.save(entity);
            logMetodoAtual("POST 201 => ");
            eMessage = prepareMessage(Mensagem.SALVO_COM_SUCESSO);
            status = HttpStatus.CREATED;
        }catch (Exception e){
            logMetodoAtual("POST 500 => \n" + e.getMessage() + "\n");
            eMessage = prepareMessage(Mensagem.INTERNAL_ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }catch (SalvarIdentificadorExistente e){
            logMetodoAtual("POST 406 =>");
            eMessage= prepareMessage(e.getMenssagemSImples());
            status = HttpStatus.NOT_ACCEPTABLE;
        }
        return ResponseEntity.status(status).body(eMessage);
    }

    public void logMetodoAtual(String mensagem) throws NoSuchMethodException {
        logTrace(this.getClass(), this.getClass().getMethod("post", Login.class).getName() , mensagem);
    }
}
