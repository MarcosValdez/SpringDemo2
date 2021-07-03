package com.example.demo3.controller;

import com.example.demo3.application.entity.AutorJPA;
import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.service.AutorServiceJPA;
import com.example.demo3.application.service.LibroServiceJPA;
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
}
