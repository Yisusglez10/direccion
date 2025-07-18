package com.yisusglez.direccion.repository;

import com.yisusglez.direccion.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para acceder a los datos de la tabla 'estado'.
 * Hereda de JpaRepository para obtener métodos como findAll(), findById(), etc.
 */
public interface EstadoRepository extends JpaRepository<Estado, String> {}
