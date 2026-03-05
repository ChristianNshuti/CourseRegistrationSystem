package service;

import dao.CourseDAO;
import entity.Course;

import java.util.List;

public class CourseService {

    private CourseDAO courseDAO = new CourseDAO();

    public void addCourse(String title, String instructor) {
        courseDAO.saveCourse(title, instructor);
    }

    public Course getAllCourses() {
        return courseDAO.getAllCourses();
    }

    public Course getCourseById(Long courseId) {
        return courseDAO.getCourseById(courseId);
    }

    public void updateCourse(Long courseId, String name,String instructor) {
        courseDAO.updateCourse(courseId,name,instructor);
    }

    public void deleteCourse(Long courseId) {
        courseDAO.deleteCourse(courseId);
    }

}