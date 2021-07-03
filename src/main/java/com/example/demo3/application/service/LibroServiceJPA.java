package com.example.demo3.application.service;

import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.inteface.ILibroServiceJPA;
import com.example.demo3.infrastructure.mapper.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("libroServiceJPA")
public class LibroServiceJPA implements ILibroServiceJPA {

    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<LibroJPA> list() {
        return (List<LibroJPA>) libroRepository.findAll();
    }

    @Override
    public LibroJPA getById(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public LibroJPA save(LibroJPA libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void delete(Integer id) {
        LibroJPA libro =  new LibroJPA();
        libro.setLibroId(id);
        libroRepository.delete(libro);
    }
}
