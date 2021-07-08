package com.example.demo3.application.service;

import com.example.demo3.application.DTO.ParametrosDTO;
import com.example.demo3.application.DTO.ReporteDTO;
import com.example.demo3.application.entity.AutorJPA;
import com.example.demo3.application.entity.EditorialJPA;
import com.example.demo3.application.entity.LibroJPA;
import com.example.demo3.application.inteface.IAutorServiceJPA;
import com.example.demo3.application.inteface.IEditorialServiceJPA;
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
import java.time.LocalDateTime;
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
    IEditorialServiceJPA editorialServiceJPA;

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
        EditorialJPA editorial = editorialServiceJPA.save(libro.getEditorial());
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        /*libro.setFecha(LocalDateTime.now());*/
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


            Row cabecera = sheet.createRow(0);

            Cell cellHeader = cabecera.createCell(0);
            cellHeader.setCellValue("Reporte de ventas");

            Row row = sheet.createRow(1);

            for (int i = 0; i < headers.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            int initRow = 2;
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
                if (p.getFecha() != null) {
                    ExcelUtil.createStringCell(p.getFecha().toString(), row, 7, rowStyle);
                }

                row.setRowStyle(rowStyle);
                initRow++;
            }

            workbook.write(stream);
            stream.close();
            workbook.close();
            return new ByteArrayInputStream(stream.toByteArray());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public ByteArrayInputStream exportExcelInventario() throws Exception {
        try {
            String[] headers = {"Id", "Nombre", "Descripción", "Categoria", "Páginas", "Autor", "Editorial", "Año de publicacion", "Precio"};

            Workbook workbook = new HSSFWorkbook();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            CellStyle headerStyle = ExcelUtil.headersStyle(workbook);
            CellStyle rowStyle = ExcelUtil.rowsStyle(workbook);

            Sheet sheet = workbook.createSheet("Libros");
            sheet.setDefaultColumnWidth(20);


            Row cabecera = sheet.createRow(0);

            Cell cellHeader = cabecera.createCell(0);
            cellHeader.setCellValue("Reporte de ventas");

            Row row = sheet.createRow(1);

            for (int i = 0; i < headers.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            int initRow = 2;
            for (LibroJPA p : list()) {
                row = sheet.createRow(initRow);
                row.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));

                ExcelUtil.createIntegerCell(p.getLibroId(), row, 0, rowStyle);
                ExcelUtil.createStringCell(p.getNombre(), row, 1, rowStyle);
                ExcelUtil.createStringCell(p.getDescripcion(), row, 2, rowStyle);
                ExcelUtil.createStringCell(p.getCategoria().getNombre(), row, 3, rowStyle);
                ExcelUtil.createIntegerCell(p.getPaginas(), row, 4, rowStyle);
                ExcelUtil.createStringCell(p.getAutor().getNombre(), row, 5, rowStyle);
                ExcelUtil.createStringCell(p.getEditorial().getNombre(), row, 6, rowStyle);

                ExcelUtil.createStringCell(p.getPrecio(), row, 7, rowStyle);


                row.setRowStyle(rowStyle);
                initRow++;
            }

            workbook.write(stream);
            stream.close();
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

    @Override
    public void vender(Integer id) {
        libroRepository.vender(id);
    }
}
