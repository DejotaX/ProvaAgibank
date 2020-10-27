package com.prova.agibank.ProvaAgibankDeorgenes.service;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.HOMEPATH;

@NoArgsConstructor
@Service
public class LeituraService {

    private static Logger LOGGER = LoggerFactory.getLogger(LeituraService.class);

    public List<Path> buscarArquivo(String diretorio) throws IOException {
        List<Path> pathList = null;
        // Contando que o programa rode sempre com um arquivo presente.
        // Mas pode ser adicionada alguma forma de exception para arquivo
        // nao encontrado. Criei um laço para pegar todos os arquivos do
        // diretorio, que terminem com a extensao .dat.
        try {
            String env = System.getenv(HOMEPATH);
            Path path = Paths.get(env.concat(diretorio));

            pathList = Files.walk(path)
                    .map(x -> x.toString())
                    .filter(i -> i.endsWith(".dat"))
                    .map(x -> Path.of(x))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            LOGGER.info("Erro na leitura do arquivo. Verifique a pasta de origem");
        }

        return pathList;
    }
}
