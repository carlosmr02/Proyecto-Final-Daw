package com.tiendaspring.tiendasp.controllers;


import com.tiendaspring.tiendasp.dao.AlquilerDao;
import com.tiendaspring.tiendasp.dao.PatineteDao;
import com.tiendaspring.tiendasp.dao.UsuarioDao;
import com.tiendaspring.tiendasp.models.Alquiler;
import com.tiendaspring.tiendasp.models.Patinete;
import com.tiendaspring.tiendasp.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlquilerController {

    @Autowired
    private AlquilerDao alquilerDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PatineteDao patineteDao;

    @RequestMapping(value="api/alquileres", method = RequestMethod.GET)
    public List<Alquiler> getAlquileres(){
        return alquilerDao.getAlquileres();
    }

    @RequestMapping(value="api/alquileres", method = RequestMethod.POST)
    public void registraAlquiler(@RequestBody Alquiler alquiler){
        // Obtener el usuario y el patinete seleccionados por su ID
        Usuario usuario = usuarioDao.obtenerUsuarioPorId(alquiler.getUsuario().getId());
        Patinete patinete = patineteDao.obtenerPatinetePorId(alquiler.getPatinete().getId());

        // Asignar el usuario y el patinete al alquiler
        alquiler.setUsuario(usuario);
        alquiler.setPatinete(patinete);

        alquilerDao.alquilar(alquiler);
        //alquilerDao.alquilar(alquiler);
    }

}
