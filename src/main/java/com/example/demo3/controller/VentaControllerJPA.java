package com.example.demo3.controller;

import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.entity.VentaJPA;
import com.example.demo3.application.service.LibroServiceJPA;
import com.example.demo3.application.service.VentaServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/venta")
public class VentaControllerJPA {
    @Autowired
    VentaServiceJPA ventaServiceJPA;

    @GetMapping("/list")
    public ResponseEntity<List<VentaJPA>> list() {
        try {
            return new ResponseEntity(ventaServiceJPA.list(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
