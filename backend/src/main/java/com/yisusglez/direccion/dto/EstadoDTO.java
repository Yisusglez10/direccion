package com.yisusglez.direccion.dto;

/**
 * Representa un estado con clave y nombre.
 */
public class EstadoDTO {

    private String clave;
    private String nombre;

    public EstadoDTO(String clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }
}
