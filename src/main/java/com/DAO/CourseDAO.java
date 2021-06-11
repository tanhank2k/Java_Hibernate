package com.DAO;

import com.Model.ClazzEntity;
import com.Model.CourseEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
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

    public static List<Object[]> getAllCourseInCurr(){
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
            String sql = "Select* From Course Where idSemester = ?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(1,idSemester);
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
    public static void AddNewCourse(String SubjectCode, String TeacherName, String Room, String DateOnSchool, int Period,  int StudentMax){
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
            String sql_subject = "Select Subject.SubjectCode, Subject.SubjectName,Subject.numberofcredits, Subject.id From Subject WHERE Subject.SubjectCode = ?";
            SQLQuery query = session.createSQLQuery(sql_subject);
            query.setParameter(1,SubjectCode);
            List<Object[]> result =  query.list();
            String code = (String) result.get(0)[0];
            String subName = (String) result.get(0)[1];
            int NoC = (int) result.get(0)[2];
            int idSub = (int) result.get(0)[3];

            Object[] semesterCurr =  SemesterDAO.getSemesterCurr();
            String semCur = (String) semesterCurr[4];
            int year = (int) semesterCurr[5];
            int idSem = (int) semesterCurr[0];

            String sql = "insert into Course(subjectCode, subjectName, numberofcredits, " +
                    "teacherName, roomName, dateonschool, period , idSemester, idSubject,studentMaximum)values(?,?,?,?,?,?,?,?,?,?)";
            query = session.createSQLQuery(sql);
            query.setParameter(1,code);
            query.setParameter(2,subName);
            query.setParameter(3,NoC);
            query.setParameter(4,TeacherName);
            query.setParameter(5,Room);
            query.setParameter(6,DateOnSchool);
            query.setParameter(7,Period);
            query.setParameter(8,idSem);
            query.setParameter(9,idSub);
            query.setParameter(10,StudentMax);

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

    public static void DeleteCourse(String ID){
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
            String sql = "DELETE FROM Course WHERE id=?";
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



    public static List<Object[]> SearchCourse(String Course){
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

            String sql = "SELECT * " +
                        "From Course " +
                        "WHERE Course.subjectCode like :name or Course.SubjectName like:name";

                SQLQuery query = session.createSQLQuery(sql);
                query.setParameter("name","%" + Course + "%");
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
