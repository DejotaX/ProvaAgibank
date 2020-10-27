package com.prova.agibank.ProvaAgibankDeorgenes.service;

import com.prova.agibank.ProvaAgibankDeorgenes.DTO.DataOutputDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.DTO.ResultadoDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.*;


// Construtor com injeção de dependências, para não usar autowired.
@AllArgsConstructor
@Component
@EnableScheduling
public class ApplicationService {

    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationService.class);
    private static long counter = LONG_ZERO;

    // Construtor com injeção de dependências, para não usar autowired.
    private final ProcessaService processaService;
    private final GravaService gravaService;
    private final LeituraService leituraService;
    private final RelatorioService relatorioService;

    @Scheduled(fixedRate = TAXA_LEITURA_mSEGUNDO)
    public void run() throws IOException {

        LOGGER.info(MSG_PROCESSAMENTO + counter++);

        // Serviço que cuida da parte de leitura do arquivo.
        // Foi criado um serviço específico para leitura, caso mais coisas
        // fossem adicionadas posteriormento ao projeto, como tratamento
        // de exceções e novas regras.
        List<Path> pathList = leituraService.buscarArquivo(DIRETORIO_LEITURA);

        // Serviço que filtra os dados lidos e separa de acordo com
        // cliente, vendedor ou venda, formando uma lista de cada tipo
        // Para posteriormente calcular os dados para o relatório.
        DataOutputDTO dataOutputDTO = processaService.processaArquivo(pathList);

        // Serviço para realizar os cálculos e montar os dados para o relatório.
        ResultadoDTO resultadoDTO = relatorioService.criaRelatorio(dataOutputDTO);

        // Serviço específico para gravar os dados no arquivo de saída.
        gravaService.gravaArquivo(resultadoDTO, DIRETORIO_ESCRITA);
    }
}
