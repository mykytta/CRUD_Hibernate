package com.mykyta.crud.view;

import com.mykyta.crud.controller.SkillController;
import com.mykyta.crud.model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillsView {
    private final Scanner scanner = new Scanner(System.in);
    private final SkillController skillController = new SkillController();

    public void getAllSkills(){
        System.out.println("Skills: ");
        List<Skill> skillList = skillController.getAllSkills();
        if(skillList == null  || skillList.isEmpty()){
            System.out.println("No skills yet");
        }else{
            skillList.forEach(System.out::println);
        }
    }

    public void getSkillById(){
        System.out.println("Enter ID of skill please: ");
        Integer id = scanner.nextInt();
        if(skillController.getSkillById(id) == null) {
            System.out.println("This skill does not exist.");
        }else
            System.out.println(skillController.getSkillById(id));
    }

    public void createSkill(){
        System.out.println("Input name of your skill: ");
        String skillName = scanner.nextLine();
        Skill skill = skillController.createSkill(skillName);
        System.out.println("Skill " + skill.getSkillName() + " successfully created");
    }

    public void updateSkill(){
        System.out.println("Please, enter ID of skill which you want to update: ");
        Integer id = Integer.valueOf(scanner.nextLine());
        System.out.println("Input name of skill which you want to update: ");
        String skillName = scanner.nextLine();
        if(skillController.updateSkill(id, skillName) != null) {
            System.out.println("Skill " + skillName + " successfully updated");
        }else{
            System.out.println("This skill does not exist");
        }
    }

    public void deleteSkillById(){
        System.out.println("Please, enter ID of skill which you want to delete: ");
        Integer id = scanner.nextInt();
        skillController.deleteSkillsById(id);
    }

}
