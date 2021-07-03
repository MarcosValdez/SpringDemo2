package com.example.demo3.controller;

import com.example.demo3.application.entity.CompradorJPA;
import com.example.demo3.application.service.CompradorServiceJPA;
import com.example.demo3.infrastructure.common.ServiceResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/comprador")
public class CompradorControllerJPA {
    @Autowired
    CompradorServiceJPA compradorServiceJPA;

    @GetMapping("/list")
    public ResponseEntity<List<CompradorJPA>> list() {
        try {
            return new ResponseEntity(compradorServiceJPA.list(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<CompradorJPA>> listById(@PathVariable Integer id) {
        try {
            return new ResponseEntity(compradorServiceJPA.getById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResult> create(@RequestBody String comprador) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            CompradorJPA a = new ObjectMapper().readValue(comprador, CompradorJPA.class);
            compradorServiceJPA.save(a);
            serviceResult.setMessage("comprador registrado");
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
            compradorServiceJPA.delete(id);
            serviceResult.setMessage("Comprador eliminado");
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
