package com.example.gestor_notas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private int actividades;
    private int primerParcial;
    private int segundoParcial;
    private int examenFinal;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getActividades() {
        return actividades;
    }

    public void setActividades(int actividades) {
        this.actividades = actividades;
    }

    public int getPrimerParcial() {
        return primerParcial;
    }

    public void setPrimerParcial(int primerParcial) {
        this.primerParcial = primerParcial;
    }

    public int getSegundoParcial() {
        return segundoParcial;
    }

    public void setSegundoParcial(int segundoParcial) {
        this.segundoParcial = segundoParcial;
    }

    public int getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(int examenFinal) {
        this.examenFinal = examenFinal;
    }
}
