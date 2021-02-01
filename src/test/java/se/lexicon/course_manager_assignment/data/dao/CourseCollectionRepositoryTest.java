package se.lexicon.course_manager_assignment.data.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = {CourseCollectionRepository.class})
public class CourseCollectionRepositoryTest {

    @Autowired
    private CourseDao testObject;

    List<Course> courseList = new ArrayList<>();
    Course course1 = new Course(1,"Java", LocalDate.of(2021, 02, 11), 15);
    Course course2 = new Course(2,"C++", LocalDate.of(2021, 02, 24), 16);
    Course course3 = new Course(3,"Ruby", LocalDate.of(2021, 03, 05), 14);
    Course course4 = new Course(4,"Industry English", LocalDate.of(2021, 02, 24), 12);

    List<Student> studentList = new ArrayList<>();
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
    public void test_createCourse() {
        Course expectedResult = testObject.createCourse("Java", LocalDate.of(2021,02,11),15);
        Course actualResult = course1;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void test_findById() {
    }
    @Test
    public void test_findByNameContains() {
    }
    @Test
    public void test_findByDateBefore() {
    }
    @Test
    public void test_findByDateAfter() {
    }
    @Test
    public void test_findAll() {
    }
    @Test
    public void test_findByStudentId() {
    }
    @Test
    public void test_removeCourse() {
    }
    @AfterEach
    void tearDown() {
        testObject.clear();
        CourseSequencer.setCourseSequencer(0);
    }
}