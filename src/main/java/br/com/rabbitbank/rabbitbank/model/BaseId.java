package br.com.rabbitbank.rabbitbank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class BaseId {
    private Long id;
}
