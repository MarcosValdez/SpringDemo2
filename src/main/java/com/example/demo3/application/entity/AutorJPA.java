package com.example.demo3.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "autor")
public class AutorJPA {

    @Id
    @SequenceGenerator(name = "autor_id_seq", sequenceName = "autor_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_id_seq")
    @Column(name = "autor_id")
    private Integer autorId;

    @Column(name = "nombre")
    private String nombre;

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
