package com.example.gestor_notas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin; // Importar CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestor_notas.model.Estudiante;
import com.example.gestor_notas.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "http://localhost:3000") // Permitir CORS solo para este controlador
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteService.obtenerTodosLosEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id);
        if (estudiante != null) {
            return ResponseEntity.ok(estudiante);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.guardarEstudiante(estudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
