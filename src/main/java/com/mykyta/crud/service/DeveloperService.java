package com.mykyta.crud.service;

import com.mykyta.crud.model.Developer;
import com.mykyta.crud.repository.DeveloperRepository;

import java.util.List;

public class DeveloperService {
    private DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository){
        this.developerRepository = developerRepository;
    }

    public List<Developer> getAllDevelopers(){
        return developerRepository.getAll();
    }

    public Developer getDeveloperById(Integer id){
        return developerRepository.getById(id);
    }

    public Developer createDeveloper(Developer developer){
        return developerRepository.create(developer);
    }

    public Developer updateDeveloper(Developer developer){
        return  developerRepository.update(developer);
    }

    public void deleteDeveloperById(Integer id){
        developerRepository.deleteById(id);
    }
}
