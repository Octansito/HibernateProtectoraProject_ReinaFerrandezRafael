package org.example.dao;

import org.example.entity.Adopcion;
import org.hibernate.Session;
import java.util.List;
/**
 * Interfaz DAO para gestionar adopciones.
 * Define métodos CRUD y consultas específicas de adopción.
 */

public interface AdopcionDAO extends GenericDAO<Adopcion, Long> {

    // JPQL 3: adopciones con más de X animales
    List<Adopcion> findConMasDe(Session session, int cantidad);

    // Criteria 2: ordenar adopciones por fecha
    List<Adopcion> findAdopcOrderByFecha(Session session);
}
