package com.mykyta.crud.controller;

import com.mykyta.crud.model.Developer;
import com.mykyta.crud.model.Skill;
import com.mykyta.crud.model.Specialty;
import com.mykyta.crud.repository.DeveloperRepository;
import com.mykyta.crud.repository.hibernate.HibernateDeveloperRepository;
import com.mykyta.crud.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    private final DeveloperRepository developerRepository = new HibernateDeveloperRepository();
    private final DeveloperService developerService = new DeveloperService(developerRepository);

    public List<Developer> getAllDevelopers(){
        return developerService.getAllDevelopers();
    }

    public Developer getDeveloperById(Integer id){
        return developerService.getDeveloperById(id);
    }

    public Developer createDeveloper(String firstName, String lastName, List<Skill> skillList, Specialty specialty){
        Developer developer = new Developer(null, firstName, lastName, skillList, specialty);
        return developerService.createDeveloper(developer);
    }

    public Developer updateDeveloper(Integer id, String firstName, String lastName, List<Skill> skillList, Specialty specialty){
        Developer developer = new Developer(id, firstName, lastName, skillList, specialty);
        return  developerService.updateDeveloper(developer);
    }

    public void deleteDeveloperById(Integer id){
        developerService.deleteDeveloperById(id);
    }
}
