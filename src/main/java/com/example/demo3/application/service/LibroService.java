package com.example.demo3.application.service;

import com.example.demo3.application.DTO.LibroDTO;
import com.example.demo3.application.entity.Libro;
import com.example.demo3.application.inteface.ILibroService;
import com.example.demo3.infrastructure.config.ObjectMapperUtils;
import com.example.demo3.infrastructure.mapper.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService implements ILibroService {

    @Autowired
    private ILibroRepository libroRepository;

    @Override
    public List<LibroDTO> listarLibro() {
        try {
            List<Libro> comentarioList = libroRepository.listarLibro();
            List<LibroDTO> comentarioDTOS = ObjectMapperUtils.mapAll(comentarioList, LibroDTO.class);

            return comentarioDTOS;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
