package com.example.demo3.infrastructure.mapper;

import com.example.demo3.application.entity.UsuarioJPA;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioJPA, Integer> {

    @Query(value = "select u from UsuarioJPA u where u.nombre = ?1 and u.password = ?2")
    UsuarioJPA validar(String nombre, String password);
}
