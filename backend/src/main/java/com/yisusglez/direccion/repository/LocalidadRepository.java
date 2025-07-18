package com.yisusglez.direccion.repository;

import com.yisusglez.direccion.model.Localidad;
import com.yisusglez.direccion.model.LocalidadId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para acceder a las localidades.
 * Incluye un método personalizado para filtrar por estado.
 */
public interface LocalidadRepository extends JpaRepository<Localidad, LocalidadId> {

    /**
     * Busca todas las localidades asociadas a un estado específico.
     * Usado en el endpoint /api/localidades?estado=JAL
     */
    List<Localidad> findByIdEstado(String estado);
}
