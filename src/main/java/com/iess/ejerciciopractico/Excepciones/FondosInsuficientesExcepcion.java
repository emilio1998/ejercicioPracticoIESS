package com.iess.ejerciciopractico.Excepciones;

public class FondosInsuficientesExcepcion extends RuntimeException{
    public FondosInsuficientesExcepcion(String mensaje) {
        super(mensaje);
    }
}
