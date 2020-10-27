package com.prova.agibank.ProvaAgibankDeorgenes.service;

import com.prova.agibank.ProvaAgibankDeorgenes.DTO.DataOutputDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Cliente;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Item;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Venda;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Vendedor;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProcessaServiceTest {

    @Mock
    private ProcessaService processaService;

    @Test
    public void processaComSucesso(){

        DataOutputDTO dataOutputDTO = new DataOutputDTO();

        when(processaService.processaArquivo(anyList()))
                .thenReturn(new DataOutputDTO());

        dataOutputDTO
                = processaService.processaArquivo(new ArrayList<Path>());

        Assert.assertNotNull(dataOutputDTO);
    }

    @Test
    public void processaComFalhaArrayNulo(){

        DataOutputDTO dataOutputDTO = new DataOutputDTO();

        when(processaService.processaArquivo(anyList()))
                .thenReturn(new DataOutputDTO());

        dataOutputDTO
                = processaService.processaArquivo(null);

        Assert.assertNull(dataOutputDTO);
    }

    @Test(expected = NullPointerException.class)
    public void processaComFalhaNullPointer(){

        DataOutputDTO dataOutputDTO = new DataOutputDTO();

        when(processaService.processaArquivo(null))
                .thenThrow(NullPointerException.class);

        dataOutputDTO
                = processaService.processaArquivo(null);
    }
}
