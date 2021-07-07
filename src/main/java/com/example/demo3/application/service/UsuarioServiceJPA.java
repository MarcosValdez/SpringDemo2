package com.example.demo3.application.service;

import com.example.demo3.application.entity.UsuarioJPA;
import com.example.demo3.application.inteface.IUsuarioService;
import com.example.demo3.infrastructure.mapper.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioServiceJPA")
public class UsuarioServiceJPA implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioJPA> list() {
        return (List<UsuarioJPA>) usuarioRepository.findAll();
    }

    @Override
    public UsuarioJPA getById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioJPA save(UsuarioJPA usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioJPA validar(UsuarioJPA usuarioJPA) {
        return usuarioRepository.validar(usuarioJPA.getNombre(), usuarioJPA.getPassword());
    }
}
