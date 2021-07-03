package com.example.demo3.application.service;

import com.example.demo3.application.entity.EditorialJPA;
import com.example.demo3.application.inteface.IEditorialServiceJPA;
import com.example.demo3.infrastructure.mapper.EditorialRepository;
import com.example.demo3.infrastructure.mapper.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("editorialServiceJPA")
public class EditorialServiceJPA implements IEditorialServiceJPA {
    @Autowired
    EditorialRepository editorialRepository;

    @Override
    public List<EditorialJPA> list() {
        return null;
    }
}
