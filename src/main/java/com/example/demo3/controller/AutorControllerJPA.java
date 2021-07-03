package com.example.demo3.controller;

import com.example.demo3.application.entity.AutorJPA;
import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.service.AutorServiceJPA;
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
@RequestMapping("/api/v1/autor")
public class AutorControllerJPA {
    @Autowired
    AutorServiceJPA autorServiceJPA;

    @GetMapping("/list")
    public ResponseEntity<List<AutorJPA>> list() {
        try {
            return new ResponseEntity(autorServiceJPA.list(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResult> create(@RequestBody String autor) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            AutorJPA a = new ObjectMapper().readValue(autor, AutorJPA.class);
            autorServiceJPA.save(a);
            serviceResult.setMessage("autor registrado");
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
