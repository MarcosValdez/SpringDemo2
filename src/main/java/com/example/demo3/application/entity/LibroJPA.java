package com.example.demo3.application.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "libro")
public class LibroJPA {

    @Id
    @SequenceGenerator(name = "libro_id_seq", sequenceName = "libro_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_id_seq")
    @Column(name = "libro_id")
    private Integer libroId;

    @Column(name = "autor_id")
    private Integer autor;

    @Column(name = "categoria_id")
    private String categoria;

    @Column(name = "editorial_id")
    private String editorial;

    @Column(name = "nombre")
    private String nombre;

    /*@Column(name = "descripcion")
    private String descripcion;

    @Column(name = "paginas")
    private Integer paginas;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    public Integer getLibroId() {
        return libroId;
    }*/

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public Integer getAutor() {
        return autor;
    }

    public void setAutor(Integer autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   /* public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }*/
}
