package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int studentId = 1;

            Student student = session.get(Student.class, studentId);
            student.setFirstName("Scooby");

            session.getTransaction().commit();

            System.out.println("Creating new session...");
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Quering update...");
            session.createQuery("update Student set email=REPLACE(email, SUBSTRING(email,INSTR(email,'@')+1),\n" +
                    "'gmail.com')").executeUpdate();

            System.out.println("Commit...");
            session.getTransaction().commit();

            System.out.println("DONE.");
        }
        finally {
            factory.close();
        }
    }
}
