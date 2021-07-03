package com.example.demo3.application.service;

import com.example.demo3.application.entity.AutorJPA;
import com.example.demo3.application.inteface.IAutorServiceJPA;
import com.example.demo3.infrastructure.mapper.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("autorServiceJPA")
public class AutorServiceJPA implements IAutorServiceJPA {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public List<AutorJPA> list() {
        return (List<AutorJPA>) autorRepository.findAll();
    }

    @Override
    public AutorJPA getById(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public AutorJPA save(AutorJPA autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void delete(Integer id) {
        AutorJPA autor =  new AutorJPA();
        autor.setAutorId(id);
        autorRepository.delete(autor);
    }
}
