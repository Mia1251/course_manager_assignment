package se.lexicon.course_manager_assignment.data.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {StudentCollectionRepository.class})
public class StudentCollectionRepositoryTest {

    @Autowired
    private StudentDao testObject;

    List<Student> studentList = new ArrayList<>();
    Student studentChrister = new Student(1, "Christer", "ch.sv@gmail.com", "Gamla Landsvägen 2");
    Student studentAnton = new Student(2, "Anton", "ant.sv@gmail.com", "Violvägen 12");
    Student studentAndreas = new Student(3, "Andreas", "and.sv@gmail.com", "Vallby 116");

    List<Student> studentList1 = new ArrayList<>();
    Student student1 = new Student(1, "Christer", "ch.sv@gmail.com", "Gamla Landsvägen 2");
    Student student2 = new Student(2, "Anton", "ant.sv@gmail.com", "Violvägen 12");
    Student student3 = new Student(3, "Andreas", "and.sv@gmail.com", "Vallby 116");

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    //Write your tests here
    @Test
    public void test_CreateStudent() {
        Student expectedResult = studentChrister;
        Student actualResult = testObject.createStudent("Christer", "ch.sv@gmail.com", "Gamla Landsvägen 2");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findByEmailIgnoreCase() {
    }

    @Test
    public void test_findByNameContains() {
    }

    @Test
    public void test_findById() {
    }

    @Test
    public void test_findAll() {
    }

    @Test
    public void test_removeStudent() {
    }

    @Test
    public void test_clear() {
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        StudentSequencer.setStudentSequencer(0);
    }
}
