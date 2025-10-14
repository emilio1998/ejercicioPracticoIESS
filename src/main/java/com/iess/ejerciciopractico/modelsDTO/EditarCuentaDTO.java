package com.iess.ejerciciopractico.modelsDTO;

import lombok.Data;

@Data
public class EditarCuentaDTO {
    private String numero_cuenta;
    private String tipo_cuenta;
    private float saldo_inicial;
    private String estado;
}
