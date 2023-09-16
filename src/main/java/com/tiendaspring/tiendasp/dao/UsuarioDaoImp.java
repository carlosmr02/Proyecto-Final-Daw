package com.tiendaspring.tiendasp.dao;

import com.tiendaspring.tiendasp.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional

public class UsuarioDaoImp implements com.tiendaspring.tiendasp.dao.UsuarioDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        if(entityManager==null) return new ArrayList<>();
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario=entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }


    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query="FROM Usuario where email=:email and password=:password";
        List<Usuario> lista=entityManager.createQuery(query,Usuario.class)
                .setParameter("email",usuario.getEmail())
                .setParameter("password",usuario.getPassword())
                .getResultList();

        return !lista.isEmpty();

    }

}
