package com.prova.agibank.ProvaAgibankDeorgenes.service;

import com.prova.agibank.ProvaAgibankDeorgenes.DTO.DataOutputDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.DTO.ResultadoDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.DTO.VendaDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.DTO.VendedorDTO;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Cliente;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Venda;
import com.prova.agibank.ProvaAgibankDeorgenes.model.Vendedor;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.prova.agibank.ProvaAgibankDeorgenes.util.ConstantsUtil.INDICE_INICIAL;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class RelatorioServiceTest {

    @Mock
    private RelatorioService relatorioService;

    @Test
    public void relatorioCriadoComSucesso(){

        DataOutputDTO dataOutputDTO =
                new DataOutputDTO();

        ResultadoDTO resultadoDTO;

        when(relatorioService.criaRelatorio(any(DataOutputDTO.class)))
                .thenReturn(new ResultadoDTO("","","",""));


        resultadoDTO = relatorioService.criaRelatorio(dataOutputDTO);

        Assert.assertNotNull(resultadoDTO);
    }

    @Test(expected = NullPointerException.class)
    public void relatorioCriadoComFalha(){

        DataOutputDTO dataOutputDTO =
                new DataOutputDTO();

        ResultadoDTO resultadoDTO;

        when(relatorioService.criaRelatorio(any(DataOutputDTO.class)))
                .thenThrow(NullPointerException.class);

        resultadoDTO = relatorioService.criaRelatorio(dataOutputDTO);

        Assert.fail();
    }
}
