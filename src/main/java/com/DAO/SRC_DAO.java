package com.DAO;

import com.Model.CourseEntity;
import com.Model.StudentregistercourseEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SRC_DAO {

    private static SessionFactory factory;

    public static List<StudentregistercourseEntity> getAllCourse(){
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
            String sql = "From StudentregistercourseEntity ";
            Query query = session.createQuery(sql);
            List<StudentregistercourseEntity> courses = query.list();

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

    public static List<Object[]> getStudentInCourse(String idCourse){
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

            String sql_idClass = "Select Course.id  From Course WHERE Course.id = ?";
            SQLQuery query = session.createSQLQuery(sql_idClass);
            query.setParameter(1,idCourse);
            List result =  query.list();
            int id = (int) result.get(0);


            String sql = "SELECT Studentregistercourse.MSSV,Studentregistercourse.studentName, Studentregistercourse.subjectCode," +
                    " Studentregistercourse.subjectName, Studentregistercourse.teacherName,Studentregistercourse.timeOnSchool,Studentregistercourse.timeRegister" +
                    " From Studentregistercourse join Course on Studentregistercourse.idCourse = :id and Course.id =:id";
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

    public static void AddNewSRC(int idStudent, String subCode, String idCourse){
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
            query.setParameter(1,subCode);
            List<Object[]> result =  query.list();
            String code = (String) result.get(0)[0];
            String subName = (String) result.get(0)[1];
            int NoC = (int) result.get(0)[2];
            int idSub = (int) result.get(0)[3];

            Object[] semesterCurr =  SemesterDAO.getSemesterCurr();
            String semCur = (String) semesterCurr[4];
            int year = (int) semesterCurr[5];
            int idSem = (int) semesterCurr[0];

            String sql_course = "Select teacherName, roomName, dateonschool, period ,studentMaximum, CRS From Course Where id=:id";
            query = session.createSQLQuery(sql_course);
            query.setParameter("id",idCourse);

            List<Object[]> course = query.list();
            String TeacherName = (String) course.get(0)[0];
            String Room = (String) course.get(0)[1];
            String DateOnSchool = (String) course.get(0)[2];
            int Period = (int) course.get(0)[3];
            String strPeriod = null;
            switch (Period){
                case 1:
                    strPeriod = "7:30 – 9:30";
                    break;
                case 2:
                    strPeriod = "9:30 – 11:30";
                    break;
                case 3:
                    strPeriod = "13:30 – 15:30";
                    break;
                case 4:
                    strPeriod = "15:30 – 17:30";
                    break;
                default:
                    break;

            }
            int StudentMax = (int) course.get(0)[4];
            int idSession = (int) course.get(0)[5];

            String sql_student = "Select MSSV, studentName From Student Where id=:id";
            query = session.createSQLQuery(sql_student);
            query.setParameter("id",idStudent);
            List<Object[]> student = query.list();

            String MSSV= (String) student.get(0)[0];
            String studentName = (String) student.get(0)[1];


            String sql_insert =" insert into Studentregistercourse(MSSV, studentName, subjectCode, subjectName, " +
            "teacherName, timeOnSchool , timeRegister,idSemester, idStudent, idSession,idCourse)values(?,?,?,?,?,?,?,?,?,?,?)";

            query = session.createSQLQuery(sql_insert);
            query.setParameter(1,MSSV);
            query.setParameter(2,studentName);
            query.setParameter(3,subCode);
            query.setParameter(4,subName);
            query.setParameter(5,TeacherName);
            query.setParameter(6,DateOnSchool + " ("+strPeriod+")");
            query.setParameter(7,java.util.Calendar.getInstance().getTime());
            query.setParameter(8,idSem);
            query.setParameter(9,idStudent);
            query.setParameter(10,idSession);
            query.setParameter(11,idCourse);

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
