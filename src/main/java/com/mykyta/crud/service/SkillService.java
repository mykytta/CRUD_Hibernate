package com.mykyta.crud.service;

import com.mykyta.crud.model.Skill;
import com.mykyta.crud.repository.SkillRepository;

import java.util.List;

public class SkillService {
    private SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }
    public List<Skill> getAllSkills(){
        return skillRepository.getAll();
    }

    public Skill getSkillById(Integer id){
        return skillRepository.getById(id);
    }

    public Skill createSkill(Skill skill){
        return skillRepository.create(skill);
    }

    public Skill updateSkill(Skill skill) {
        return skillRepository.update(skill);
    }

    public void deleteSkillsById(Integer id){
        skillRepository.deleteById(id);
    }
}
