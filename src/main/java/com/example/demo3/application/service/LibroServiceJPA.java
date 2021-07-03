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
        List<LibroJPA> prueba = (List<LibroJPA>) libroRepository.findAll();
        System.out.println(prueba.get(0));
        return (List<LibroJPA>) libroRepository.findAll();
    }
}
