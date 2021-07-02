package com.example.demo3.infrastructure.mapper;

import com.example.demo3.application.entity.Libro;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ILibroRepository {

    @Select(value = "SELECT * FROM libro")
    @Results(id = "libros", value = {
            @Result(property = "libroId", column = "libro_id"),
            @Result(property = "autorId", column = "autor_id"),
            @Result(property = "categoriaId", column = "categoria_id"),
            @Result(property = "editorialId", column = "editorial_id")
    }
    )
    @ResultType(Libro.class)
    List<Libro> listarLibro();

}
