package com.example.demo3.application.service;

import com.example.demo3.application.DTO.ParametrosDTO;
import com.example.demo3.application.DTO.ReporteDTO;
import com.example.demo3.application.entity.AutorJPA;
import com.example.demo3.application.entity.CategoriaJPA;
import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.inteface.IAutorServiceJPA;
import com.example.demo3.application.inteface.ICategoriaServiceJPA;
import com.example.demo3.application.inteface.ILibroServiceJPA;
import com.example.demo3.infrastructure.common.ExcelUtil;
import com.example.demo3.infrastructure.mapper.LibroRepository;
import com.example.demo3.infrastructure.mapper.ReporteRepository;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service("libroServiceJPA")
public class LibroServiceJPA implements ILibroServiceJPA {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    ReporteRepository reporteRepository;

    @Autowired
    IAutorServiceJPA autorServiceJPA;

    @Autowired
    ICategoriaServiceJPA categoriaServiceJPA;

    @Override
    public List<LibroJPA> list() {
        return (List<LibroJPA>) libroRepository.findAll();
    }

    @Override
    public LibroJPA getById(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public LibroJPA save(LibroJPA libro) {
        AutorJPA autor = autorServiceJPA.save(libro.getAutor());
        libro.setAutor(autor);
        libro.setFecha(LocalDateTime.now());
        return libroRepository.save(libro);
    }

    @Override
    public void delete(Integer id) {
        LibroJPA libro = new LibroJPA();
        libro.setLibroId(id);
        libroRepository.delete(libro);
    }

    @Override
    public ByteArrayInputStream exportExcel(ParametrosDTO parametrosDTO) throws Exception {
        try {
            String[] headers = {"Id", "Nombre", "Descripción", "Categoria", "Páginas", "Autor", "Editorial", "Fecha"};

            Workbook workbook = new HSSFWorkbook();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            CellStyle headerStyle = ExcelUtil.headersStyle(workbook);
            CellStyle rowStyle = ExcelUtil.rowsStyle(workbook);

            Sheet sheet = workbook.createSheet("Libros");
            sheet.setDefaultColumnWidth(20);

            Row row = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            int initRow = 1;
            for (ReporteDTO p : listar(parametrosDTO)) {
                row = sheet.createRow(initRow);
                row.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));

                ExcelUtil.createIntegerCell(p.getId(), row, 0, rowStyle);
                ExcelUtil.createStringCell(p.getNombre(), row, 1, rowStyle);
                ExcelUtil.createStringCell(p.getDescripcion(), row, 2, rowStyle);
                ExcelUtil.createStringCell(p.getCategoria(), row, 3, rowStyle);
                ExcelUtil.createStringCell(p.getPaginas(), row, 4, rowStyle);
                ExcelUtil.createStringCell(p.getAutor(), row, 5, rowStyle);
                ExcelUtil.createStringCell(p.getEditorial(), row, 6, rowStyle);
                if(p.getFecha() != null){
                    ExcelUtil.createStringCell(p.getFecha().toString(), row, 7, rowStyle);
                }

                row.setRowStyle(rowStyle);
                initRow++;
            }

            workbook.write(stream);
            workbook.close();
            return new ByteArrayInputStream(stream.toByteArray());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public List<ReporteDTO> listar(ParametrosDTO parametrosDTO) {

        return reporteRepository.listar(parametrosDTO);
    }
}
