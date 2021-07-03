package com.example.demo3.application.inteface;

import com.example.demo3.application.entity.EditorialJPA;
import com.example.demo3.application.entity.LibroJPA;

import java.util.List;

public interface IEditorialServiceJPA {
    List<EditorialJPA> list();
    EditorialJPA getById(Integer id);
    EditorialJPA save(EditorialJPA editorial);
    void delete(Integer id);
}
