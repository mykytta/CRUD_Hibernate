package com.mykyta.crud.view;

import com.mykyta.crud.controller.SpecialtyController;
import com.mykyta.crud.model.Specialty;

import java.util.List;
import java.util.Scanner;

public class SpecialtiesView {
    private final Scanner scanner = new Scanner(System.in);
    private final SpecialtyController specialtyController = new SpecialtyController();

    public void getAllSpecialties(){
        System.out.println("Specialties: ");
        List<Specialty> specialtyList = specialtyController.getAllSpecialties();
        if(specialtyList == null  || specialtyList.isEmpty()){
            System.out.println("No specialties yet");
        }else{
            specialtyList.forEach(System.out::println);
        }
    }

    public void getSpecialtyById(){
        System.out.println("Enter ID of specialties please: ");
        Integer id = scanner.nextInt();
        if(specialtyController.getSpecialtyById(id) == null) {
            System.out.println("This specialty does not exist.");
        }else
            System.out.println(specialtyController.getSpecialtyById(id));
    }

    public void createSpecialty(){
        System.out.println("Input name of your specialty: ");
        String specialtyName = scanner.nextLine();
        Specialty specialty = specialtyController.createSpecialty(specialtyName);
        System.out.println("Specialty " + specialty.getSpecialtyName() + " successfully created");
    }

    public void updateSpecialty(){
        System.out.println("Please, enter ID of specialty which you want to update: ");
        Integer id = Integer.valueOf(scanner.nextLine());
        System.out.println("Input name of specialty which you want to update: ");
        String specialtyName = scanner.nextLine();
        if(specialtyController.updateSpecialty(id, specialtyName) != null) {
            System.out.println("Specialty " + specialtyName + " successfully updated");
        }else{
            System.out.println("This specialty does not exist");
        }
    }

    public void deleteSpecialtyById(){
        System.out.println("Please, enter ID of specialty which you want to delete: ");
        Integer id = scanner.nextInt();
        specialtyController.deleteSpecialtyById(id);
    }
}
