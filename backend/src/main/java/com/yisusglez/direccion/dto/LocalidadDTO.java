package com.yisusglez.direccion.dto;

/**
 * Representa una localidad con su clave, descripción y estado.
 */
public class LocalidadDTO {

    private String clave;
    private String descripcion;
    private String estado;

    public LocalidadDTO(String clave, String descripcion, String estado) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }
}
