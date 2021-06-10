package com.DAO;

import com.Model.ClazzEntity;
import com.Model.SubjectEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    private static SessionFactory factory;

    public static List<ClazzEntity> getAllClass(){
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
            String sql = "From ClazzEntity ";
            Query query = session.createQuery(sql);
            List<ClazzEntity> clazz = query.list();

            tx.commit();
            session.close();
            return clazz;
        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static String[] getAllClassName(){
        String[] result = {""};
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
            String sql = "select c.className From ClazzEntity c";
            Query query = session.createQuery(sql);
            List<String> clazzNames = query.list();

            tx.commit();
            session.close();
            String[] classNames = clazzNames.toArray(new String[0]);
            return classNames;
        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return result;
    }
}
