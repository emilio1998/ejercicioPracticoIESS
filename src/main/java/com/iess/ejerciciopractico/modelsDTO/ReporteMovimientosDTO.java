package com.iess.ejerciciopractico.modelsDTO;

import lombok.Data;

@Data
public class ReporteMovimientosDTO {
    public String fechaMovimiento;
    public String cliente;
    public String numeroCuenta;
    public String tipo;
    public String tipoMovimiento;
    public float saldoInicial;
    public String estado;
    public float movimiento;
    public float saldoDisponible;
}
