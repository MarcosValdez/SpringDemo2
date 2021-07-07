package com.example.demo3.controller;

import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.entity.UsuarioJPA;
import com.example.demo3.application.entity.VentaJPA;
import com.example.demo3.application.inteface.IUsuarioService;
import com.example.demo3.infrastructure.common.ServiceResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioControllerJPA {

    @Autowired
    IUsuarioService usuarioServiceJPA;

    @GetMapping("/list")
    public ResponseEntity<List<UsuarioJPA>> list() {
        try {
            return new ResponseEntity(usuarioServiceJPA.list(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<UsuarioJPA>> listById(@PathVariable Integer id) {
        try {
            return new ResponseEntity(usuarioServiceJPA.getById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResult> create(@RequestBody String venta) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            UsuarioJPA a = new ObjectMapper().readValue(venta, UsuarioJPA.class);
            //usuarioServiceJPA.save(a);
            serviceResult.setMessage("venta registrada");
            serviceResult.setData(usuarioServiceJPA.save(a));
            return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ServiceResult> validar(@RequestBody String usuario) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            UsuarioJPA a = new ObjectMapper().readValue(usuario, UsuarioJPA.class);
            serviceResult.setMessage("venta registrada");
            serviceResult.setData(usuarioServiceJPA.validar(a));
            return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
