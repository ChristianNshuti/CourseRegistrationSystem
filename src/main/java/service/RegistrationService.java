package service;

import dao.RegistrationDAO;
import entity.Registration;
import entity.Course;
import entity.Student;

import java.util.*;

public class RegistrationService {

    private final RegistrationDAO registrationDAO = new RegistrationDAO();

    public void registerStudent(Long studentId,Long courseId) {
        registrationDAO.registerStudent(studentId,courseId);
    }

    public List<Registration> getAllRegistrations() {
        return registrationDAO.getAllRegistrations();
    }

    public List<Course> getCoursesByStudent(Long studentId) {
        return registrationDAO.getCoursesByStudent(studentId);
    }

    public List<Student> getStudentsByCourse(Long courseId) {
        return registrationDAO.getStudentsByCourse(courseId);
    }
}