package com.tiendaspring.tiendasp.dao;


import com.tiendaspring.tiendasp.models.Patinete;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PatineteDaoImp implements PatineteDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Patinete> getPatinetes() {
        String query = "FROM Patinete";
        if(entityManager==null) return new ArrayList<>();
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Patinete obtenerPatinetePorId(Long id) {
        return entityManager.find(Patinete.class, id);
    }

}
