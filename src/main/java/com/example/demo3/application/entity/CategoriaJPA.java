package com.example.demo3.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaJPA {

    @Id
    @SequenceGenerator(name = "categoria_id_seq", sequenceName = "categoria_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_id_seq")
    @Column(name = "categoria_id")
    private Integer categoriaId;

    @Column(name = "nombre")
    private String nombre;

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
