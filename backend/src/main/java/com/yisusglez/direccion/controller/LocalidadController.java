package com.yisusglez.direccion.controller;

import com.yisusglez.direccion.dto.LocalidadDTO;
import com.yisusglez.direccion.model.Localidad;
import com.yisusglez.direccion.repository.LocalidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para obtener localidades por estado.
 */
@RestController
@RequestMapping("/api/localidades")
public class LocalidadController {

    private final LocalidadRepository localidadRepository;

    public LocalidadController(LocalidadRepository localidadRepository) {
        this.localidadRepository = localidadRepository;
    }

    /**
     * Retorna las localidades que pertenecen a un estado dado.
     * Ejemplo: /api/localidades?estado=JAL
     */
    @GetMapping
    public List<LocalidadDTO> obtenerLocalidadesPorEstado(@RequestParam String estado) {
        List<Localidad> localidades = localidadRepository.findByIdEstado(estado);
        return localidades.stream()
                .map(l -> new LocalidadDTO(l.getClave(), l.getDescripcion(), l.getEstado()))
                .collect(Collectors.toList());
    }
}
