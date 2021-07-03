package com.example.demo3.application.inteface;

import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.entity.VentaJPA;

import java.util.List;

public interface IVentaServiceJPA {
    List<VentaJPA> list();
    VentaJPA getById(Integer id);
    VentaJPA save(VentaJPA venta);
    void delete(Integer id);
}
