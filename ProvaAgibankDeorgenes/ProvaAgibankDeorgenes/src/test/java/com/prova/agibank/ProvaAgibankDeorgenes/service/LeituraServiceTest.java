package com.prova.agibank.ProvaAgibankDeorgenes.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class LeituraServiceTest {

    @Mock
    private LeituraService leituraService;

    @Test
    public void testarArquivoEncontrado() throws IOException {

        when(leituraService.buscarArquivo(anyString())).thenReturn( new ArrayList<Path>());

        List<Path> pathList = leituraService.buscarArquivo("");

        Assert.assertNotNull(pathList);
    }

    @Test(expected = FileNotFoundException.class)
    public void testarArquivoNaoEncontrado() throws IOException {

        when(leituraService.buscarArquivo(anyString()))
                .thenThrow(FileNotFoundException.class);

        leituraService.buscarArquivo("");

        Assert.fail();
    }
}
