package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

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

}
