package service;

import dao.StudentDAO;
import entity.Student;

import java.util.*;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public void saveStudent(String name,String email) {
        studentDAO.saveStudent(name,email);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(Long studentId) {
        return studentDAO.getStudentById(studentId);
    }

    public void updateStudent(Long studentId,String name,String email) {
        studentDAO.updateStudent(studentId,name,email);
    }

    public void deleteStudent(Long studentId) {
        studentDAO.deleteStudent(studentId);
    }
}