package com.DAO;

import com.Model.ClazzEntity;
import com.Model.CourseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private static SessionFactory factory;

    public static List<CourseEntity> getAllCourse(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "From CourseEntity ";
            Query query = session.createQuery(sql);
            List<CourseEntity> courses = query.list();

            tx.commit();
            session.close();
            return courses;
        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }
}
