package com.example.demo3.application.inteface;

import com.example.demo3.application.entity.CompradorJPA;

import java.util.List;

public interface ICompradorServiceJPA {
    List<CompradorJPA> list();
    CompradorJPA getById(Integer id);
    CompradorJPA save(CompradorJPA comprador);
    void delete(Integer id);
}
