package com.iess.ejerciciopractico.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "CUENTA")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "NUMERO_CUENTA", nullable = false, length = 55)
    private String numero_cuenta;

    @Column(name = "TIPO_CUENTA", nullable = false, length = 45)
    private String tipo_cuenta;

    @Column(name = "SALDO_INICIAL", nullable = false)
    private float saldo_inicial;

    @Column(name = "ESTADO", nullable = false, length = 25)
    private String estado;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "IDENTIFICACION",              // FK en CUENTA
        referencedColumnName = "IDENTIFICACION", // PK en PERSONA
        unique = true,
        nullable = false
    )
    private Persona persona;

    public Cuenta() {
    }

    public Cuenta(int id, String numero_cuenta, String tipo_cuenta, float saldo_inicial, String estado, Persona persona) {
        this.id = id;
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo_inicial = saldo_inicial;
        this.estado = estado;
        this.persona = persona;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNumero_cuenta() {return numero_cuenta;}
    
    public void setNumero_cuenta(String numero_cuenta) {this.numero_cuenta = numero_cuenta;}

    public String getTipo_cuenta() {return tipo_cuenta;}

    public void setTipo_cuenta(String tipo_cuenta) {this.tipo_cuenta = tipo_cuenta;}

    public float getSaldo_inicial() {return saldo_inicial;}

    public void setSaldo_inicial(float saldo_inicial) {this.saldo_inicial = saldo_inicial;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public Persona getPersona() {return persona;}

    public void setPersona(Persona persona) {this.persona = persona;}
}
