package com.example.demo3.controller;

import com.example.demo3.application.entity.EditorialJPA;
import com.example.demo3.application.service.EditorialServiceJPA;
import com.example.demo3.infrastructure.common.ServiceResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/editorial")
public class EditorialComtrollerJPA {

    @Autowired
    EditorialServiceJPA editorialServiceJPA;

    @GetMapping("/list")
    public ResponseEntity<List<EditorialJPA>> list() {
        try {
            return new ResponseEntity(editorialServiceJPA.list(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<EditorialJPA>> listById(@PathVariable Integer id) {
        try {
            return new ResponseEntity(editorialServiceJPA.getById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResult> create(@RequestBody String editorial) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            EditorialJPA a = new ObjectMapper().readValue(editorial, EditorialJPA.class);
            editorialServiceJPA.save(a);
            serviceResult.setMessage("editorial registrado");
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
            editorialServiceJPA.delete(id);
            serviceResult.setMessage("editorial eliminado");
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
