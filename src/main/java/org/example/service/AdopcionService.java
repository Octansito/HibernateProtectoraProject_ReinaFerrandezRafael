package org.example.service;


import org.example.dao.AdopcionDAO;
import org.example.dao.AdopcionDaoImpl;
import org.example.entity.Adopcion;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jakarta.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

/**
 * Clase que gestiona las adopciones del sistema.
 * Controla operaciones CRUD y consultas relacionadas con animales adoptados y filtros avanzados.
 */


public class AdopcionService {

    private final SessionFactory sf;
    private final AdopcionDAO dao;

    public AdopcionService() {
        this.sf = HibernateUtil.getSessionFactory();
        this.dao = new AdopcionDaoImpl();
    }

    public void save(Adopcion a) {
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

    public Optional<Adopcion>findById(Long id) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            Optional<Adopcion> result = dao.findById(s, id);
            tx.commit();
            return result;
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Adopcion>findAll() {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            List<Adopcion> list = dao.findAll(s);
            tx.commit();
            return list;
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void update(Adopcion a) {
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

    public void deleteById(Long id){
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.deleteById(s, id);
            tx.commit();
        }catch (PersistenceException e){
            if(tx != null) tx.rollback();
            throw e;
        }
    }

    public void delete(Adopcion a) {
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

    public boolean existsById(Long id) {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            boolean exists = dao.existsById(s, id);
            tx.commit();
            return exists;
        } catch (PersistenceException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public long count(){
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            long count = dao.count(s);
            tx.commit();
            return count;
        }catch (PersistenceException e){
            if (tx != null) tx.rollback();
            throw e;
        }
    }


    //JPQL 3
    public List<Adopcion>adopcionesConMasDe(int cantidad){
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            List<Adopcion> lista = dao.findConMasDe(s, cantidad);
            tx.commit();
            return lista;
        }catch (PersistenceException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
    }

    //Criteria 2
    public List<Adopcion> ordenarPorFecha() {
        Transaction tx = null;
        try {
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            List<Adopcion> lista = dao.findAdopcOrderByFecha(s);
            tx.commit();
            return lista;
        } catch (PersistenceException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        }
    }
}
