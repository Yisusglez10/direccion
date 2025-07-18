package com.yisusglez.direccion.repository;

import com.yisusglez.direccion.model.Colonia;
import com.yisusglez.direccion.model.ColoniaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para acceder a los datos de la tabla 'colonia'.
 * Permite buscar colonias asociadas a un código postal.
 */
@Repository
public interface ColoniaRepository extends JpaRepository<Colonia, ColoniaId> {
   /**
     * Busca todas las colonias que tienen el mismo código postal.
     */
    List<Colonia> findByIdCp(String cp);
}


