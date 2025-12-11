package org.example.dao;

import org.example.dto.AnimalAdopcionDTO;
import org.example.entity.Animal;
import org.hibernate.Session;

import java.util.List;
/**
 * Interfaz DAO que define las operaciones de acceso a datos para los animales,
 * incluyendo consultas personalizadas.
 */

public interface AnimalDAO extends GenericDAO<Animal, Long>{

    // JPQL 1: animales por nombre del adoptante
    List<AnimalAdopcionDTO> findAnimalByAdoptante(Session session, String nombre);

    // JPQL 2: animales atendidos por un voluntario
    List<Animal> findByVoluntario(Session session, String dni);

    // Criteria 1: ordenar animales por edad
    List<Animal> findAllOrderByEdad(Session session);

}
