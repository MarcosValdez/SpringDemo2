package com.example.demo3.application.service;

import com.example.demo3.application.entity.CompradorJPA;
import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.entity.VentaJPA;
import com.example.demo3.application.inteface.ICompradorServiceJPA;
import com.example.demo3.application.inteface.ILibroServiceJPA;
import com.example.demo3.application.inteface.IVentaServiceJPA;
import com.example.demo3.infrastructure.mapper.LibroRepository;
import com.example.demo3.infrastructure.mapper.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("ventaServiceJPA")
public class VentaServiceJPA implements IVentaServiceJPA {
    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    ICompradorServiceJPA compradorServiceJPA;

    @Autowired
    ILibroServiceJPA libroServiceJPA;

    @Override
    public List<VentaJPA> list() {

        return (List<VentaJPA>) ventaRepository.findAll();
    }

    @Override
    public VentaJPA getById(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public VentaJPA save(VentaJPA venta) {
        CompradorJPA compradorJPA = compradorServiceJPA.save(venta.getComprador());
        venta.setComprador(compradorJPA);
        venta.setFecha(LocalDateTime.now());
        libroServiceJPA.vender(venta.getLibro().getLibroId());
        return ventaRepository.save(venta);
    }

    @Override
    public void delete(Integer id) {
        VentaJPA venta = new VentaJPA();
        venta.setVentaId(id);
        ventaRepository.delete(venta);
    }
}
