package com.example.gestor_notas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestor_notas.model.Notas;
import com.example.gestor_notas.repository.NotasRepository;

@Service
public class NotasService {

    private final NotasRepository notasRepository;

    @Autowired
    public NotasService(NotasRepository notasRepository) {
        this.notasRepository = notasRepository;
    }

    public List<Notas> obtenerTodasLasNotas() {
        return notasRepository.findAll();
    }

    public Notas obtenerNotasPorId(Long id) {
        return notasRepository.findById(id).orElse(null);
    }

    public Notas guardarNotas(Notas notas) {
        notas.setTotal(calcularTotal(notas)); // Calculamos el total antes de guardar
        return notasRepository.save(notas);
    }

    public void eliminarNotas(Long id) {
        notasRepository.deleteById(id);
    }

    private int calcularTotal(Notas notas) {
        return notas.getActividades() + notas.getPrimerParcial() + 
               notas.getSegundoParcial() + notas.getExamenFinal();
    }
}
