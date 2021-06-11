package com.company;
import com.DAO.ClassDAO;
import com.DAO.SemesterDAO;
import com.Model.ClazzEntity;
import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jboss.jandex.ClassExtendsTypeTarget;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.List;


public class Main {
    //private static  SessionFactory factory;
    public static void main(String[] args) {
	 try {
         List<Object[]> list = ClassDAO.SearchClass("Class1");
         for (int i=0; i<list.size(); i++){
             System.out.println(list.get(i)[0]);
             System.out.println(list.get(i)[1]);
             System.out.println(list.get(i)[2]);
             System.out.println(list.get(i)[3]);
             System.out.println(list.get(i)[4]);
         }

     }catch (Throwable ex){
	     ex.printStackTrace();
     }


    }



}
