package com.example.demo3.application.inteface;

import com.example.demo3.application.DTO.ParametrosDTO;
import com.example.demo3.application.DTO.ReporteDTO;
import com.example.demo3.application.entity.LibroJPA;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface ILibroServiceJPA {
    List<LibroJPA> list();
    LibroJPA getById(Integer id);
    LibroJPA save(LibroJPA libro);
    void delete(Integer id);
    ByteArrayInputStream exportExcel(ParametrosDTO parametrosDTO) throws Exception;
    ByteArrayInputStream exportExcelInventario() throws Exception;
    List<ReporteDTO> listar(ParametrosDTO parametrosDTO);
    void vender(Integer id);
}
