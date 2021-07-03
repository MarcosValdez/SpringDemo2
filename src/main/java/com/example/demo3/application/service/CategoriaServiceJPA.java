package com.example.demo3.application.service;

import com.example.demo3.application.entity.CategoriaJPA;
import com.example.demo3.application.inteface.ICategoriaServiceJPA;
import com.example.demo3.infrastructure.mapper.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoriaServiceJPA")
public class CategoriaServiceJPA implements ICategoriaServiceJPA {
    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<CategoriaJPA> list() {
        return null;
    }
}
