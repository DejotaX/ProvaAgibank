package com.prova.agibank.ProvaAgibankDeorgenes.util;

import lombok.NoArgsConstructor;

import static java.awt.SystemColor.info;

@NoArgsConstructor
public class ConstantsUtil {
    public static final String MSG_PROCESSAMENTO = "Iniciando processamento Número: ";
    public static final String DIRETORIO_LEITURA = "\\data\\in\\";
    public static final String DIRETORIO_ESCRITA = "\\data\\out\\flat_file_name.done.dat";
    public static final String HOMEPATH = "HOMEPATH";
    public static final String CABECALHO = "***** RELATORIO PROVA AGIBANK - DEORGENES *****";
    public static final String QTD_CLIENTES = "QUANTIDADE DE CLIENTES: ";
    public static final String QTD_VENDEDORES = "QUANTIDADE DE VENDEDORES: ";
    public static final String MELHOR_VENDA = "ID DA MELHOR VENDA: ";
    public static final String PIOR_VENDEDOR = "NOME DO PIOR VENDEDOR: ";
    public static final String TERMINADOR_LINHA = "\r\n";
    public static final String COD_VENDEDOR = "001";
    public static final String COD_CLIENTE = "002";
    public static final String COD_VENDA = "003";
    public static final String ERR_COD_INVALIDO = "Código inválido na linha ";
    public static final String DATA_SEPARATOR = "ç";
    public static final String DATA_LIST_SEPARATOR = "-";
    public static final String END_LIST_MARK = ",";
    public static final String EMPTY = "";
    public static final long LONG_ZERO = 0;
    public static final int INDICE_INICIAL = 0;
    public static final int COD_START = 0;
    public static final int COD_END = 3;
    public static final int TAXA_LEITURA_mSEGUNDO = 10000;
}
