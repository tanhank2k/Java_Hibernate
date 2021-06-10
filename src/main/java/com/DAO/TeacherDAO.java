package com.DAO;

import com.Model.SemesterEntity;
import com.Model.TeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    private static SessionFactory factory;

    public static List<TeacherEntity> getAllSTeacher(){
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
            String sql = "From TeacherEntity";
            Query query = session.createQuery(sql);
            List<TeacherEntity> semester = query.list();

            tx.commit();
            return semester;
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
