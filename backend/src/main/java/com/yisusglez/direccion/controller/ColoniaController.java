package com.yisusglez.direccion.controller;

import com.yisusglez.direccion.dto.ColoniaDTO;
import com.yisusglez.direccion.model.Colonia;
import com.yisusglez.direccion.repository.ColoniaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para obtener colonias asociadas a un código postal.
 */
@RestController
@RequestMapping("/api/colonias")
public class ColoniaController {

    private final ColoniaRepository coloniaRepository;

    public ColoniaController(ColoniaRepository coloniaRepository) {
        this.coloniaRepository = coloniaRepository;
    }

    /**
     * Retorna las colonias asociadas al código postal dado.
     * Ejemplo: /api/colonias?cp=44100
     */
    @GetMapping
    public List<ColoniaDTO> obtenerColoniasPorCP(@RequestParam String cp) {
        List<Colonia> colonias = coloniaRepository.findByIdCp(cp);
        return colonias.stream()
                .map(col -> new ColoniaDTO(
                        col.getClave(),
                        col.getCp(),
                        col.getDescripcion()))
                .collect(Collectors.toList());
    }
}
