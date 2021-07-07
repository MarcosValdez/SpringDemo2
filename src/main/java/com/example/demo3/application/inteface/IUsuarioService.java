package com.example.demo3.application.inteface;

import com.example.demo3.application.entity.UsuarioJPA;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioJPA> list();
    UsuarioJPA getById(Integer id);
    UsuarioJPA save(UsuarioJPA usuario);
    UsuarioJPA validar(UsuarioJPA usuarioJPA);
}
