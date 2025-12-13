package org.example.dao;

import org.example.dto.AnimalAdopcionDTO;
import org.example.entity.Animal;
import org.hibernate.Session;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

/**
 * Implementación del DAO de Animal.
 * Incluye consultas JPQL y Criteria específicas para animales.
 */


public class AnimalDaoImpl extends GenericDaoHibernate<Animal, Long> implements AnimalDAO {

    public AnimalDaoImpl() {
        super(Animal.class);
    }

    //JPQL 1: Animales por nombre del adoptante
    @Override
    public List<AnimalAdopcionDTO> findAnimalByAdoptante(Session s, String nombre) {

        String jpql = "SELECT new org.example.dto.AnimalAdopcionDTO(a.nombre, a.tipo, ad.nombreAdoptante, ad.fechaAdopcion) FROM Animal a JOIN a.adopcion ad WHERE ad.nombreAdoptante LIKE :nombre ";

        return s.createQuery(jpql, AnimalAdopcionDTO.class)
                .setParameter("nombre", "%" + nombre + "%")
                .list();
    }

    //JPQL 2: Animales atendidos por un voluntario
    @Override
    public List<Animal> findByVoluntario(Session s, String dni) {

        String jpql = "SELECT a FROM Animal a JOIN a.voluntarios v WHERE v.dni = :dni";

        return s.createQuery(jpql, Animal.class)
                .setParameter("dni", dni)
                .list();
    }

    //Criteria 1: ordenar animales por edad
    @Override
    public List<Animal> findAllOrderByEdad(Session s) {

        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Animal> cq = cb.createQuery(Animal.class);

        Root<Animal> root = cq.from(Animal.class);
        cq.orderBy(cb.asc(root.get("edad")));

        return s.createQuery(cq).list();
    }
}
