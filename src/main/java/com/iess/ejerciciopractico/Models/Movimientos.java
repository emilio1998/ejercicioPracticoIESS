package com.iess.ejerciciopractico.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "MOVIMIENTOS")
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "FECHA_MOVIMIENTO", nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaMovimiento;

    @Column(name = "TIPO_MOVIMIENTO", nullable = false, length = 45)
    private String tipoMovimiento;

    @Column(name = "DETALLE_MOVIMIENTO", nullable = false, length = 255)
    private String detalle_movimiento;

    @Column(name = "VALOR", nullable = false)
    private Float valor;

    @Column(name = "SALDO", nullable = false)
    private Float saldo;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "ID_CUENTA",
        referencedColumnName = "ID",
        unique = true,
        nullable = false
    )
    private Cuenta cuenta;

    public Movimientos() {

    }

    public Movimientos(int id, LocalDateTime fechaMovimiento, String tipoMovimiento, String detalle_movimiento, Float valor, Float saldo, Cuenta cuenta) {
        this.id = id;
        this.fechaMovimiento = fechaMovimiento;
        this.tipoMovimiento = tipoMovimiento;
        this.detalle_movimiento = detalle_movimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public LocalDateTime getFechaMovimiento() {return fechaMovimiento;}

    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {this.fechaMovimiento = fechaMovimiento;}

    public String getTipoMovimiento() {return tipoMovimiento;}

    public void setTipoMovimiento(String tipoMovimiento) {this.tipoMovimiento = tipoMovimiento;}

    public String getDetalle_movimiento() {return detalle_movimiento;}

    public void setDetalle_movimiento(String detalle_movimiento) {this.detalle_movimiento = detalle_movimiento;}

    public Float getValor() {return valor;}

    public void setValor(Float valor) {this.valor = valor;}

    public Float getSaldo() {return saldo;}

    public void setSaldo(Float saldo) {this.saldo = saldo;}

    public Cuenta getCuenta() {return cuenta;}
    
    public void setCuenta(Cuenta cuenta) {this.cuenta = cuenta;}
}
