package com.example.demo3.controller;

import com.example.demo3.application.DTO.ParametrosDTO;
import com.example.demo3.application.DTO.ReporteDTO;
import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.entity.VentaJPA;
import com.example.demo3.application.inteface.ILibroServiceJPA;
import com.example.demo3.infrastructure.common.ServiceResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.ByteArrayInputStream;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/libro")
public class LibroControllerJPA {

    @Autowired
    ILibroServiceJPA libroServiceJPA;

    @GetMapping("/list")
    public ResponseEntity<List<LibroJPA>> list() {
        try {

            return new ResponseEntity(libroServiceJPA.list(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/listar")
    public ResponseEntity<List<ReporteDTO>> listar(@RequestBody ParametrosDTO parametrosDTO) {
        try {

            return new ResponseEntity(libroServiceJPA.listar(parametrosDTO), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<LibroJPA>> listById(@PathVariable Integer id) {
        try {
            return new ResponseEntity(libroServiceJPA.getById(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResult> create(@RequestBody String libro) {

        ServiceResult serviceResult = new ServiceResult();
        try {
            LibroJPA a = new ObjectMapper().readValue(libro, LibroJPA.class);
            libroServiceJPA.save(a);
            serviceResult.setMessage("libro registrado");
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
            libroServiceJPA.delete(id);
            serviceResult.setMessage("Libro eliminado");
            serviceResult.setData(null);
            return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/export/reporte")
    public ResponseEntity<InputStreamSource> exportarExcelVenta(@RequestBody ParametrosDTO parametrosDTO) {
        try {
            ByteArrayInputStream stream = libroServiceJPA.exportExcel(parametrosDTO);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Reporte.xls");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping(value = "/export/inventario")
    public ResponseEntity<InputStreamSource> exportarExcel() {
        try {
            ByteArrayInputStream stream = libroServiceJPA.exportExcelInventario();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Inventario.xls");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/vender/{id}")
    public ResponseEntity<Void> vender(@PathVariable Integer id) {
        try {
            libroServiceJPA.vender(id);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
