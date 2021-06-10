package com.DAO;
import com.Model.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SemesterDAO {
    private static SessionFactory factory;

    public static List<SemesterEntity> getAllSemester(){
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
            String sql = "From SemesterEntity";
            Query query = session.createQuery(sql);
            List<SemesterEntity> semester = query.list();

            tx.commit();
            factory.close();
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
