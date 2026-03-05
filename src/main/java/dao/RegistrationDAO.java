package dao;

import entity.Course;
import entity.Student;
import entity.Registration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class RegistrationDAO {

    public void registerStudent(Long studentId, Long courseId) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, studentId);
        Course course = session.get(Course.class, courseId);

        if (student != null && course != null) {
            Registration registration = new Registration(student, course);
            session.save(registration);
            System.out.println("Student registered successfully!");
        } else {
            System.out.println("Student or Course not found!");
        }

        tx.commit();
        session.close();
    }

    public List<Registration> getAllRegistrations() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List <Registration> list = session.createQuery("from Registration", Registration.class).list();

        session.close();
        return list;

    }

    public List<Registration> getCoursesByStudent(Long studentId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Registration> list = session.createQuery("from Registration r where r.student.id = :sid", Registration.class)
                .setParameter("sid", studentId)
                .list();

        session.close();
        return list;
    }

    // View students in a course
    public List<Registration> getStudentsByCourse(Long courseId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Registration> list = session.createQuery("from Registration r where r.course.id = :cid", Registration.class)
                .setParameter("cid", courseId)
                .list();

        session.close();
        return list;
    }
}