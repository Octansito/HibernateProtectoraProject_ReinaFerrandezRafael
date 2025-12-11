package org.example.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Entidad que representa a un voluntario del refugio.
 * Incluye sus datos personales y la relación ManyToMany con los animales que atiende.
 */

@Entity
@Table(name="voluntario")
public class Voluntario {


    @Id
    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private VoluntarioRol rol;

    @Column(name = "antiguedad", nullable = false)
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
    private List<Animal> animales=new ArrayList<>();

    public Voluntario() {}

    public Voluntario(String dni, String nombre, String telefono, VoluntarioRol rol, int antiguedad, List<Animal> animales) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.rol = rol;
        this.antiguedad = antiguedad;
        this.animales =animales;
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

    public VoluntarioRol getRol() {
        return rol;
    }

    public void setRol(VoluntarioRol rol) {
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

    @Override
    public String toString() {
        return "Voluntario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol=" + rol +
                ", antiguedad=" + antiguedad +
                ", animales=" + animales +
                '}';
    }
}
