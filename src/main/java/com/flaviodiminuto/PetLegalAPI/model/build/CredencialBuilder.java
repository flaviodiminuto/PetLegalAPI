package com.flaviodiminuto.PetLegalAPI.model.build;

import com.flaviodiminuto.PetLegalAPI.model.entity.CredencialEntity;

import java.time.LocalDateTime;
import java.util.Base64;

public class CredencialBuilder {
        private Long id;
        private String passe;
        private LocalDateTime dataEmissao;
        private LocalDateTime dataExpiracao;

        public CredencialBuilder id(Long id){
            this.id = id;
            return  this;
        }

        public CredencialBuilder passe(String passe){
            this.passe = passe;
            return this;
        }

        public CredencialBuilder dataEmissao(LocalDateTime dataEmissao){
            this.dataEmissao = dataEmissao;
            return this;
        }

        public CredencialBuilder dataExpiracao(LocalDateTime dataExpiracao) {
            this.dataExpiracao = dataExpiracao;
            return this;
        }

        public CredencialEntity build(){
            return new CredencialEntity(id,passe,dataEmissao,dataExpiracao);
        }
}
