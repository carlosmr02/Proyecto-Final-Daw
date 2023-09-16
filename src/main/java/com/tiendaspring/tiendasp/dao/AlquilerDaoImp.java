package com.tiendaspring.tiendasp.dao;


import com.tiendaspring.tiendasp.models.Alquiler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AlquilerDaoImp implements AlquilerDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Alquiler> getAlquileres() {
        String query = "FROM Alquiler";
        if(entityManager==null) return new ArrayList<>();
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void alquilar(Alquiler alquiler) {
        entityManager.merge(alquiler);
    }

}
