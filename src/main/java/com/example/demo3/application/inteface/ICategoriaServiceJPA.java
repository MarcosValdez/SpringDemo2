package com.example.demo3.application.inteface;

import com.example.demo3.application.entity.CategoriaJPA;

import java.util.List;

public interface ICategoriaServiceJPA {
    List<CategoriaJPA> list();
    CategoriaJPA getById(Integer id);
    CategoriaJPA save(CategoriaJPA categoria);
    void delete(Integer id);
}
