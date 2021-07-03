package com.example.demo3.application.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class VentaJPA {

    @Id
    @SequenceGenerator(name = "venta_id_seq", sequenceName = "venta_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venta_id_seq")
    @Column(name = "venta_id")
    private Integer ventaId;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private CompradorJPA comprador;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private LibroJPA libro;

    @Column(name = "fecha")
    private LocalDateTime fecha;

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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
