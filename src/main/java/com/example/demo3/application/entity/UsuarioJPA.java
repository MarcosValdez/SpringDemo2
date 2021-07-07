package com.example.demo3.application.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class UsuarioJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "password")
    private String password;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
