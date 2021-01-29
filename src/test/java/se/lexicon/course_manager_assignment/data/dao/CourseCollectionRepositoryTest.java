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

    private CourseCollectionRepository testCourseCollectionRepository;

    List<Course> courseList = new ArrayList<>();
    Course course1 = new Course("Java", LocalDate.of(2021, 02, 11), 15);
    Course course2 = new Course("C++", LocalDate.of(2021, 02, 24), 16);
    Course course3 = new Course("Ruby", LocalDate.of(2021, 03, 05), 14);
    Course course4 = new Course("Industry English", LocalDate.of(2021, 02, 24), 12);

    List<Student> studentList = new ArrayList<>();
    Student student1 = new Student(1, "Christer", "ch.sv@gmail.com", "Gamla Landsvägen 2");
    Student student2 = new Student(2, "Anton", "ant.sv@gmail.com", "Violvägen 12");
    Student student3 = new Student(3, "Andreas", "and.sv@gmail.com", "Vallby 116");


    @Autowired
    private CourseDao testObject;

    @Test
    @DisplayName("Test context successfully setup")
    void context_loads() {
        assertFalse(testObject == null);
    }

    //Write your tests here
    @Test
    public void test_createCourse() {
        Course expectedResult = course1;
        Course actualResult = testCourseCollectionRepository.createCourse(course1.getCourseName(), course1.getStartDate(), course1.getWeekDuration());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findById() {
        Course expectedResult = course2;
        Course actualResult = testCourseCollectionRepository.findById(course2.getId());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findByNameContains() {
        Course expectedResult = course3;
        Course actualResult = (Course) testCourseCollectionRepository.findByNameContains(course3.getCourseName());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findByDateBefore() {
        Course expectedResult = course4;
        Course actualResult = (Course) testCourseCollectionRepository.findByDateBefore(LocalDate.of(2021, 02, 24));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findByDateAfter() {
        Course expectedResult = course3;
        Course actualResult = (Course) testCourseCollectionRepository.findByDateAfter(LocalDate.of(2021, 03, 05));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findAll() {
        Course expectedResult = (Course) courseList;
        Course actualResult = (Course) testCourseCollectionRepository.findAll();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_findByStudentId() {
        Student expectedResult = (Student) studentList;
        Student actualResult = (Student) testCourseCollectionRepository.findByStudentId(2);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void test_removeCourse() {
        List<Course> updatedCourselist = new ArrayList<>();
        Course expectedResult = (Course) updatedCourselist;
        boolean actualResult = testCourseCollectionRepository.removeCourse(course4);
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void tearDown() {
        testObject.clear();
        CourseSequencer.setCourseSequencer(0);
    }
}