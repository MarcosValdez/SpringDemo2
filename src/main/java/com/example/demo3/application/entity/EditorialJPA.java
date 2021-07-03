package com.example.demo3.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "editorial")
public class EditorialJPA {

    @Id
    @SequenceGenerator(name = "editorial_id_seq", sequenceName = "editorial_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editorial_id_seq")
    @Column(name = "editorial_id")
    private Integer editorialId;

    @Column(name = "nombre")
    private String nombre;

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
