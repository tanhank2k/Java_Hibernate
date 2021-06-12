package com.DAO;
import com.Model.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
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

    public static void AddNewSemester(String semester, int year, Date dateStart, Date dateEnd){
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
            String sql = "insert into Semester(semesterName,year,dateStart,dateEnd, ispresent)values(?,?,?,?,false )";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,semester);
            query.setParameter(2,year);
            query.setParameter(3,dateStart);
            query.setParameter(4,dateEnd);

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

    public static void DeleteSemester(String semester, int year, Date dateStart, Date dateEnd){
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
            String sql = "DELETE FROM Semester WHERE semesterName=? and year=? and dateStart=? and dateEnd=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,semester);
            query.setParameter(2,year);
            query.setParameter(3,dateStart);
            query.setParameter(4,dateEnd);
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

    public static void UpdateSemester(int ID,String semester, int year, Date dateStart, Date dateEnd){
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
            String sql = "UPDATE Semester Set semesterName=:name,year=:year,dateStart=:start,dateEnd=:end WHERE id=:id";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("name",semester);
            query.setParameter("year",year);
            query.setParameter("start",dateStart);
            query.setParameter("end",dateEnd);
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

    public static void SetPresentSemester(int ID){
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
            String sql = "UPDATE Semester Set isPresent = false";
            SQLQuery query = session.createSQLQuery(sql);
            query.executeUpdate();

            sql = "UPDATE Semester Set isPresent = true where id=:id";
            query= session.createSQLQuery(sql);
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

    public static Object[] getSemesterCurr(){
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
            String sql = "SELECT * From Semester Where  isPresent = true";
            Query query= session.createSQLQuery(sql);

            List<Object[]> result =  query.list();


            tx.commit();
            factory.close();
            if (result.size()>0){
                return result.get(0);
            }

        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return new Object[] {} ;
    }

}

