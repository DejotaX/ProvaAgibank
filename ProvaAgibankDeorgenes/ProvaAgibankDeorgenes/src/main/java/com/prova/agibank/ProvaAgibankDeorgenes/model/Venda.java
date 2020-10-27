package com.prova.agibank.ProvaAgibankDeorgenes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int id;
    private final List<Item> itensList;
    private final String nomeVendedor;
}
