package com.example.demo3.infrastructure.mapper;

import com.example.demo3.application.entity.AutorJPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<AutorJPA, Integer> {
}
