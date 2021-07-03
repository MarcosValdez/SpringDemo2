package com.example.demo3.application.service;

import com.example.demo3.application.entity.EditorialJPA;
import com.example.demo3.application.inteface.IEditorialServiceJPA;
import com.example.demo3.infrastructure.mapper.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("editorialServiceJPA")
public class EditorialServiceJPA implements IEditorialServiceJPA {
    @Autowired
    EditorialRepository editorialRepository;

    @Override
    public List<EditorialJPA> list() {
        return (List<EditorialJPA>) editorialRepository.findAll();
    }

    @Override
    public EditorialJPA getById(Integer id) {
        return editorialRepository.findById(id).orElse(null);
    }

    @Override
    public EditorialJPA save(EditorialJPA editorial) { return editorialRepository.save(editorial); }

    @Override
    public void delete(Integer id) {
        EditorialJPA editorial = new EditorialJPA();
        editorial.setEditorialId(id);
        editorialRepository.delete(editorial);
    }
}