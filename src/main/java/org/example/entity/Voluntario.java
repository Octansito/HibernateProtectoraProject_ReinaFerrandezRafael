package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="voluntario")
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dni;

    @Column (nullable = false)
    private String nombre;
    @Column (nullable = false)
    private String telefono;
    @Column (nullable = false)
    private String rol;
    @Column (nullable = false)
    private int antiguedad;

    /**
     * Definimos en la entidad Voluntario la tabla intermedia (lado propietario)
     */
    @ManyToMany
    @JoinTable(
            name = "voluntario_animal",
            joinColumns = @JoinColumn(name = "dni_voluntario"),
            inverseJoinColumns = @JoinColumn(name = "id_animal")
    )
    private List<Animal> animales;

    public Voluntario() {}

    public Voluntario(String dni, String nombre, String telefono, String rol, int antiguedad, List<Animal> animales) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.rol = rol;
        this.antiguedad = antiguedad;
        this.animales = animales;
    }
    //getters y setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }
}
