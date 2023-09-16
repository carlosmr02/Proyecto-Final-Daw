package com.tiendaspring.tiendasp.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "patinetes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Patinete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marca;
    String modelo;
    String autonomia;


}
