package com.yisusglez.direccion.controller;

import com.yisusglez.direccion.dto.MunicipioDTO;
import com.yisusglez.direccion.model.Municipio;
import com.yisusglez.direccion.repository.MunicipioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para obtener municipios por estado.
 */
@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

    private final MunicipioRepository municipioRepository;

    public MunicipioController(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    /**
     * Retorna municipios pertenecientes a un estado dado.
     * Ejemplo: /api/municipios?estado=JAL
     */
    @GetMapping
    public List<MunicipioDTO> obtenerMunicipiosPorEstado(@RequestParam String estado) {
        List<Municipio> municipios = municipioRepository.findByIdEstado(estado);
        return municipios.stream()
                .map(m -> new MunicipioDTO(m.getClave(), m.getDescripcion(), m.getEstado()))
                .collect(Collectors.toList());
    }
}
