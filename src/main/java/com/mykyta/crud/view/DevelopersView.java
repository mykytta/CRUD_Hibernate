package com.mykyta.crud.view;

import com.mykyta.crud.controller.DeveloperController;
import com.mykyta.crud.controller.SkillController;
import com.mykyta.crud.controller.SpecialtyController;
import com.mykyta.crud.model.Developer;
import com.mykyta.crud.model.Skill;
import com.mykyta.crud.model.Specialty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DevelopersView {
    private final Scanner scanner = new Scanner(System.in);

    private final DeveloperController developerController = new DeveloperController();

    private final SkillController skillController = new SkillController();
    private final SpecialtyController specialtyController = new SpecialtyController();

    public void getAllDevelopers(){
        System.out.println("Developers: ");
        List<Developer> developerList = developerController.getAllDevelopers();
        if(developerList == null || developerList.isEmpty()){
            System.out.println("No developers yet");
        } else {
            developerList.forEach(System.out::println);
        }
    }

    public void getDeveloperById(){
        System.out.println("Enter ID of developer please: ");
        Integer id = scanner.nextInt();
        if(developerController.getDeveloperById(id) == null) {
            System.out.println("This developer does not exist.");
        }else
            System.out.println(developerController.getDeveloperById(id));
    }

    public void createDeveloper(){
        System.out.println("Input first name of your developer: ");
        String firstName = scanner.nextLine();
        System.out.println("Input last name of your developer: ");
        String lastName = scanner.nextLine();
        System.out.println("Input id of developer's skill: ");
        List<Skill> skillList = showSkillList();
        System.out.println("Input id of developer's specialty: ");
        Specialty specialty = getSpecialty();
        developerController.createDeveloper(firstName, lastName, skillList, specialty);

    }

    private Specialty getSpecialty() {
        List<Specialty> specialtyList = specialtyController.getAllSpecialties();
        if(specialtyList == null  || specialtyList.isEmpty()) {
            System.out.println("No skills yet");
        } else {
            specialtyList.forEach(System.out::println);
        }
        System.out.println("Choose specialty by id: ");
        Integer id = Integer.valueOf(scanner.nextLine());
        Specialty specialty = specialtyController.getSpecialtyById(id);
        return specialty;
    }

    private List<Skill> showSkillList() {
        List<Skill> skillList = skillController.getAllSkills();
        if(skillList == null  || skillList.isEmpty()) {
            System.out.println("No skills yet");
        } else {
            skillList.forEach(System.out::println);
        }
        List<Skill> developerSkillList = new ArrayList<>();
        System.out.println("Choose skill by id: ");
        boolean continueSelection = true;
        while(continueSelection){
            Integer id = Integer.valueOf(scanner.nextLine());
            Skill skill = skillController.getSkillById(id);
            developerSkillList.add(skill);
            System.out.println("Do you want to add more skills? [Y/n]");
            String userResponse = scanner.nextLine();
            if (!userResponse.toUpperCase().equals("Y")) {
                continueSelection = false;
            }
        }
            return developerSkillList;
    }

    public void updateDeveloper(){
        System.out.println("Please, enter ID of developer which you want to update");
        Integer id = Integer.valueOf(scanner.nextLine());
        System.out.println("Input first name of developer which you want to update: ");
        String firstName = scanner.nextLine();
        System.out.println("Input last name of developer which you want to update: ");
        String lastName = scanner.nextLine();
        System.out.println("Input id of skill which you want to add");
        List<Skill> skillList = showSkillList();
        System.out.println("Input id of specialty which you want to add");
        Specialty specialty = getSpecialty();
        developerController.updateDeveloper(id, firstName, lastName, skillList, specialty);
    }

    public  void deleteDeveloperById(){
        System.out.println("Please, enter ID of developer which you want to delete: ");
        Integer id = scanner.nextInt();
        developerController.deleteDeveloperById(id);
    }
}
