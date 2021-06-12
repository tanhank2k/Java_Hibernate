package com.DAO;

import com.Model.SubjectEntity;
import com.Model.SubjectEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectDAO {
    private static SessionFactory factory;

    public static List<SubjectEntity> getAllSubject(){
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
            String sql = "From SubjectEntity ";
            Query query = session.createQuery(sql);
            List<SubjectEntity> subject = query.list();

            tx.commit();
            return subject;
        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void AddNewSubject(String SubjectName, String SubjectCode, int NoC){
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

            String sql = "insert into Subject(SubjectName, SubjectCode, numberOfCredits)values(?,?,?)";
            Query query = session.createSQLQuery(sql);

            query.setParameter(1,SubjectName);
            query.setParameter(2,SubjectCode);
            query.setParameter(3,NoC);
            query.executeUpdate();

            tx.commit();
            factory.close();

        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }

    }

    public static void DeleteSubject(int ID){
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
            String sql = "DELETE FROM Subject WHERE id=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,ID);

            query.executeUpdate();

            tx.commit();
            factory.close();

        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }

    }
    public static String[] getAllSubCode(){
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
            String sql = "Select SubjectCode  FROM Subject";
            SQLQuery query = session.createSQLQuery(sql);
            List<String> result = query.list();

            String[] str = result.toArray(new String[0]);

            tx.commit();
            factory.close();

            return str;

        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return new String[]{};
    }

    public static void UpdateSubject(String ID, String SubjectName, String SubjectCode, int NoC){
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

            String sql_update = "UPDATE Subject " +
                    "Set SubjectName =:name,SubjectCode=:code, numberofcredits=:noc " +
                    "WHERE id=:id";
            Query query = session.createSQLQuery(sql_update);
            query.setParameter("name",SubjectName);
            query.setParameter("code",SubjectCode);
            query.setParameter("noc",NoC);
            query.setParameter("id",ID);
            query.executeUpdate();

            tx.commit();
            factory.close();

        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }

    }

    public static List<Object[]> SearchSubject(String SubjectName){
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
            String sql = "";

            sql = "SELECT Subject.id,Subject.SubjectName," +
                    " Subject.SubjectCode, Subject.numberofcredits " +
                    "From Subject " +
                    "WHERE Subject.SubjectName like :name";

            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("name","%" + SubjectName + "%");
            List<Object[]> results = query.list();
            tx.commit();
            factory.close();

            return results;



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
