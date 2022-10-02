package com.mykyta.crud.service;

import com.mykyta.crud.model.Specialty;
import com.mykyta.crud.repository.SpecialtyRepository;

import java.util.List;

public class SpecialtyService {
    private SpecialtyRepository specialtyRepository;

    public SpecialtyService (SpecialtyRepository specialtyRepository){
        this.specialtyRepository = specialtyRepository;
    }
    public List<Specialty> getAllSpecialties(){
        return specialtyRepository.getAll();
    }

    public Specialty getSpecialtyById(Integer id){
        return specialtyRepository.getById(id);
    }

    public Specialty createSpecialty(Specialty specialty){
        return specialtyRepository.create(specialty);
    }

    public Specialty updateSpecialty(Specialty specialty) {
        return specialtyRepository.update(specialty);
    }

    public void deleteSpecialtyById(Integer id){
        specialtyRepository.deleteById(id);
    }
}
