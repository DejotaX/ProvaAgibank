package com.prova.agibank.ProvaAgibankDeorgenes.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String cpf;
    private final String nome;
    private final Double salario;
}
