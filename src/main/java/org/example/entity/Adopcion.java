package org.example.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
/**
 * Entidad que modela una adopción realizada en el refugio.
 * Contiene los datos del adoptante y la lista de animales asociados a la adopción.
 */

@Entity
@Table (name="adopcion")
public class Adopcion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adopcion")
    private Long id;

    @Column(name = "nombre_adoptante", nullable = false)
    private String nombreAdoptante;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "fecha_adopcion", nullable = false)
    private LocalDate fechaAdopcion;

    @Column(name = "direccion", nullable = false)
    private String direccion;




    // RELACIÓN 1:N → Una adopción tiene muchos animales
    @OneToMany(mappedBy = "adopcion")
    private List<Animal> animales;

    public Adopcion() {
    }

    public Adopcion(Long id, List<Animal> animales, String direccion, LocalDate fechaAdopcion, String telefono, String nombreAdoptante) {
        this.id = id;
        this.animales = animales;
        this.direccion = direccion;
        this.fechaAdopcion = fechaAdopcion;
        this.telefono = telefono;
        this.nombreAdoptante = nombreAdoptante;
    }
    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Adopcion{" +
                "id=" + id +
                ", nombreAdoptante='" + nombreAdoptante + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaAdopcion=" + fechaAdopcion +
                ", direccion='" + direccion +
                '}';
    }
}
