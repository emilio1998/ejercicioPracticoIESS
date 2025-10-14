package com.iess.ejerciciopractico.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONA")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @Column(name = "IDENTIFICACION", length = 10)
    private String identificacion;

    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;

    @Column(name = "GENERO", nullable = false, length = 45)
    private String genero;

    @Column(name = "EDAD", nullable = false)
    private int edad;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "TELEFONO", length = 10)
    private String telefono;

    /* @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cuenta cuenta; */

    public Persona() {
    }

    public Persona(String nombre, String genero, int edad, String identificacion, String direccion, String telefono) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /* public Persona(String nombre, String genero, int edad, String identificacion, String direccion, String telefono, Cuenta cuenta) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuenta = cuenta;
    } */

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getGenero() {return genero;}

    public void setGenero(String genero) {this.genero = genero;}

    public int getEdad() {return edad;}

    public void setEdad(int edad) {this.edad = edad;}

    public String getIdentificacion() {return identificacion;}

    public void setIdentificacion(String identificacion) {this.identificacion = identificacion;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}
}
