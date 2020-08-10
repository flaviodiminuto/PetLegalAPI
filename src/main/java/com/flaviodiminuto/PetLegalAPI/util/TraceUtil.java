package com.flaviodiminuto.PetLegalAPI.util;

import com.flaviodiminuto.PetLegalAPI.enumeradores.Mensagem;
import com.flaviodiminuto.PetLegalAPI.model.apresentacao.MessageTraceavel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TraceUtil {
    private static String trace;
    private static Logger logger;

    public static void initTrace( Class clazz){
        trace = UUID.randomUUID().toString();
        logger = LoggerFactory.getLogger(clazz);
    }

    public static MessageTraceavel prepareMessage(Mensagem message){
        MessageTraceavel eMessage = new MessageTraceavel();
        eMessage.trace = TraceUtil.getTrace();
        eMessage.mensagem =  message.toString();
        return eMessage;
    }

    public static void logTrace(Class clazz, String metodo, String message){
        logger= LoggerFactory.getLogger(clazz);
        logTrace(message + " : " + metodo + " => " );
    }

    private static void logTrace(String message){
        logger.info(message + trace);
    }

    public static String getTrace() {
        return trace;
    }
}
