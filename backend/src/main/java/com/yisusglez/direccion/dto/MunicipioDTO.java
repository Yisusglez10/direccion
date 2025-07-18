package com.yisusglez.direccion.dto;

/**
 * Representa un municipio con su clave, descripción y clave de estado al que pertenece.
 */
public class MunicipioDTO {

    private String clave;
    private String descripcion;
    private String estado;

    public MunicipioDTO(String clave, String descripcion, String estado) {
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
