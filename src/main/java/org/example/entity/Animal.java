package org.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
/**
 * Entidad que representa un animal del refugio.
 * Incluye su información básica, su adopción (ManyToOne) y su relación con voluntarios.
 */

@Entity
@Table (name="animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private AnimalTipo tipo;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private AnimalEstado estado;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    // RELACIÓN N:1 --> Un animal pertenece a una adopción
    @ManyToOne
    @JoinColumn(name = "id_adopcion")
    private Adopcion adopcion;

    /**
     * Lado inverso
     */
    // Muchos animales --> muchos voluntarios
    @ManyToMany(mappedBy = "animales")
    private List<Voluntario> voluntarios;

    public Animal() {
    }

    public Animal(Long id, String nombre, AnimalTipo tipo, int edad, AnimalEstado estado, LocalDate fechaIngreso, Adopcion adopcion, List<Voluntario> voluntarios) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edad = edad;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.adopcion = adopcion;
        this.voluntarios = voluntarios;
    }
    //getters y setters
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

    public AnimalTipo getTipo() {
        return tipo;
    }

    public void setTipo(AnimalTipo tipo) {
        this.tipo = tipo;
    }

    public AnimalEstado getEstado() {
        return estado;
    }

    public void setEstado(AnimalEstado estado) {
        this.estado = estado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", edad=" + edad +
                ", estado=" + estado +
                ", fechaIngreso=" + fechaIngreso +
                ", adopcion=" + adopcion +
                '}';
    }
}
