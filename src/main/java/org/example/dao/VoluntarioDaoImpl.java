package org.example.dao;

import org.example.entity.Voluntario;

public class VoluntarioDaoImpl extends GenericDaoHibernate<Voluntario, String> implements VoluntarioDAO {

    public VoluntarioDaoImpl() {
        super(Voluntario.class);
    }
}
