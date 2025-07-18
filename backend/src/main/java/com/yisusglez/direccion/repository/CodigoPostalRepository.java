package com.yisusglez.direccion.repository;

import com.yisusglez.direccion.model.CodigoPostal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para consultar combinaciones de CP, estado, municipio y localidad.
 */
public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, String> {

    /**
     * Verifica si existe una entrada con los valores exactos recibidos.
     * Utilizado en el controlador de validación para asegurar que los datos
     * seleccionados por el usuario son válidos según el catálogo oficial.
     */
    boolean existsByCpAndEstadoAndMunicipioAndLocalidad(
        String cp,
        String estado,
        String municipio,
        String localidad
    );
}
