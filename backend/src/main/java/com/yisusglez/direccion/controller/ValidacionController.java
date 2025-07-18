package com.yisusglez.direccion.controller;

import com.yisusglez.direccion.dto.ValidacionDireccionDTO;
import com.yisusglez.direccion.repository.CodigoPostalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para validar que los datos de dirección existan en los catálogos oficiales.
 */
@RestController
@RequestMapping("/api/validacion")
public class ValidacionController {

    private final CodigoPostalRepository codigoPostalRepository;

    public ValidacionController(CodigoPostalRepository codigoPostalRepository) {
        this.codigoPostalRepository = codigoPostalRepository;
    }

    /**
     * Recibe un DTO con estado, municipio, localidad y cp, y valida si existe esa combinación.
     */
    @PostMapping
    public ResponseEntity<?> validarDireccion(@RequestBody ValidacionDireccionDTO dto) {
        boolean existe = codigoPostalRepository.existsByCpAndEstadoAndMunicipioAndLocalidad(
                dto.getCp(), dto.getEstado(), dto.getMunicipio(), dto.getLocalidad());

        if (existe) {
            return ResponseEntity.ok().body("Dirección válida");
        } else {
            return ResponseEntity.badRequest().body("La dirección no existe");
        }
    }
}
