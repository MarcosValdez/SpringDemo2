package com.example.demo3.application.service;

import com.example.demo3.application.entity.CompradorJPA;
import com.example.demo3.application.inteface.ICompradorServiceJPA;
import com.example.demo3.infrastructure.mapper.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("compradorServiceJPA")
public class CompradorServiceJPA implements ICompradorServiceJPA {
    @Autowired
    CompradorRepository compradorRepository;

    @Override
    public List<CompradorJPA> list() {
        return (List<CompradorJPA>) compradorRepository.findAll();
    }

    @Override
    public CompradorJPA getById(Integer id) {
        return compradorRepository.findById(id).orElse(null);
    }

    @Override
    public CompradorJPA save(CompradorJPA comprador) {
        return compradorRepository.save(comprador);
    }

    @Override
    public void delete(Integer id) {
        CompradorJPA comprador = new CompradorJPA();
        comprador.setCompradorId(id);
        compradorRepository.delete(comprador);
    }
}