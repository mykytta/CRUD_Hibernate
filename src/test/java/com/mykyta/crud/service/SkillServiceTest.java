package com.mykyta.crud.service;

import com.mykyta.crud.model.Skill;
import com.mykyta.crud.repository.SkillRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SkillServiceTest extends TestCase {

    private final SkillRepository skillRepository = Mockito.mock(SkillRepository.class);
    private SkillService skillService;

    @Before
    public void setUp(){
        skillService = new SkillService(skillRepository);
    }

    @Test
    public void testGetAllSkills() {
        List<Skill> skills = Arrays.asList(new Skill(1, "TDD"),
                new Skill(2, "SOLID"),
                new Skill(3, "KISS"));

        given(skillRepository.getAll()).willReturn(skills);
        List<Skill> testResult = skillService.getAllSkills();
        assertNotNull(testResult);
        assertEquals(skills, testResult);
        assertEquals(3, testResult.size());
    }

    @Test
    public void testGetSkillById() {
        given(skillRepository.getById(3)).willReturn(new Skill(3, "mySQL"));
        Skill skill = skillService.getSkillById(3);
        assertNotNull(skill);
        assertEquals(skillRepository.getById(3), skill);
        assertNull(skillService.getSkillById(1));
    }

    @Test
    public void testCreateSkill() {
        Skill expected = new Skill(1,"Clean Code");
        given(skillRepository.create(expected)).willReturn(expected);
        Skill actual = skillService.createSkill(expected);

        assertNotNull(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateSkill() {
        Skill withoutChangesExpected = new Skill(1, "OOP");
        given(skillRepository.getById(1)).willReturn(withoutChangesExpected);
        given(skillRepository.update(new Skill(1, "OOP"))).willReturn(new Skill(1, "OOP"));
        Skill withoutChangesActual = skillService.getSkillById(1);
        assertNotNull(withoutChangesActual);
        assertEquals(withoutChangesExpected, withoutChangesActual);

        withoutChangesActual.setSkillName("ASM");
        skillService.updateSkill(withoutChangesActual);

        assertNotNull(withoutChangesActual);
        assertEquals("ASM", withoutChangesActual.getSkillName());
    }

    @Test
    public void testDeleteSkillsById() {
        skillService.deleteSkillsById(3);
        verify(skillRepository).deleteById(3);
    }
}