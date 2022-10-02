package com.mykyta.crud.service;

import com.mykyta.crud.model.Developer;
import com.mykyta.crud.model.Skill;
import com.mykyta.crud.model.Specialty;
import com.mykyta.crud.repository.DeveloperRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class DeveloperServiceTest extends TestCase {

    private final DeveloperRepository developerRepository = Mockito.mock(DeveloperRepository.class);
    private DeveloperService developerService;

    @Before
    public void setUp(){
        developerService = new DeveloperService(developerRepository);
    }

    public void testGetAllDevelopers() {
        List<Developer> developers = Arrays.asList(createDefaultDeveloper1(),
                                                    createDefaultDeveloper2());
        given(developerRepository.getAll()).willReturn(developers);
        List<Developer> testResult = developerService.getAllDevelopers();
        assertNotNull(testResult);
        assertEquals(developers, testResult);
        assertEquals(2, testResult.size());
    }

    public void testGetDeveloperById() {
        given(developerRepository.getById(1)).willReturn(createDefaultDeveloper1());
        Developer developer = developerService.getDeveloperById(1);
        assertNotNull(developer);
        assertEquals(developerRepository.getById(1), developer);
        assertNull(developerService.getDeveloperById(2));
    }

    public void testCreateDeveloper() {
        Developer expected = createDefaultDeveloper1();

        given(developerRepository.create(expected)).willReturn(expected);
        Developer actual = developerService.createDeveloper(expected);

        assertNotNull(expected);
        assertEquals(expected, actual);
    }

    public void testUpdateDeveloper() {
        Developer withoutChangesExpected = createDefaultDeveloper1();
        given(developerRepository.getById(1)).willReturn(withoutChangesExpected);
        given(developerRepository.update(withoutChangesExpected)).willReturn(withoutChangesExpected);
        Developer withoutChangesActual = developerService.getDeveloperById(1);

        assertNotNull(withoutChangesActual);
        assertEquals(withoutChangesExpected, withoutChangesActual);

        Specialty specialty = new Specialty(2, "PHP");
        withoutChangesActual.setSpecialty(specialty);
        developerService.updateDeveloper(withoutChangesActual);
        assertEquals(specialty, withoutChangesActual.getSpecialty());

    }

    public void testDeleteDeveloperById() {
        developerService.deleteDeveloperById(2);
        verify(developerRepository).deleteById(2);
    }
    
    public Developer createDefaultDeveloper1(){
        List<Skill> skillList = Arrays.asList(
                new Skill(1, "TDD"),
                new Skill(2, "SOLID"),
                new Skill(3, "KISS")
        );
        Developer developer = new Developer(1, "Vasyl", "Kit", skillList,
                new Specialty(1, "Java"));
        return developer;
    }

    public Developer createDefaultDeveloper2(){
        List<Skill> skillList = Arrays.asList(
                new Skill(1, "Clean Code"),
                new Skill(2, "SQL"),
                new Skill(3, "OOP")
        );
        Developer developer = new Developer(2, "Petro", "Korch", skillList,
                new Specialty(1, "C++"));
        return developer;
    }
}