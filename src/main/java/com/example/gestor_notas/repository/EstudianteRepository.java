package com.example.gestor_notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestor_notas.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
