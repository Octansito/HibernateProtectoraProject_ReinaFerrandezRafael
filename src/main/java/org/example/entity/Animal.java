package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name="animal")
public class Animal {
    @Id
    private Long id;

    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private String tipo;
    @Column (nullable = false)
    private int edad;
    @Column (nullable = false)
    private String estado;
    @Column (nullable = false)
    private LocalDate fechaIngreso;

    // RELACIÓN N:1 → Un animal pertenece a una adopción
    @ManyToOne
    @JoinColumn(name = "id_adopcion")
    private Adopcion adopcion;

    /**
     * Lado inverso
     */
    // Muchos animales → muchos voluntarios
    @ManyToMany(mappedBy = "animales")
    private List<Voluntario> voluntarios;

    public Animal() {
    }

    public Animal(Long id, String nombre, String tipo, int edad, String estado, LocalDate fechaIngreso, Adopcion adopcion, List<Voluntario> voluntarios) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.adopcion = adopcion;
        this.voluntarios = voluntarios;
    }
    //getters and setters
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Adopcion getAdopcion() {
        return adopcion;
    }

    public void setAdopcion(Adopcion adopcion) {
        this.adopcion = adopcion;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(List<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }
}
