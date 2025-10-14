package com.iess.ejerciciopractico.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTE")
@PrimaryKeyJoinColumn(name = "IDENTIFICACION", referencedColumnName = "IDENTIFICACION")
public class Cliente extends Persona{
    @Column(name = "CONTRASENIA", nullable = false)
    private String contrasenia;

    @Column(name = "ESTADO", nullable = false, length = 25)
    private String estado;

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String genero, int edad, String identificacion, String direccion, String telefono, String contrasenia, String estado) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public String getContrasenia() {return contrasenia;}

    public void setContrasenia(String contrasenia) {this.contrasenia = contrasenia;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}
}
