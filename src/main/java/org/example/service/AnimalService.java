package org.example.service;

import org.example.dao.AnimalDAO;
import org.example.dao.AnimalDaoImpl;
import org.example.dto.AnimalAdopcionDTO;
import org.example.entity.Animal;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jakarta.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

/**
 * Clase responsable de gestionar animales en la base de datos.
 * Maneja transacciones, CRUD, consultas JPQL, Criteria
 */

public class AnimalService {

    private final SessionFactory sf;
    private final AnimalDAO dao;

    public AnimalService() {
        this.sf = HibernateUtil.getSessionFactory();
        this.dao = new AnimalDaoImpl();
    }

    public void save(Animal a) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.saveNew(s, a);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Optional<Animal> findById(Long id) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            Optional<Animal> result = dao.findById(s, id);
            tx.commit();
            return result;
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Animal> findAll() {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            List<Animal> result = dao.findAll(s);
            tx.commit();
            return result;
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void update(Animal a) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.update(s, a);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void deleteById(Long id) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.deleteById(s, id);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void delete(Animal a) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.delete(s, a);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void existsById(Long id) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.existsById(s, id);
            tx.commit();
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public long count() {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            long count = dao.count(s);
            tx.commit();
            return count;
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    //JPQL 1 con DTO
    public List<AnimalAdopcionDTO> buscarPorAdoptante(String nombre) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            List<AnimalAdopcionDTO> dto = dao.findAnimalByAdoptante(s, nombre);
            tx.commit();
            return dto;
        } catch (PersistenceException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
    }

    //JPQL 2
    public List<Animal> animalesPorVoluntario(String dni) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            List<Animal> lista = dao.findByVoluntario(s, dni);
            tx.commit();
            return lista;
        } catch (PersistenceException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
    }

    //Criteria 1
    public List<Animal> ordenarPorEdad() {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            List<Animal> lista = dao.findAllOrderByEdad(s);
            tx.commit();
            return lista;
        } catch (PersistenceException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
    }
}
