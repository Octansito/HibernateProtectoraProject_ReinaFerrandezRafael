package org.example.dto;

import org.example.entity.AnimalTipo;

import java.time.LocalDate;

public class AnimalAdopcionDTO {

    private String nombreAnimal;
    private AnimalTipo tipo;
    private String nombreAdoptante;
    private LocalDate fechaAdopcion;

    //Constructores
    public AnimalAdopcionDTO() {
    }

    public AnimalAdopcionDTO(String nombreAnimal, AnimalTipo tipo, String nombreAdoptante, LocalDate fechaAdopcion) {
        this.nombreAnimal = nombreAnimal;
        this.tipo = tipo;
        this.nombreAdoptante = nombreAdoptante;
        this.fechaAdopcion = fechaAdopcion;
    }

    //Getter y setters
    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public AnimalTipo getTipo() {
        return tipo;
    }

    public void setTipo(AnimalTipo tipo) {
        this.tipo = tipo;
    }

    public String getNombreAdoptante() {
        return nombreAdoptante;
    }

    public void setNombreAdoptante(String nombreAdoptante) {
        this.nombreAdoptante = nombreAdoptante;
    }

    public LocalDate getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(LocalDate fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }
}
