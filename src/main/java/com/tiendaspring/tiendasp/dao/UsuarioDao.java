package com.tiendaspring.tiendasp.dao;

import com.tiendaspring.tiendasp.models.Usuario;

import java.util.List;
public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminarUsuario(Long id);

    void registrar(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);

    Usuario obtenerUsuarioPorId(Long id);
}
