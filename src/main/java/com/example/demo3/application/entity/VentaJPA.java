package com.example.demo3.application.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "venta")
public class VentaJPA {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "venta_id")
    private Integer ventaId;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private CompradorJPA comprador;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private LibroJPA libro;

    @Column(name = "fecha")
    private Date fecha;

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public CompradorJPA getComprador() {
        return comprador;
    }

    public void setComprador(CompradorJPA comprador) {
        this.comprador = comprador;
    }

    public LibroJPA getLibro() {
        return libro;
    }

    public void setLibro(LibroJPA libro) {
        this.libro = libro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
