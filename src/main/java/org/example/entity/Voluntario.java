package org.example.entity;

import jakarta.persistence.*;

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
}
