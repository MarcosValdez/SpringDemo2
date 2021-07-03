package com.example.demo3.controller;

import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.service.LibroServiceJPA;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/libroservice")
public class LibroControllerJPA {

    @Autowired
    LibroServiceJPA libroServiceJPA;

    @GetMapping("/list")
    public ResponseEntity<List<LibroJPA>> list() {
        try {
            return new ResponseEntity(libroServiceJPA.list(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
