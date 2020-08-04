package com.flaviodiminuto.PetLegalAPI.mapper;

public interface ApresentacaoToEntity<A,E> {

    E toEntity(A apresentacao);
}
