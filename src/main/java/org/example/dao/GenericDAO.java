package org.example.dao;

import org.hibernate.Session;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID extends Serializable> {

    Optional<T> findById(Session s, ID id);

    List<T> findAll(Session s);

    T saveNew(Session s, T entity);

    T update(Session s, T entity);

    boolean deleteById(Session s, ID id);

    boolean delete(Session s, T entity);

    boolean existsById(Session s, ID id);

    long count(Session s);
}
