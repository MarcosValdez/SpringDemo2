package com.example.demo3.application.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "libro")
public class LibroJPA {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Integer libroId;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorJPA autor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaJPA categoria;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private EditorialJPA editorial;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "paginas")
    private Integer paginas;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "estado")
    private String estado;

    @Column(name = "precio")
    private String precio;

    @Column(name = "cantidad")
    private Integer cantidad;

    public String getEstado() {
        return estado;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public AutorJPA getAutor() {
        return autor;
    }

    public void setAutor(AutorJPA autor) {
        this.autor = autor;
    }

    public CategoriaJPA getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaJPA categoria) {
        this.categoria = categoria;
    }

    public EditorialJPA getEditorial() {
        return editorial;
    }

    public void setEditorial(EditorialJPA editorial) {
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
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
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
