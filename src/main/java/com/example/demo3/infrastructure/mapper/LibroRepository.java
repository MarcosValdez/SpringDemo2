package com.example.demo3.infrastructure.mapper;

import com.example.demo3.application.entity.LibroJPA;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LibroRepository extends CrudRepository<LibroJPA,Integer> {

    @Modifying
    @Transactional
    @Query(value = "update LibroJPA t set t.cantidad = t.cantidad - 1 where t.libroId = ?1")
    void vender(Integer id);
}
