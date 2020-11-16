package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int MadhuId = 2;
            Instructor madhu = session.get(Instructor.class, MadhuId);

            System.out.println("Found instructor: " + madhu);

            if(madhu != null) {
                session.delete(madhu);
            }

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
