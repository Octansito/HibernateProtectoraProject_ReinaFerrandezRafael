package org.example.dao;

import org.example.entity.Voluntario;
/**
 * Implementación de VoluntarioDAO que usa Hibernate para realizar
 * operaciones CRUD y consultas personalizadas sobre voluntarios.
 */

public class VoluntarioDaoImpl extends GenericDaoHibernate<Voluntario, String> implements VoluntarioDAO {

    public VoluntarioDaoImpl() {
        super(Voluntario.class);
    }
}
