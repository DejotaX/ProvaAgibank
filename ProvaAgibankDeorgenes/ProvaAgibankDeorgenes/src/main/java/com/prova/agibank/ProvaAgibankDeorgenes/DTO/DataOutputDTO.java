package com.prova.agibank.ProvaAgibankDeorgenes.DTO;

import com.prova.agibank.ProvaAgibankDeorgenes.model.Cliente;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Venda;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Vendedor;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class DataOutputDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private final List<Vendedor> vendedorList;
    private final List<Cliente> clienteList;
    private final List<Venda> vendaList;

    public DataOutputDTO() {
        vendedorList = new ArrayList<Vendedor>();
        clienteList = new ArrayList<Cliente>();
        vendaList = new ArrayList<Venda>();
    }
}
