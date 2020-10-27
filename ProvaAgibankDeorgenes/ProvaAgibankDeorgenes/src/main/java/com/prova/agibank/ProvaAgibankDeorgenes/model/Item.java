package com.prova.agibank.ProvaAgibankDeorgenes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int id;
    private final int quantidade;
    private final Double preco;
}
