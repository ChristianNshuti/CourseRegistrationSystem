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
}