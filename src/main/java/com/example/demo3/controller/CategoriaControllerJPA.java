package com.example.demo3.controller;

import com.example.demo3.application.entity.CategoriaJPA;
import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.service.CategoriaServiceJPA;
import com.example.demo3.application.service.LibroServiceJPA;
import com.example.demo3.infrastructure.common.ServiceResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaControllerJPA {
    @Autowired
    CategoriaServiceJPA categoriaServiceJPA;

    @GetMapping("/list")
    public ResponseEntity<List<CategoriaJPA>> list() {
        try {
            return new ResponseEntity(categoriaServiceJPA.list(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<CategoriaJPA>> listById(@PathVariable Integer id) {
        try {
            return new ResponseEntity(categoriaServiceJPA.getById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResult> create(@RequestBody String categoria) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            CategoriaJPA a = new ObjectMapper().readValue(categoria, CategoriaJPA.class);
            categoriaServiceJPA.save(a);
            serviceResult.setMessage("categoria registrada");
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
            categoriaServiceJPA.delete(id);
            serviceResult.setMessage("Categoria eliminado");
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
