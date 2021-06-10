package com.company;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import javax.swing.*;
import java.util.List;

public class Main {
    //private static  SessionFactory factory;
    public static void main(String[] args) {
	 try {
         SessionFactory factory = new Configuration().configure().buildSessionFactory();

         Session session = factory.openSession();
         String hql = "From SemesterEntity";
         Query query = session.createQuery(hql);
         List results = query.list();

         for (var semester:results) {
             System.out.println(semester);
         }
     }catch (Throwable ex){
	     ex.printStackTrace();
     }


    }



}
