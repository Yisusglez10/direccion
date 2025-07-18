package com.yisusglez.direccion.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa la llave compuesta de la entidad Municipio (clave, estado).
 */
@Embeddable
public class MunicipioId implements Serializable {
    private String clave;
    private String estado;

    public MunicipioId() {}

    public MunicipioId(String clave, String estado) {
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
        if (!(o instanceof MunicipioId)) return false;
        MunicipioId that = (MunicipioId) o;
        return Objects.equals(clave, that.clave) && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, estado);
    }
}
