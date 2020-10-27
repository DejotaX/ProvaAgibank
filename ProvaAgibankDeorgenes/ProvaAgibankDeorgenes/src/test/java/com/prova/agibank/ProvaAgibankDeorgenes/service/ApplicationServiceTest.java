package com.prova.agibank.ProvaAgibankDeorgenes.service;

import com.prova.agibank.ProvaAgibankDeorgenes.DTO.DataOutputDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.DTO.ResultadoDTO;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.DIRETORIO_ESCRITA;
import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.DIRETORIO_LEITURA;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class ApplicationServiceTest {

    @Mock
    private ApplicationService applicationService;

    @Mock
    private LeituraService leituraService;

    @Mock
    private ProcessaService processaService;

    @Mock
    private GravaService gravaService;

    @Mock
    private RelatorioService relatorioService;

    @Test
    public void aplicacaoExecutadaComSucesso() throws IOException {

        when(leituraService.buscarArquivo(anyString())).thenReturn(new ArrayList<Path>());

        when(processaService.processaArquivo(anyList())).thenReturn(new DataOutputDTO());

        when(relatorioService.criaRelatorio(any(DataOutputDTO.class)))
                .thenReturn(new ResultadoDTO("","","",""));

        doNothing().when(gravaService).gravaArquivo(any(ResultadoDTO.class), anyString());

        applicationService.run();

        verify(applicationService).run();
    }

    @Test(expected = IOException.class)
    public void aplicacaoExecutadaComIOException() throws IOException{

        when(leituraService.buscarArquivo(anyString())).thenReturn(new ArrayList<Path>());

        when(processaService.processaArquivo(anyList())).thenReturn(new DataOutputDTO());

        when(relatorioService.criaRelatorio(any(DataOutputDTO.class)))
                .thenReturn(new ResultadoDTO("","","",""));

        doNothing().when(gravaService).gravaArquivo(any(ResultadoDTO.class), anyString());

        doThrow(IOException.class).when(applicationService).run();

        applicationService.run();

        verify(applicationService).run();
    }

    @Test(expected = NullPointerException.class)
    public void aplicacaoExecutadaComNullPointer() throws NullPointerException, IOException {

        when(leituraService.buscarArquivo(anyString())).thenReturn(new ArrayList<Path>());

        when(processaService.processaArquivo(anyList())).thenReturn(new DataOutputDTO());

        when(relatorioService.criaRelatorio(any(DataOutputDTO.class)))
                .thenReturn(new ResultadoDTO("","","",""));

        doNothing().when(gravaService).gravaArquivo(any(ResultadoDTO.class), anyString());

        doThrow(NullPointerException.class).when(applicationService).run();

        applicationService.run();

        verify(applicationService).run();
    }
}
