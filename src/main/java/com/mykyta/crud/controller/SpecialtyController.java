package com.mykyta.crud.controller;

import com.mykyta.crud.model.Specialty;
import com.mykyta.crud.repository.SpecialtyRepository;
import com.mykyta.crud.repository.hibernate.HibernateSpecialtyRepository;
import com.mykyta.crud.service.SpecialtyService;

import java.util.List;

public class SpecialtyController {
    private final SpecialtyRepository specialtyRepository = new HibernateSpecialtyRepository();
    private final SpecialtyService specialtyService = new SpecialtyService(specialtyRepository);

    public List<Specialty> getAllSpecialties(){
        return specialtyService.getAllSpecialties();
    }

    public Specialty getSpecialtyById(Integer id){
        return specialtyService.getSpecialtyById(id);
    }

    public Specialty createSpecialty(String specialtyName){
        Specialty specialty = new Specialty(null, specialtyName);
        return specialtyService.createSpecialty(specialty);
    }

    public Specialty updateSpecialty(Integer id, String specialtyName) {
        return specialtyService.updateSpecialty(new Specialty(id, specialtyName));
    }

    public void deleteSpecialtyById(Integer id){
        specialtyService.deleteSpecialtyById(id);
    }
}
