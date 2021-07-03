package com.example.demo3.application.service;

import com.example.demo3.application.entity.CategoriaJPA;
import com.example.demo3.application.inteface.ICategoriaServiceJPA;
import com.example.demo3.infrastructure.mapper.CategoriaRepository;
import com.example.demo3.infrastructure.mapper.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoriaServiceJPA")
public class CategoriaServiceJPA implements ICategoriaServiceJPA {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaJPA> list() {
        return (List<CategoriaJPA>) categoriaRepository.findAll();
    }

    @Override
    public CategoriaJPA getById(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public CategoriaJPA save(CategoriaJPA categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void delete(Integer id) {
        CategoriaJPA categoria =  new CategoriaJPA();
        categoria.setCategoriaId(id);
        categoriaRepository.delete(categoria);
    }
}
