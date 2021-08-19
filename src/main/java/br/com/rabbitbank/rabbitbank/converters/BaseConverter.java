package br.com.rabbitbank.rabbitbank.converters;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseConverter<D,E> {
    public abstract D mapEntityToDTO(E entity);

    public abstract E mapDTOToEntity(D dto);

    public List<D> mapEntitiesToDTOs(List<E> entities) {
        List<D> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> dtos.add(mapEntityToDTO(entity)));
        return dtos;
    }

    public List<E> mapDTOsToEntities(List<D> dtos) {
        List<E> entities = new ArrayList<>();
        dtos.stream().forEach(dto -> entities.add(mapDTOToEntity(dto)));
        return entities;
    }
}
