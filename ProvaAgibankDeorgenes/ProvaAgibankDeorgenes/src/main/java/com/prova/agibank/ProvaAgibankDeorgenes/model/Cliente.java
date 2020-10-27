package com.prova.agibank.ProvaAgibankDeorgenes.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String cnpj;
    private final String nome;
    private final String businessArea;
}
