package com.example.demo3.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaJPA {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
