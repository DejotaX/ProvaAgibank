package com.prova.agibank.ProvaAgibankDeorgenes.service;

import com.prova.agibank.ProvaAgibankDeorgenes.DTO.ResultadoDTO;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.*;

@NoArgsConstructor
@Service
public class GravaService {

    private static Logger LOGGER = LoggerFactory.getLogger(GravaService.class);

    public void gravaArquivo(ResultadoDTO resultadoDTO, String diretorio) throws IOException {

        try{
            String env = System.getenv(HOMEPATH);
            Path path = Paths.get(env.concat(diretorio));

            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            gravaLinhaNew(CABECALHO, EMPTY, path);
            gravaLinhaApp(QTD_CLIENTES, resultadoDTO.getQuantidadeClientes(), path);
            gravaLinhaApp(QTD_VENDEDORES, resultadoDTO.getQuantidadeVendedores(), path);
            gravaLinhaApp(MELHOR_VENDA, resultadoDTO.getIdVendaMaisCara(), path);
            gravaLinhaApp(PIOR_VENDEDOR, resultadoDTO.getNomePiorVendedor(), path);
        }catch (IOException ex){
            LOGGER.info("Erro na gravação do arquivo do relatório. Verifique o diretório");
        }
    }

    private void gravaLinhaNew(String nome, String valor, Path path) throws IOException {
        // Para evitar problemas na gravação, foi escolhida esta maneira de gravar os arquivos,
        // entao caso o arquivo ja exista, eu sobrescrevo a primeira linha em todo o arquivo,
        // e as próximas simplesmente são adicionadas como nova linha.
        Files.writeString(path, nome.concat(valor).concat(TERMINADOR_LINHA), StandardOpenOption.TRUNCATE_EXISTING);
    }

    private void gravaLinhaApp(String nome, String valor, Path path) throws IOException {
        Files.writeString(path, nome.concat(valor).concat(TERMINADOR_LINHA), StandardOpenOption.APPEND);
    }
}
