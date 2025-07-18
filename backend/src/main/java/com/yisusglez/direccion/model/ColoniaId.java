package com.yisusglez.direccion.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Representa la llave compuesta de la entidad Colonia (clave, cp).
 */
@Embeddable
public class ColoniaId implements Serializable {
    private String clave;
    private String cp;

    public ColoniaId() {}

    public ColoniaId(String clave, String cp) {
        this.clave = clave;
        this.cp = cp;
    }

    public String getClave() {
        return clave;
    }

    public String getCp() {
        return cp;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoniaId)) return false;
        ColoniaId that = (ColoniaId) o;
        return Objects.equals(clave, that.clave) && Objects.equals(cp, that.cp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, cp);
    }
}
