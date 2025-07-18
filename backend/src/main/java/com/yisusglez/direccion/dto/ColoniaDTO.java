package com.yisusglez.direccion.dto;

/**
 * Representa una colonia con clave, código postal y nombre.
 */
public class ColoniaDTO {

    private String clave;
    private String cp;
    private String descripcion;

    public ColoniaDTO(String clave, String cp, String descripcion) {
        this.clave = clave;
        this.cp = cp;
        this.descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public String getCp() {
        return cp;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
