package com.example.gestor_notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestor_notas.model.Notas;

public interface NotasRepository extends JpaRepository<Notas, Long> {
}

