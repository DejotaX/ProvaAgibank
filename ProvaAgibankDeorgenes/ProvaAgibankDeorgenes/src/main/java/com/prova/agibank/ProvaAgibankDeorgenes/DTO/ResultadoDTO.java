package com.prova.agibank.ProvaAgibankDeorgenes.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ResultadoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String quantidadeClientes;
    private final String quantidadeVendedores;
    private final String idVendaMaisCara;
    private final String nomePiorVendedor;
}
