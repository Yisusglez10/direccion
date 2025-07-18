package com.yisusglez.direccion.dto;

/**
 * Representa una dirección agrupada por CP.
 */
public class DireccionDTO {

    private String cp;
    private String estado;
    private String municipio;
    private String localidad;

    public DireccionDTO(String cp, String estado, String municipio, String localidad) {
        this.cp = cp;
        this.estado = estado;
        this.municipio = municipio;
        this.localidad = localidad;
    }

    public String getCp() {
        return cp;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getLocalidad() {
        return localidad;
    }
}
