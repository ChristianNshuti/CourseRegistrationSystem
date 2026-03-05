package dao;

import entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.*;

public class CourseDAO {

    public void saveCourse(String title,String instructor) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Course course = new Course(title,instructor);
        session.persist(course);
        tx.commit();
        session.close();
    }

    public List<Course> getAllCourses() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Course> courses = session.get("from courses",Course.class).list();
        session.close();
        return courses;
    }

    public Course getCourseById(Long courseId) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Course course = session.get(Course.class,courseId);
        session.close();
        return course;
    }
}