package service;

import dao.RegistrationDAO;
import entity.Registration;


import java.util.*;

public class RegistrationService {

    private final RegistrationDAO registrationDAO = new RegistrationDAO();

    public void registerStudent(Long studentId,Long courseId) {
        registrationDAO.registerStudent(studentId,courseId);
    }

    public List<Registration> getAllRegistrations() {
        return registrationDAO.getAllRegistrations();
    }

    public List<Registration> getCoursesByStudent(Long studentId) {
        return registrationDAO.getCoursesByStudent(studentId);
    }

    public List<Registration> getStudentsByCourse(Long courseId) {
        return registrationDAO.getStudentsByCourse(courseId);
    }
}