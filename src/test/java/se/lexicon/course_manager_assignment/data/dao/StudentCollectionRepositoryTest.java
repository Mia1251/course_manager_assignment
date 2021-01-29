package se.lexicon.course_manager_assignment.data.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {StudentCollectionRepository.class})
public class StudentCollectionRepositoryTest {

    private StudentCollectionRepository testStudentCollectionRepository;

    List<Student> studentList = new ArrayList<>();
    Student student1 = new Student(1, "Christer", "ch.sv@gmail.com", "Gamla Landsvägen 2");
    Student student2 = new Student(2, "Anton", "ant.sv@gmail.com", "Violvägen 12");
    Student student3 = new Student(3, "Andreas", "and.sv@gmail.com", "Vallby 116");

    @Autowired
    private StudentDao testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    //Write your tests here
    @Test
    public void test_CreateStudent() {
        Student expectedResult = student2;
        Student actualResult = testStudentCollectionRepository.createStudent(student2.getName(), student2.getEmail(), student2.getAddress());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findByEmailIgnoreCase() {
        Student expectedResult = student1;
        Student actualResult = testStudentCollectionRepository.findByEmailIgnoreCase(student1.getEmail());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findByNameContains() {
        Student expectedResult = student1;
        Student actualResult = (Student) testStudentCollectionRepository.findByNameContains(student1.getName());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findById() {
        Student expectedResult = student3;
        Student actualResult = testStudentCollectionRepository.findById(student3.getId());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findAll() {
        Student expectedResult = (Student) studentList;
        Student actualResult = (Student) testStudentCollectionRepository.findAll();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_removeStudent() {
        List<Student> updatedStudentlist = new ArrayList<>();
        Student expectedResult = (Student) updatedStudentlist;
        boolean actualResult = testStudentCollectionRepository.removeStudent(student2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_clear() {
        testStudentCollectionRepository.clear();
        StudentSequencer.getStudentSequencer();
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        StudentSequencer.setStudentSequencer(0);
    }
}
