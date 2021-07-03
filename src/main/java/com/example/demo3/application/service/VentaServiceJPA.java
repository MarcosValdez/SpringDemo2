package com.example.demo3.application.service;

import com.example.demo3.application.entity.VentaJPA;
import com.example.demo3.application.inteface.IVentaServiceJPA;
import com.example.demo3.infrastructure.mapper.LibroRepository;
import com.example.demo3.infrastructure.mapper.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ventaServiceJPA")
public class VentaServiceJPA implements IVentaServiceJPA {
    @Autowired
    VentaRepository ventaRepository;

    @Override
    public List<VentaJPA> list() {
        return null;
    }
}
