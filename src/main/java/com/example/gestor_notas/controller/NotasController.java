package com.example.gestor_notas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestor_notas.model.Notas;
import com.example.gestor_notas.service.NotasService;

@RestController
@RequestMapping("/api/notas")
public class NotasController {

    private final NotasService notasService;

    @Autowired
    public NotasController(NotasService notasService) {
        this.notasService = notasService;
    }

    @GetMapping
    public List<Notas> obtenerTodasLasNotas() {
        return notasService.obtenerTodasLasNotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notas> obtenerNotasPorId(@PathVariable Long id) {
        Notas notas = notasService.obtenerNotasPorId(id);
        if (notas != null) {
            return ResponseEntity.ok(notas);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Notas crearNotas(@RequestBody Notas notas) {
        return notasService.guardarNotas(notas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotas(@PathVariable Long id) {
        notasService.eliminarNotas(id);
        return ResponseEntity.noContent().build();
    }
}
