package com.mykyta.crud.view;

import java.util.Scanner;
import java.util.stream.Stream;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        int c = printFirst();
        choiceChecker(c);
        userWantsToContinue();

    }

    private int printFirst() {
        System.out.print("You can choose the option: \n");
        Stream.generate(() -> " _").limit(59).forEach(System.out::print);
        System.out.println();
        String allSkills = "Press 1 to see all skills ";
        String allSpecialties = "Press 6 to see all specialties ";
        String allDevelopers = "Press 11 to see all developers ";
        String getSkillById = "Press 2 to get skill by id ";
        String getSpecialtyById = "Press 7 to get specialty by id ";
        String getDeveloperById = "Press 12 to get developer by id ";
        String createSkill = "Press 3 to create your own skill ";
        String createSpecialty = "Press 8 to create your own specialty ";
        String createDeveloper = "Press 13 to create your own developer ";
        String updateSkill = "Press 4 to update skill ";
        String updateSpecialty = "Press 9 to update specialty ";
        String updateDeveloper = "Press 14 to update developer ";
        String deleteSkill = "Press 5 to delete skill by ID ";
        String deleteSpecialty = "Press 10 to delete specialty by ID ";
        String deleteDeveloper = "Press 15 to delete developer by ID ";

        System.out.format("|%-35s|%-40s|%-40s|\n", allSkills, allSpecialties, allDevelopers);
        System.out.format("|%-35s|%-40s|%-40s|\n", getSkillById, getSpecialtyById, getDeveloperById);
        System.out.format("|%-35s|%-40s|%-40s|\n", createSkill, createSpecialty, createDeveloper);
        System.out.format("|%-35s|%-40s|%-40s|\n", updateSkill, updateSpecialty, updateDeveloper);
        System.out.format("|%-35s|%-40s|%-40s|\n", deleteSkill, deleteSpecialty, deleteDeveloper);
        Stream.generate(() -> " ‾").limit(59).forEach(System.out::print);
        System.out.println();

        int c = scanner.nextInt();
        return c;
    }

    private void choiceChecker(int c) {
        SkillsView skillsView = new SkillsView();
        SpecialtiesView specialtiesView = new SpecialtiesView();
        DevelopersView developersView = new DevelopersView();

        if (c <= 0 || c > 15)
            System.out.println("Please enter the right number");

        switch (c) {
            case 1:
                skillsView.getAllSkills();
                break;
            case 2:
                skillsView.getSkillById();
                break;
            case 3:
                skillsView.createSkill();
                break;
            case 4:
                skillsView.updateSkill();
                break;
            case 5:
                skillsView.deleteSkillById();
                break;
            case 6:
                specialtiesView.getAllSpecialties();
                break;
            case 7:
                specialtiesView.getSpecialtyById();
                break;
            case 8:
                specialtiesView.createSpecialty();
                break;
            case 9:
                specialtiesView.updateSpecialty();
                break;
            case 10:
                specialtiesView.deleteSpecialtyById();
                break;
            case 11:
                developersView.getAllDevelopers();
                break;
            case 12:
                developersView.getDeveloperById();
                break;
            case 13:
                developersView.createDeveloper();
                break;
            case 14:
                developersView.updateDeveloper();
                break;
            case 15:
                developersView.deleteDeveloperById();
                break;
        }
    }

    private void userWantsToContinue() {
        System.out.println("Do you want to edit something else? [Y/n]");
        String userWantsToContinue = scanner.next();

        if (userWantsToContinue.toUpperCase().equals("Y")) {
            mainMenu();
        } else {
            System.out.println("See you");
        }
    }
}
