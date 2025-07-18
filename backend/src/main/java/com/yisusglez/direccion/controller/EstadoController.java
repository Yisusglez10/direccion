package com.yisusglez.direccion.controller;

import com.yisusglez.direccion.dto.EstadoDTO;
import com.yisusglez.direccion.model.Estado;
import com.yisusglez.direccion.repository.EstadoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para obtener todos los estados disponibles.
 */
@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    private final EstadoRepository estadoRepository;

    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    /**
     * Retorna una lista de todos los estados con clave y nombre.
     */
    @GetMapping
    public List<EstadoDTO> obtenerEstados() {
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream()
                .map(e -> new EstadoDTO(e.getClave(), e.getNombreEstado()))
                .collect(Collectors.toList());
    }
}
