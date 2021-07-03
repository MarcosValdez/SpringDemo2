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
        return null;
    }
}
