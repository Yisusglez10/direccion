package com.yisusglez.direccion.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un municipio dentro de un estado.
 */
@Entity
@Table(name = "municipio")
public class Municipio {

    @EmbeddedId
    private MunicipioId id;

    @Column(name = "descripcion")
    private String descripcion;

    /**
     * Relación muchos a uno: muchos municipios pertenecen a un estado.
     * Esta relación es solo de lectura (no se usa para insertar/modificar desde aquí).
     */
    @ManyToOne
    @JoinColumn(name = "estado", insertable = false, updatable = false)
    private Estado estadoRef;

    public Municipio() {}

    public MunicipioId getId() {
        return id;
    }

    public void setId(MunicipioId id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstadoRef() {
        return estadoRef;
    }

    public void setEstadoRef(Estado estadoRef) {
        this.estadoRef = estadoRef;
    }

    public String getClave() {
        return id != null ? id.getClave() : null;
    }

    public String getEstado() {
        return id != null ? id.getEstado() : null;
    }

}
