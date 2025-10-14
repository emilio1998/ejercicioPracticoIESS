package com.iess.ejerciciopractico.modelsDTO;

import lombok.Data;

@Data
public class EditarClienteDTO {
    private String nombre;
    private String genero;
    private int edad;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private String estado;
}
