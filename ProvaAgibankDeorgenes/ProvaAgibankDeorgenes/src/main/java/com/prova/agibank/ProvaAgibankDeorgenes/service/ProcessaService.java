package com.prova.agibank.ProvaAgibankDeorgenes.service;

import com.prova.agibank.ProvaAgibankDeorgenes.DTO.DataOutputDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Cliente;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Item;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Venda;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Vendedor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.*;

@NoArgsConstructor
@Service
public class ProcessaService {

    public DataOutputDTO processaArquivo(List<Path> pathList) {

        DataOutputDTO dataOutputDTO = new DataOutputDTO();

        pathList.forEach(path -> {
            try {
                Files.readAllLines(path).forEach(linha -> {
                    filtraDadosEntrada(linha, dataOutputDTO);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return dataOutputDTO;
    }

    private void filtraDadosEntrada(String linha, DataOutputDTO dataOutputDTO) {
        switch (linha.substring(COD_START, COD_END)) {
            case (COD_VENDEDOR):
                Vendedor vendedor =
                        tratarVendedor(linha.replace(COD_VENDEDOR, ""));
                dataOutputDTO.getVendedorList().add(vendedor);
                break;

            case (COD_CLIENTE):
                Cliente cliente =
                        tratarCliente(linha.replace(COD_CLIENTE, ""));
                dataOutputDTO.getClienteList().add(cliente);
                break;

            case (COD_VENDA):
                Venda venda =
                        tratarVenda(linha.replace(COD_VENDA, ""));
                dataOutputDTO.getVendaList().add(venda);
                break;

            default:
                System.out.println(ERR_COD_INVALIDO + linha);
        }
    }

    private Vendedor tratarVendedor(String linha) {
        String cpf;
        String nome;
        String salario;

        // CPF
        int indexInicial = linha.indexOf(DATA_SEPARATOR) + 1;
        int indexFinal = linha.indexOf(DATA_SEPARATOR, indexInicial + 1);
        cpf = linha.substring(indexInicial, indexFinal);

        // NOME
        indexInicial = indexFinal + 1;
        indexFinal = linha.indexOf(DATA_SEPARATOR, indexInicial + 1);
        nome = linha.substring(indexInicial, indexFinal);

        // SALÁRIO
        indexInicial = indexFinal + 1;
        indexFinal = linha.length();
        salario = linha.substring(indexInicial, indexFinal);

        return new Vendedor(cpf, nome, Double.valueOf(salario));
    }

    private Cliente tratarCliente(String linha) {
        String cnpj;
        String nome;
        String businessArea;

        // CNPJ
        int indexInicial = linha.indexOf(DATA_SEPARATOR) + 1;
        int indexFinal = linha.indexOf(DATA_SEPARATOR, indexInicial + 1);
        cnpj = linha.substring(indexInicial, indexFinal);

        // NOME
        indexInicial = indexFinal + 1;
        indexFinal = linha.indexOf(DATA_SEPARATOR, indexInicial + 1);
        nome = linha.substring(indexInicial, indexFinal);

        // BUSINESS AREA
        indexInicial = indexFinal + 1;
        indexFinal = linha.length();
        businessArea = linha.substring(indexInicial, indexFinal);

        return new Cliente(cnpj, nome, businessArea);
    }

    private Venda tratarVenda(String linha) {
        String id;
        List<Item> itemList = new ArrayList<Item>();
        String nomeVendedor;
        String itemString;

        // ID
        int indexInicial = linha.indexOf(DATA_SEPARATOR) + 1;
        int indexFinal = linha.indexOf(DATA_SEPARATOR, indexInicial + 1);
        id = linha.substring(indexInicial, indexFinal);

        // LISTA
        indexInicial = indexFinal + 1;
        indexFinal = linha.indexOf(DATA_SEPARATOR, indexInicial + 1);
        itemString = linha.substring(indexInicial, indexFinal);
        processaListaItens(itemString.replace("[", "").replace("]", ""), itemList);

        // NOME
        indexInicial = indexFinal + 1;
        indexFinal = linha.length();
        nomeVendedor = linha.substring(indexInicial, indexFinal);

        return new Venda(Integer.valueOf(id), itemList, nomeVendedor);
    }

    private void processaListaItens(String itemString, List<Item> itemList) {
        String id;
        String quantidade;
        String preco;
        int indexInicial = 0;
        boolean isLastIndex = false;

        while (!isLastIndex) {

            // ID
            int indexFinal = itemString.indexOf(DATA_LIST_SEPARATOR, indexInicial + 1);
            id = itemString.substring(indexInicial, indexFinal);

            // QUANTIDADE
            indexInicial = indexFinal + 1;
            indexFinal = itemString.indexOf(DATA_LIST_SEPARATOR, indexInicial + 1);
            quantidade = itemString.substring(indexInicial, indexFinal);

            // PREÇO
            indexInicial = indexFinal + 1;
            indexFinal = itemString.indexOf(END_LIST_MARK, indexInicial + 1);
            if (indexFinal == -1) {
                indexFinal = itemString.length();
                isLastIndex = true;
            }

            preco = itemString.substring(indexInicial, indexFinal);

            itemList.add(new Item(Integer.valueOf(id),
                    Integer.valueOf(quantidade),
                    Double.valueOf(preco)));

            indexInicial = indexFinal + 1;
        }
    }
}
