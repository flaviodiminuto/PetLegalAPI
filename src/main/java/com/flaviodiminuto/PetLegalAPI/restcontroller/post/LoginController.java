package com.flaviodiminuto.PetLegalAPI.restcontroller.post;

import com.flaviodiminuto.PetLegalAPI.enumeradores.Mensagem;
import com.flaviodiminuto.PetLegalAPI.exception.SalvarIdentificadorExistente;
import com.flaviodiminuto.PetLegalAPI.exception.SemConteudoEncontrado;
import com.flaviodiminuto.PetLegalAPI.mapper.ApresentacaoToEntity;
import com.flaviodiminuto.PetLegalAPI.model.apresentacao.Login;
import com.flaviodiminuto.PetLegalAPI.model.apresentacao.MessageTraceavel;
import com.flaviodiminuto.PetLegalAPI.model.entity.LoginEntity;
import com.flaviodiminuto.PetLegalAPI.usecase.find.BuscaPorIdentificadorSenha;
import com.flaviodiminuto.PetLegalAPI.usecase.save.SaveUsecase;
import com.flaviodiminuto.PetLegalAPI.util.TraceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.flaviodiminuto.PetLegalAPI.util.TraceUtil.*;

@RestController
@RequestMapping("/credencial")
public class LoginController implements LogTrace {

    @Autowired
    SaveUsecase<LoginEntity> saveUsecase;

    @Autowired
    BuscaPorIdentificadorSenha buscarUseCase;

    @Autowired
    ApresentacaoToEntity<Login, LoginEntity> mapper;

    @Autowired
    Environment env;

    @PostMapping
    public ResponseEntity<MessageTraceavel> post(@RequestBody Login login) throws NoSuchMethodException {
        String method = "post";
        initTrace(this.getClass());
        MessageTraceavel eMessage ;
        HttpStatus status;
        logMetodoAtual("Inicio",method);
        try{
            LoginEntity entity = mapper.toEntity(login);
            saveUsecase.save(entity);
            logMetodoAtual(entity.toString(),method);
            logMetodoAtual("POST 201 => ",method);
            eMessage = prepareMessage(Mensagem.SALVO_COM_SUCESSO);
            status = HttpStatus.CREATED;
        }catch (Exception e){
            e.printStackTrace();
            logMetodoAtual("POST 500 => \n" + e.getMessage() + "\n",method);
            eMessage = prepareMessage(Mensagem.INTERNAL_ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }catch (SalvarIdentificadorExistente e){
            logMetodoAtual("POST 406 =>",method);
            eMessage= prepareMessage(e.getMenssagemSImples());
            status = HttpStatus.NOT_ACCEPTABLE;
        }
        return ResponseEntity.status(status).body(eMessage);
    }

    @GetMapping("/{key}/{identificador}/{senha}")
    public ResponseEntity get(@PathVariable("key") String key,
                              @PathVariable("identificador") String identificador,
                              @PathVariable("senha")String senha) throws NoSuchMethodException {
        String method = "post";
        initTrace(this.getClass());
        String shadowKey = env.getProperty("shadow.key");

        if(shadowKey != null && !shadowKey.equals(key) ) {
            logMetodoAtual("POST 403 => ",method);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        try {
            Login login = buscarUseCase.find(identificador,senha);

            logMetodoAtual("POST 200 => ",method);
            return ResponseEntity.ok(login);
        }catch (SemConteudoEncontrado e){
            logMetodoAtual("post 401 => ", method);
            MessageTraceavel mensagem  = TraceUtil.prepareMessage(Mensagem.NA0_AUTORIZADO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageTraceavel());
        }
    }

    @Override
    public void logMetodoAtual(String mensagem, String method) throws NoSuchMethodException {
        logTrace(this.getClass(), this.getClass().getMethod(method, Login.class).getName() , mensagem);
    }
}
