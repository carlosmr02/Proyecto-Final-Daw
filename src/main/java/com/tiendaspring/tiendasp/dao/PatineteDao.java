package com.tiendaspring.tiendasp.dao;

import com.tiendaspring.tiendasp.models.Patinete;

import java.util.List;

public interface PatineteDao {

    List<Patinete> getPatinetes();

    Patinete obtenerPatinetePorId(Long id);

}
