package com.prova.agibank.ProvaAgibankDeorgenes.service;

import com.prova.agibank.ProvaAgibankDeorgenes.DTO.ResultadoDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtilTest.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class GravaServiceTest {

    @Mock
    private GravaService gravaService;

    @Test
    public void testeGravarComSucesso() throws IOException {

        // Poderia ter usado builder, mas não tenho experiência em fazer assim.
        ResultadoDTO resultadoDTO =
                new ResultadoDTO(QTD_CLIENTES,QTD_VENDEDORES,ID_MAIOR_VENDA,NOME_PIOR_VENDEDOR);

        doNothing().when(gravaService).gravaArquivo(any(ResultadoDTO.class), anyString());

        gravaService.gravaArquivo(resultadoDTO, DIRETORIO_PADRAO);

        // Como o método retorna void, utiliza o verify para ter certeza que foi chamado.
        verify(gravaService).gravaArquivo(resultadoDTO, DIRETORIO_PADRAO);
    }

    @Test(expected = IOException.class)
    public void testeGravarComFalha() throws IOException {

        // Poderia ter usado builder, mas não tenho experiência em fazer assim.
        ResultadoDTO resultadoDTO =
                new ResultadoDTO(QTD_CLIENTES,QTD_VENDEDORES,ID_MAIOR_VENDA,NOME_PIOR_VENDEDOR);

        doThrow(IOException.class).when(gravaService).gravaArquivo(any(ResultadoDTO.class), anyString());

        gravaService.gravaArquivo(resultadoDTO, DIRETORIO_INVALIDO);
    }
}
