package org.example.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class GenericDaoHibernate <T, ID extends Serializable>
        implements GenericDAO<T, ID>  {

    private final Class<T> entityClass;


    public GenericDaoHibernate(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Optional<T> findById(Session s, ID id) {
        return Optional.ofNullable(s.find(entityClass, id));
    }

    @Override
    public List<T> findAll(Session s) {
        String hql = "from " + entityClass.getName();
        return s.createQuery(hql, entityClass).getResultList();
    }

    @Override
    public T saveNew(Session s, T entity) {
        s.persist(entity);
        s.flush();
        return entity;
    }

    @Override
    public T update(Session s, T entity) {
        return s.merge(entity);
    }

    @Override
    public boolean delete(Session s, T entity) {
        s.remove(entity);
        return true;
    }

    @Override
    public boolean deleteById(Session s, ID id) {
        T found = s.find(entityClass, id);
        if (found != null) {
            s.remove(found);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsById(Session s, ID id) {
        String hql = "select 1 from " + entityClass.getName() + " e where e.id = :id";
        Integer one = s.createQuery(hql, Integer.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .uniqueResult();
        return one != null;
    }

    @Override
    public long count(Session s) {
        String hql = "select count(e) from " + entityClass.getName() + " e";
        return s.createQuery(hql, Long.class).getSingleResult();
    }
}
