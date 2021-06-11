package com.DAO;

import com.Model.SemesterEntity;
import com.Model.TeacherEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherDAO {
    private static SessionFactory factory;

    public static boolean SignIn(String username, String password){
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
            String sql_idClass = "";
            String sql = "SELECT *  From teacher  WHERE teacher.username = :user and teacher.password =:pass";

            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("user",username);
            query.setParameter("pass",password);
            List<Object[]> results = query.list();
            tx.commit();
            factory.close();

            if (results.size()>0){
                return true;
            }



        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return false;
    }

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

    public static void AddNewTeacher(String StudentName, Date DoB, String Address, String Phone, String Position,String Username, String Password){
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

            String sql = "insert into Teacher(TeacherName, DateofBitrh, Address, Phone,Position, Username, Password)values(?,?,?,?,?,?,?)";
            Query query = session.createSQLQuery(sql);

            query.setParameter(1,StudentName);
            query.setParameter(2,DoB);
            query.setParameter(3,Address);
            query.setParameter(4,Phone);
            query.setParameter(5,Position);
            query.setParameter(6,Username);
            query.setParameter(7,Password);

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

    public static void DeleteTeacher(int ID){
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
            String sql = "DELETE FROM Teacher WHERE id=?";
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

    public static void UpdateTeacher(String ID, String StudentName, Date DoB, String Address, String Phone, String Position, String Username){
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

            String sql_update = "UPDATE Teacher " +
                    "Set teacherName =:name,dateOfBitrh=:dob, address=:address,phone=:phone,position=:position ,username=:username " +
                    "WHERE id=:id";
            Query query = session.createSQLQuery(sql_update);
            query.setParameter("name",StudentName);
            query.setParameter("dob",DoB);
            query.setParameter("address",Address);
            query.setParameter("phone",Phone);
            query.setParameter("username",Username);
            query.setParameter("position",Position);
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

    public static List<Object[]> SearchTeacher(String TeachName){
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
            String sql_idClass = "";
            String sql = "";

                sql = "SELECT teacher.id,teacher.teacherName," +
                        " teacher.dateOfBitrh, teacher.address,teacher.phone,teacher.position,teacher.username,teacher.Password " +
                        "From teacher " +
                        "WHERE teacher.teacherName like :name";

                SQLQuery query = session.createSQLQuery(sql);
                query.setParameter("name","%" + TeachName + "%");
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


            String sql_update = "UPDATE Teacher Set password = 123456789 " +
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
