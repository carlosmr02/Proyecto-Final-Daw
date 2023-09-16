package com.tiendaspring.tiendasp.controllers;

import com.tiendaspring.tiendasp.dao.PatineteDao;
import com.tiendaspring.tiendasp.models.Patinete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatineteController {

    @Autowired
    private PatineteDao patineteDao;

    @RequestMapping(value="/api/patinetes/{id}", method = RequestMethod.GET)
    public Patinete getPatinete(@PathVariable Long id){
        Patinete patinete=new Patinete();
        patinete.setId(id);
        patinete.setMarca("Xiaomi");
        patinete.setModelo("Pro");
        patinete.setAutonomia("20Km");
        return patinete;
    }
    @RequestMapping(value="api/patinetes", method = RequestMethod.GET)
    public List<Patinete> getPatinetes(){
        return patineteDao.getPatinetes();
    }

}
