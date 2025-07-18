package com.yisusglez.direccion.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa la llave compuesta de la entidad Localidad (clave, estado).
 */
@Embeddable
public class LocalidadId implements Serializable {
    private String clave;
    private String estado;

    public LocalidadId() {}

    public LocalidadId(String clave, String estado) {
        this.clave = clave;
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocalidadId)) return false;
        LocalidadId that = (LocalidadId) o;
        return Objects.equals(clave, that.clave) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, estado);
    }
}
