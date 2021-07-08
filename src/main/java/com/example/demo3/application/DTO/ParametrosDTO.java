package com.example.demo3.application.DTO;

import java.time.LocalDate;

public class ParametrosDTO {
    private String nombre;
    private String autor;
    private Integer categoria;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
}
