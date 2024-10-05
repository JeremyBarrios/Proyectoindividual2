package com.example.gestor_notas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestor_notas.model.Estudiante;
import com.example.gestor_notas.repository.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}

