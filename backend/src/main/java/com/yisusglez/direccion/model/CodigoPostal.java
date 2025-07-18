package com.yisusglez.direccion.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un código postal en México.
 */
@Entity
@Table(name = "codigo_postal")
public class CodigoPostal {

    @Id
    @Column(name = "cp")
    private String cp;

    @Column(name = "estado")
    private String estado;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "localidad")
    private String localidad;

    /**
     * Relación muchos a uno con Estado.
     */
    @ManyToOne
    @JoinColumn(name = "estado", insertable = false, updatable = false)
    private Estado estadoRef;

    /**
     * Relación muchos a uno con Municipio.
     */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "estado", referencedColumnName = "estado", insertable = false, updatable = false),
        @JoinColumn(name = "municipio", referencedColumnName = "clave", insertable = false, updatable = false)
    })
    private Municipio municipioRef;

    /**
     * Relación muchos a uno con Localidad.
     */
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "estado", referencedColumnName = "estado", insertable = false, updatable = false),
        @JoinColumn(name = "localidad", referencedColumnName = "clave", insertable = false, updatable = false)
    })
    private Localidad localidadRef;

    public CodigoPostal() {}

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

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

    public Estado getEstadoRef() {
        return estadoRef;
    }

    public Municipio getMunicipioRef() {
        return municipioRef;
    }

    public Localidad getLocalidadRef() {
        return localidadRef;
    }
}
