package com.yisusglez.direccion.controller;

import com.yisusglez.direccion.dto.DireccionDTO;
import com.yisusglez.direccion.model.CodigoPostal;
import com.yisusglez.direccion.repository.CodigoPostalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador para obtener la dirección completa (estado, municipio, localidad) a partir de un código postal.
 */
@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

    private final CodigoPostalRepository codigoPostalRepository;

    public DireccionController(CodigoPostalRepository codigoPostalRepository) {
        this.codigoPostalRepository = codigoPostalRepository;
    }

    /**
     * Devuelve estado, municipio y localidad asociadas al código postal.
     * Ejemplo: /api/direccion?cp=44100
     */
    @GetMapping
    public DireccionDTO obtenerDireccionPorCp(@RequestParam String cp) {
        Optional<CodigoPostal> resultado = codigoPostalRepository.findById(cp);
        return resultado
                .map(c -> new DireccionDTO(c.getCp(), c.getEstado(), c.getMunicipio(), c.getLocalidad()))
                .orElse(null); // O puedes devolver ResponseEntity.notFound().build()
    }
}
