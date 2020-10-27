package com.prova.agibank.ProvaAgibankDeorgenes.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class VendedorDTO  implements Comparable<VendedorDTO>, Serializable {

    private static final long serialVersionUID = 1L;
    private final String nome;
    private final Double valorTotal;

    @Override
    public int compareTo(VendedorDTO obj) {
        // Ajustado para organizar de forma crescente.
        if (this.valorTotal > obj.getValorTotal()) {
            return 1;
        } if (this.valorTotal < obj.getValorTotal()) {
            return -1;
        }
        return 0;
    }
}
