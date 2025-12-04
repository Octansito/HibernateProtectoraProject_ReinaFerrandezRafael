package org.example.dao;


import org.example.entity.Adopcion;
import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class AdopcionDaoImpl extends GenericDaoHibernate<Adopcion, Long> implements AdopcionDAO {

    public AdopcionDaoImpl() {
        super(Adopcion.class);
    }

    // JPQL 3: Adopciones con más de X animales
    @Override
    public List<Adopcion> findConMasDe(Session s, int cantidad) {

        String jpql = "SELECT ad FROM Adopcion ad JOIN ad.animales an GROUP BY ad HAVING COUNT(an) > :cantidad ";

        return s.createQuery(jpql, Adopcion.class)
                .setParameter("cantidad", cantidad)
                .list();
    }

    // Criteria 2: ordenar por fecha de adopción
    @Override
    public List<Adopcion> findAdopcOrderByFecha(Session s) {

        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Adopcion> cq = cb.createQuery(Adopcion.class);

        Root<Adopcion> root = cq.from(Adopcion.class);
        cq.orderBy(cb.desc(root.get("fechaAdopcion")));

        return s.createQuery(cq).list();
    }
}
