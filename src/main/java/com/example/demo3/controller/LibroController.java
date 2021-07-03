package com.example.demo3.controller;

import com.example.demo3.application.DTO.LibroDTO;
import com.example.demo3.application.inteface.ILibroService;
import com.example.demo3.infrastructure.common.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private ILibroService libroService;

    @GetMapping("/hola")
    public String hola(){
        return "hola;";
    }


    @GetMapping("/lista")
    public ResponseEntity<ServiceResult> listarLibro(){
        ServiceResult serviceResult = new ServiceResult();
        try {

            List<LibroDTO> listLibro = libroService.listarLibro();

            serviceResult.setData(listLibro);
            serviceResult.setMessage("success");

            return new ResponseEntity(serviceResult, HttpStatus.MULTI_STATUS);
        } catch (Exception ex) {
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
        }
        return new ResponseEntity<>(serviceResult, HttpStatus.OK);
    }


}
