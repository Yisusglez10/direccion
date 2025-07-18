package com.yisusglez.direccion.model;

import jakarta.persistence.*;

/**
 * Entidad que representa un estado de la república.
 */
@Entity
@Table(name = "estado")
public class Estado {

    @Id
    private String clave;

    @Column(name = "pais")
    private String pais;

    @Column(name = "nombre_estado")
    private String nombreEstado;

    public Estado() {}

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
