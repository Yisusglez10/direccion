package com.yisusglez.direccion.dto;

/**
 * DTO para recibir los datos que el usuario ingresa al formulario, con fines de validación.
 */
public class ValidacionDireccionDTO {

    private String estado;
    private String municipio;
    private String localidad;
    private String cp;

    public ValidacionDireccionDTO() {}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
}
