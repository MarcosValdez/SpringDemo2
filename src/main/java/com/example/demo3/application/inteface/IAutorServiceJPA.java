package com.example.demo3.application.inteface;

import com.example.demo3.application.entity.AutorJPA;

import java.util.List;

public interface IAutorServiceJPA {
    List<AutorJPA> list();
    AutorJPA getById(Integer id);
    AutorJPA save(AutorJPA autor);
    void delete(Integer id);
}
