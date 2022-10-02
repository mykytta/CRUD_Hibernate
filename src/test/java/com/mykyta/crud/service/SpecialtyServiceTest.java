package com.mykyta.crud.service;

import com.mykyta.crud.model.Specialty;
import com.mykyta.crud.repository.SpecialtyRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SpecialtyServiceTest extends TestCase {
    private final SpecialtyRepository specialtyRepository = Mockito.mock(SpecialtyRepository.class);
    private SpecialtyService specialtyService;

    @Before
    public void setUp(){
        specialtyService = new SpecialtyService(specialtyRepository);
    }

    @Test
    public void testGetAll() {
        List<Specialty> specialties = Arrays.asList(new Specialty(1, "C++"),
                new Specialty(2, "Java"),
                new Specialty(3, "Clojure"));

        given(specialtyRepository.getAll()).willReturn(specialties);
        List<Specialty> testResult = specialtyService.getAllSpecialties();
        assertNotNull(testResult);
        assertEquals(specialties, testResult);
        assertEquals(3, testResult.size());
    }

    @Test
    public void testGetSpecialtyById() {
        given(specialtyRepository.getById(3)).willReturn(new Specialty(3, "C#"));
        Specialty specialty = specialtyService.getSpecialtyById(3);
        assertNotNull(specialty);
        assertEquals(specialtyRepository.getById(3), specialty);
        assertNull(specialtyService.getSpecialtyById(1));
    }

    @Test
    public void testCreateSpecialty() {
        Specialty expected = new Specialty(1,"JS");
        when(specialtyRepository.create(expected)).thenReturn(expected);
        Specialty actual = specialtyService.createSpecialty(expected);

        assertNotNull(expected);
        assertEquals(expected, actual);
    }


    @Test
    public void testUpdateSpecialty() {
        Specialty withoutChangesExpected = new Specialty(1, "Rust");
        given(specialtyRepository.getById(1)).willReturn(withoutChangesExpected);
        given(specialtyRepository.update(new Specialty(1, "Rust"))).willReturn(new Specialty(1, "Rust"));
        Specialty withoutChangesActual = specialtyService.getSpecialtyById(1);
        assertNotNull(withoutChangesActual);
        assertEquals(withoutChangesExpected, withoutChangesActual);

        withoutChangesActual.setSpecialtyName("C++");
        specialtyService.updateSpecialty(withoutChangesActual);

        assertNotNull(withoutChangesActual);
        assertEquals("C++", withoutChangesActual.getSpecialtyName());

    }

    @Test
    public void testDeleteSpecialtyById() {
        specialtyService.deleteSpecialtyById(3);
        verify(specialtyRepository).deleteById(3);
    }
}