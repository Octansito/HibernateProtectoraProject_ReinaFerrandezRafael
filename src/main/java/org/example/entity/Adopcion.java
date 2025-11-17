package org.example.entity;

import com.sun.jdi.StringReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name="adopcion")
public class Adopcion {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nombreAdoptante;
    @Column (nullable = false)
    private String telefono;
    @Column (nullable = false)
    private LocalDate fechaAdopcion;
    @Column (nullable = false)
    private String direccion;



    @OneToMany
    @JoinColumn (name="id_animal")
    private Animal idAnimal;

}
