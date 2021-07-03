package com.example.demo3.controller;

import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.entity.VentaJPA;
import com.example.demo3.application.service.LibroServiceJPA;
import com.example.demo3.application.service.VentaServiceJPA;
import com.example.demo3.infrastructure.common.ServiceResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list/{id}")
    public ResponseEntity<List<LibroJPA>> listById(@PathVariable Integer id) {
        try {
            return new ResponseEntity(ventaServiceJPA.getById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResult> create(@RequestBody String venta) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            VentaJPA a = new ObjectMapper().readValue(venta, VentaJPA.class);
            ventaServiceJPA.save(a);
            serviceResult.setMessage("venta registrada");
            serviceResult.setData(null);
            return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable Integer id) {
        ServiceResult serviceResult = new ServiceResult();

        try {
            ventaServiceJPA.delete(id);
            serviceResult.setMessage("Venta eliminada");
            serviceResult.setData(null);
            return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
