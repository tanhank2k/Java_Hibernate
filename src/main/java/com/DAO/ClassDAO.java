package com.DAO;

import com.Model.ClazzEntity;
import com.Model.SubjectEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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

    public static void AddNewClass(String ClassName){
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
            String sql = "insert into Class(className, totalStudent, totalMale, totalFemale)values(?,0,0,0)";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,ClassName);

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

    public static void DeleteClass(int id){
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
            String sql = "DELETE FROM Class WHERE id=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,id);

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

    public static void UpdateClass(int ID, String ClassName){
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

            String sql_total = "Select Count(Student.id)  From Class join Student on Class.id = Student.class WHERE Class.id =:id";
            SQLQuery query = session.createSQLQuery(sql_total);
            query.setParameter("id",ID);
            List result =  query.list();
            int total = ((BigInteger) result.get(0)).intValue();

            String sql_male = "Select Count(Student.id)  From Class join Student on Class.id = Student.class WHERE Class.id =:id and Student.Gender = 'Male'";
            query = session.createSQLQuery(sql_male);
            query.setParameter("id",ID);
            result =  query.list();
            int male =  ((BigInteger) result.get(0)).intValue();

            String sql_female = "Select Count(Student.id)  From Class join Student on Class.id = Student.class WHERE Class.id =:id and Student.Gender = 'Female';";
            query = session.createSQLQuery(sql_female);
            query.setParameter("id",ID);
            result =  query.list();
            int female =   ((BigInteger) result.get(0)).intValue();

            String sql_update = "UPDATE Class Set className=:name,totalStudent=:total,totalMale=:male,totalFemale=:female WHERE id=:id";
            query = session.createSQLQuery(sql_update);
            query.setParameter("name",ClassName);
            query.setParameter("total",total);
            query.setParameter("male",male);
            query.setParameter("female",female);
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

    public static List<Object[]> SearchClass(String ClassName){
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
            String sql = "Select Class.id,Class.className,Class.totalStudent, Class.totalMale, Class.totalFemale From Class where Class.className like :name ";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("name","%" + ClassName + "%");
            List<Object[]> result = query.list();



            tx.commit();
            factory.close();

            return result;
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
