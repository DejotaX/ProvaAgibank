package com.prova.agibank.ProvaAgibankDeorgenes.service;

import com.prova.agibank.ProvaAgibankDeorgenes.DTO.DataOutputDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.DTO.ResultadoDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.DTO.VendaDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.DTO.VendedorDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Venda;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.INDICE_INICIAL;

@NoArgsConstructor
@Service
public class RelatorioService {

    public ResultadoDTO criaRelatorio(DataOutputDTO dataOutputDTO) {
        // Os métodos já retornam "String" para facilitar e deixar o código
        // mais claros na hora de gravar no arquivo de saída.
        return new ResultadoDTO(calcularClientes(dataOutputDTO.getVendedorList()),
                calcularVendedores(dataOutputDTO.getClienteList()),
                calcularVendaMaisCara(dataOutputDTO.getVendaList()),
                calcularPiorVendedor(dataOutputDTO.getVendaList()));
    }

    private String calcularVendaMaisCara(List<Venda> vendaList) {

        List<VendaDTO> vendaDTOList = new ArrayList<VendaDTO>();

        // Aqui multiplica o preço pela quantidade, para cada item de venda,
        // e depois coloca num array específico com id e valor total, para
        // depois ordenar.

        vendaList.forEach(venda -> {
            vendaDTOList.add(new VendaDTO(venda.getId(), venda.getItensList().stream()
                    .collect(Collectors.summingDouble(i -> i.getPreco() * i.getQuantidade()))));
        });

        // Ordena o array de vendas por ordem descrescentem pegando o primeiro
        // índice, que contém a venda com maior valor.

        Collections.sort(vendaDTOList);
        return String.valueOf(vendaDTOList.get(INDICE_INICIAL).getId());
    }

    private String calcularPiorVendedor(List<Venda> vendaList) {

        List<VendedorDTO> VendedorDTOList = new ArrayList<VendedorDTO>();

        // Aqui multiplica o preço pela quantidade, para cada item de venda,
        // e depois coloca num array específico com nomde do vendedor e valor total,
        // para depois ordenar.

        vendaList.forEach(venda -> {
            VendedorDTOList.add(new VendedorDTO(venda.getNomeVendedor(), venda.getItensList().stream()
                    .collect(Collectors.summingDouble(i -> i.getPreco() * i.getQuantidade()))));
        });

        // Ordena o array de vendas por ordem crescente pegando o primeiro
        // índice, que contém a venda com menor valor.

        Collections.sort(VendedorDTOList);

        return VendedorDTOList.get(INDICE_INICIAL).getNome();
    }

    private String calcularVendedores(List vendedorList) {
        // O calculo foi feito deste jeito, considerando
        // que os vendedores não estejam duplicados no sistema.
        return String.valueOf(vendedorList.size());
    }

    private String calcularClientes(List clienteList) {
        // O calculo foi feito deste jeito, considerando
        // que os clientes não estejam duplicados no sistema,
        // Nem que haja uma business area diferente para o
        // mesmo CNPJ.
        return String.valueOf(clienteList.size());
    }
}
