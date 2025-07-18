package com.yisusglez.direccion.model;

import jakarta.persistence.*;

/**
 * Entidad que representa una localidad dentro de un estado.
 */
@Entity
@Table(name = "localidad")
public class Localidad {

    @EmbeddedId
    private LocalidadId id;

    @Column(name = "descripcion")
    private String descripcion;

    /**
     * Relación muchos a uno con estado (solo lectura).
     */
    @ManyToOne
    @JoinColumn(name = "estado", insertable = false, updatable = false)
    private Estado estadoRef;

    public Localidad() {}

    public LocalidadId getId() {
        return id;
    }

    public void setId(LocalidadId id) {
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
