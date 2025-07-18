package com.yisusglez.direccion.repository;

import com.yisusglez.direccion.model.Municipio;
import com.yisusglez.direccion.model.MunicipioId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para acceder a los municipios.
 * Provee métodos CRUD y uno personalizado para filtrar por estado.
 */
public interface MunicipioRepository extends JpaRepository<Municipio, MunicipioId> {

    /**
     * Busca todos los municipios que pertenecen al estado dado.
     * Esto es necesario para el endpoint /api/municipios?estado=JAL
     */
    List<Municipio> findByIdEstado(String estado);
}
