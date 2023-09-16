package com.tiendaspring.tiendasp.dao;

import com.tiendaspring.tiendasp.models.Alquiler;
import com.tiendaspring.tiendasp.models.Usuario;

import java.util.List;

public interface AlquilerDao {

    List<Alquiler> getAlquileres();

    void alquilar(Alquiler alquiler);

}
