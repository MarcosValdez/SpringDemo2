package com.example.demo3.application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    private Integer libroId;
    private Integer autorId;
    private Integer categoriaId;
    private Integer editorialId;
    private String nombre;
}
