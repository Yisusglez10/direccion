package com.yisusglez.direccion.model;

import jakarta.persistence.*;

/**
 * Entidad que representa una colonia asociada a un código postal.
 */
@Entity
@Table(name = "colonia")
public class Colonia {

    @EmbeddedId
    private ColoniaId id;

    @Column(name = "descripcion")
    private String descripcion;

    /**
     * Relación muchos a uno: muchas colonias pueden pertenecer al mismo código
     * postal.
     * Solo lectura.
     */
    @ManyToOne
    @JoinColumn(name = "cp", insertable = false, updatable = false)
    private CodigoPostal codigoPostal;

    public Colonia() {
    }

    public ColoniaId getId() {
        return id;
    }

    public void setId(ColoniaId id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CodigoPostal getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(CodigoPostal codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getClave() {
        return id != null ? id.getClave() : null;
    }

    public String getCp() {
        return id != null ? id.getCp() : null;
    }
}
