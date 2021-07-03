package com.example.demo3.application.inteface;

import com.example.demo3.application.entity.LibroJPA;

import java.util.List;

public interface ILibroServiceJPA {
    List<LibroJPA> list();
    LibroJPA getById(Integer id);
    LibroJPA save(LibroJPA libro);
    void delete(Integer id);
}
