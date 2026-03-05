package dao;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.*;

public class StudentDAO {
    public void saveStudent(String name,String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = new Student(name,email);
        session.persist(student);
        tx.commit();
        session.close();
    }

    public List<Student> getAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student",Student.class).list();
        session.close();
        return students;
    }

    public Student getStudentById(Long studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class,studentId);
        session.close();
        return student;
    }

    public void updateStudent(Long studentId,String name,String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class,studentId);
        if(student != null) {
            student.setName(name);
            student.setEmail(email);
        }
        tx.commit();
        session.close();
    }

    public void deleteStudent(Long studentId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class,studentId);
        if (student != null) {
            session.remove(student);
        }
        tx.commit();
        session.close();
    }
}