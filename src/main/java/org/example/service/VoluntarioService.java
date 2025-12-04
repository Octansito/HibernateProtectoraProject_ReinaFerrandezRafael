package org.example.service;

import org.example.dao.VoluntarioDAO;
import org.example.dao.VoluntarioDaoImpl;
import org.example.entity.Voluntario;
import org.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

public class VoluntarioService{

    private final SessionFactory sf;
    private final VoluntarioDAO dao;

    public VoluntarioService(){
        this.sf = HibernateUtil.getSessionFactory();
        this.dao = new VoluntarioDaoImpl();
    }

    public void save(Voluntario v){
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.saveNew(s, v);
            tx.commit();
        }catch (PersistenceException e){
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Optional<Voluntario>findById(String dni){
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            Optional<Voluntario> res = dao.findById(s, dni);
            tx.commit();
            return res;
        }catch (PersistenceException e){
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Voluntario>findAll(){
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            List<Voluntario> lista = dao.findAll(s);
            tx.commit();
            return lista;
        }catch (PersistenceException e){
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void update(Voluntario v){
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.update(s, v);
            tx.commit();
        }catch (PersistenceException e){
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void deleteById(String dni){
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.deleteById(s, dni);
            tx.commit();

        }catch (PersistenceException e){
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void delete(Voluntario v){
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.delete(s, v);
            tx.commit();

        }catch (PersistenceException e){
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void existsById(String dni) {
        Transaction tx = null;
        try{
            Session s = sf.getCurrentSession();
            tx = s.beginTransaction();
            dao.existsById(s, dni);
            tx.commit();

        }catch (PersistenceException e){
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

}
