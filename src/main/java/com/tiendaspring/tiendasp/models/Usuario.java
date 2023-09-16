package com.tiendaspring.tiendasp.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String apellidos;
    String email;
    String telefono;
    @Column(name="password")
    String password;
    // Aunque Lombok puede generar equals & hashcode, no es recommendable


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
