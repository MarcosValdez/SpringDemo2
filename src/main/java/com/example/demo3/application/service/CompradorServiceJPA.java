package com.example.demo3.application.service;

import com.example.demo3.application.entity.CompradorJPA;
import com.example.demo3.application.inteface.ICompradorServiceJPA;
import com.example.demo3.infrastructure.mapper.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("compradorServiceJPA")
public class CompradorServiceJPA implements ICompradorServiceJPA {
    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<CompradorJPA> list() {
        return null;
    }
}
