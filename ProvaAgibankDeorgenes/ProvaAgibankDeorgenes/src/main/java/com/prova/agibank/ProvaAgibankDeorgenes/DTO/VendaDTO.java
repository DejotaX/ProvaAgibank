package com.prova.agibank.ProvaAgibankDeorgenes.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class VendaDTO  implements Comparable<VendaDTO>, Serializable {

    private static final long serialVersionUID = 1L;
    private final int id;
    private final Double valorTotal;

    @Override
    public int compareTo(VendaDTO obj) {
        // Ajustado para organizar de forma decrescente.
        if (this.valorTotal > obj.getValorTotal()) {
            return -1;
        } if (this.valorTotal < obj.getValorTotal()) {
            return 1;
        }
        return 0;
    }
}
