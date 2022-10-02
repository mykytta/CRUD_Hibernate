package com.mykyta.crud.controller;

import com.mykyta.crud.model.Skill;
import com.mykyta.crud.repository.SkillRepository;
import com.mykyta.crud.repository.hibernate.HibernateSkillRepository;
import com.mykyta.crud.service.SkillService;

import java.util.List;

public class SkillController {

    private final SkillRepository skillRepository = new HibernateSkillRepository();
    private final SkillService skillService = new SkillService(skillRepository);
    public List<Skill> getAllSkills(){
        return skillService.getAllSkills();
    }

    public Skill getSkillById(Integer id){
        return skillService.getSkillById(id);
    }

    public Skill createSkill(String skillName){
        Skill skill = new Skill(null, skillName);
        return skillService.createSkill(skill);
    }

    public Skill updateSkill(Integer id, String skillName) {
        return skillService.updateSkill(new Skill(id, skillName));
    }

    public void deleteSkillsById(Integer id){
        skillService.deleteSkillsById(id);
    }
}
