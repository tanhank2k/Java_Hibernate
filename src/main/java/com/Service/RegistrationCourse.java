package com.Service;

import com.DAO.SemesterDAO;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationCourse {
    private static SessionFactory factory;

    public static List<Object[]> getAllCourseInCurr_SRC(String idStudent){
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
            String sql = "Select* From Course course " +
                    "Where course.idSemester = :semester and course.id not in " +
                    "(Select c.id From Course c join Studentregistercourse s on c.id = s.idCourse " +
                    "where s.idStudent = :id) and " +
                    "course.subjectCode not in " +
                    "(Select c.subjectCode " +
                    "From Course c join Studentregistercourse s on c.id = s.idCourse " +
                    "where s.idStudent = :id)";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("id",idStudent);
            query.setParameter("semester", idSemester);
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

    public static List<Object[]> getCourseRegisteredCurr_SRC(String idStudent){
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
            String sql = "Select* From Course course " +
                    "Where course.idSemester = :semester and course.id in " +
                    "(Select c.id From Course c join Studentregistercourse s on c.id = s.idCourse " +
                    "where s.idStudent = :id) ;";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter("id",idStudent);
            query.setParameter("semester", idSemester);
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
