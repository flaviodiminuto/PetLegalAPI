package com.flaviodiminuto.PetLegalAPI.mapper;

public interface EntityToApresentacao<E,A> {
    A toApresentacao(E entity);
}
