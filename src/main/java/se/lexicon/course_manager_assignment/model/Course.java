package se.lexicon.course_manager_assignment.model;

import se.lexicon.course_manager_assignment.data.sequencers.CourseSequencer;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

public class Course {

    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private Collection<Student> students;

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        id = CourseSequencer.nextCourseId();
    }

    public Course(int id, String courseName, LocalDate startDate, int weekDuration, Collection<Student> students) {
        this.id = CourseSequencer.nextCourseId();
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public boolean enrollStudent(Student student) {
        boolean isEnrolled = false;
        for (Student result : students) {
            if (result.equals(student)) {
                students.add(student);
                isEnrolled = true;
            }
        }
        return isEnrolled;
    }

    public boolean unenrollStudent(Student student) {
        boolean isUnenrolled = false;
        for (Student result : students) {
            if (result.equals(student)) {
                students.remove(student);
                isUnenrolled = true;
            }
        }
        return isUnenrolled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}

