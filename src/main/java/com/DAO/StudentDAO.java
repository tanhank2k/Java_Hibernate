package com.DAO;

import com.Model.CourseEntity;
import com.Model.StudentEntity;
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

public class StudentDAO {
    private static SessionFactory factory;

    public static List<StudentEntity> getAllStudent(){
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
            String sql = "From StudentEntity ";
            Query query = session.createQuery(sql);
            List<StudentEntity> students = query.list();

            tx.commit();
            session.close();
            return students;
        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<Object[]> getStudentInClass(String ClassName){
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

            String sql_idClass = "Select Class.id  From Class WHERE Class.className = ?";
            SQLQuery query = session.createSQLQuery(sql_idClass);
            query.setParameter(1,ClassName);
            List result =  query.list();
            int id = (int) result.get(0);


            String sql = "SELECT Student.MSSV,Student.studentName, Student.Gender," +
                    " Student.dateOfBitrh, Student.address,Student.phone,Class.className,Student.username,Student.Password " +
                    "From Student join Class on Student.class = :id and Class.id =:id";
            query = session.createSQLQuery(sql);
            query.setParameter("id",id);

            query.list();
            List<Object[]> students = query.list();


            tx.commit();
            session.close();
            return students;
        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void AddNewStudent(String MSSV, String StudentName, String ClassName, String Gender, Date DoB, String Address, String Phone, String Username, String Password){
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
            String sql_idClass = "Select Class.id  From Class WHERE Class.className = ?";
            SQLQuery query = session.createSQLQuery(sql_idClass);
            query.setParameter(1,ClassName);
            List result =  query.list();
            int id = (int) result.get(0);

            String sql = "insert into Student(MSSV, StudentName, class, Gender, DateofBitrh, Address, Phone, Username, Password)values(?,?,?,?,?,?,?,?,?)";
            query = session.createSQLQuery(sql);
            query.setParameter(1,MSSV);
            query.setParameter(2,StudentName);
            query.setParameter(3,id);
            query.setParameter(4,Gender);
            query.setParameter(5,DoB);
            query.setParameter(6,Address);
            query.setParameter(7,Phone);
            query.setParameter(8,Username);
            query.setParameter(9,Password);

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

    public static void DeleteStudent(String MSSV){
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
            String sql = "DELETE FROM Student WHERE MSSV=?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,MSSV);

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

    public static void UpdateStudent(String MSSV,String StudentName, String ClassName, String Gender, Date DoB, String Address, String Phone, String Username){
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
            String sql_idClass = "Select Class.id  From Class WHERE Class.className = ?";
            SQLQuery query = session.createSQLQuery(sql_idClass);
            query.setParameter(1,ClassName);
            List result =  query.list();
            int id = (int) result.get(0);

            String sql_update = "UPDATE Student " +
                    "Set studentName =:name, Gender=:gender,dateOfBitrh=:dob, address=:address,phone=:phone,username=:username " +
                    "WHERE MSSV=:id";
            query = session.createSQLQuery(sql_update);
            query.setParameter("name",StudentName);
            query.setParameter("gender",Gender);
            query.setParameter("dob",DoB);
            query.setParameter("address",Address);
            query.setParameter("phone",Phone);
            query.setParameter("username",Username);
            query.setParameter("id",MSSV);
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
    public static void UpdateStudentPass(String MSSV,String StudentName, String ClassName, String Gender, Date DoB, String Address, String Phone, String Username,String pass){
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
            String sql_idClass = "Select Class.id  From Class WHERE Class.className = ?";
            SQLQuery query = session.createSQLQuery(sql_idClass);
            query.setParameter(1,ClassName);
            List result =  query.list();
            int id = (int) result.get(0);

            String sql_update = "UPDATE Student " +
                    "Set studentName =:name, Gender=:gender,dateOfBitrh=:dob, address=:address,phone=:phone,username=:username, password=:pass " +
                    "WHERE MSSV=:id";
            query = session.createSQLQuery(sql_update);
            query.setParameter("name",StudentName);
            query.setParameter("gender",Gender);
            query.setParameter("dob",DoB);
            query.setParameter("address",Address);
            query.setParameter("phone",Phone);
            query.setParameter("username",Username);
            query.setParameter("id",MSSV);
            query.setParameter("pass",pass);
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

    public static List<Object[]> SearchStudent(String StudentName, String ClassName){
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
            if (ClassName.equals("")){
                sql = "SELECT Student.MSSV,Student.studentName, Student.Gender," +
                        " Student.dateOfBitrh, Student.address,Student.phone,Class.className,Student.username,Student.Password " +
                        "From Student join Class on Student.class = Class.id " +
                        "WHERE Student.studentName like :name";

                SQLQuery query = session.createSQLQuery(sql);
                query.setParameter("name","%" + StudentName + "%");
                List<Object[]> results = query.list();
                tx.commit();
                factory.close();

                return results;

            }else {
                sql_idClass = "Select Class.id  From Class WHERE Class.className = ?";
                sql = "SELECT Student.MSSV,Student.studentName, Student.Gender," +
                        " Student.dateOfBitrh, Student.address,Student.phone,Class.className,Student.username,Student.Password " +
                        "From Student join Class on Student.class = :id and Class.id =:id " +
                        "WHERE Student.studentName like :name";
                SQLQuery query = session.createSQLQuery(sql_idClass);
                query.setParameter(1,ClassName);
                List result =  query.list();
                int id = (int) result.get(0);



                query = session.createSQLQuery(sql);
                query.setParameter("id",id);
                query.setParameter("name","%" + StudentName + "%");
                List<Object[]> results = query.list();
                tx.commit();
                factory.close();

                return results;
            }
        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }


        return new ArrayList<>();

    }

    public static void ResetPassword(String MSSV){
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


            String sql_update = "UPDATE Student Set password = 123456789 " +
                    "WHERE MSSV=:id";
            Query query = session.createSQLQuery(sql_update);
            query.setParameter("id",MSSV);
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

    public static Object[] SignIn(String username, String password){
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
            String sql = "SELECT *  From student  WHERE student.username = :user and student.password =:pass";

            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("user",username);
            query.setParameter("pass",password);
            List<Object[]> results = query.list();
            tx.commit();
            factory.close();

            if (results.size()>0){
                return results.get(0);
            }


        }
        catch (Throwable ex){
            if (tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }
        return new Object[]{};



    }
    public static Object[] getStudent(int id){
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
            String sql = "SELECT * From student Where  id = :id";
            Query query= session.createSQLQuery(sql);
            query.setParameter("id", id);
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
