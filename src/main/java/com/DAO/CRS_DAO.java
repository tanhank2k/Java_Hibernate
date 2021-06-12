package com.DAO;

import com.Model.CourseregistrationsessionEntity;
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

public class CRS_DAO {
    private static SessionFactory factory;

    public static List<CourseregistrationsessionEntity> getAllSession(){
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
            String sql = "From CourseregistrationsessionEntity ";
            Query query = session.createQuery(sql);
            List<CourseregistrationsessionEntity> subject = query.list();

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

    public static void AddNewSession(String CRSName, Date start, Date end){
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

            int idSemester = (int) SemesterDAO.getSemesterCurr()[0];
            String sql = "insert into Courseregistrationsession(NameCRS, dateStart, dateEnd, idSemester)values(?,?,?,?)";
            Query query = session.createSQLQuery(sql);

            query.setParameter(1,CRSName);
            query.setParameter(2,start);
            query.setParameter(3,end);
            query.setParameter(4,idSemester);
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

    public static void ResetPassword(int ID){
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


            String sql_update = "UPDATE Subject Set password = 123456789 " +
                    "WHERE id=:id";
            Query query = session.createSQLQuery(sql_update);
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
}
