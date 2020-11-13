package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating 3 students objects...");
            Student tempStudent1 = new Student("John", "Doe", "John@luv2code.com");
            Student tempStudent2 = new Student("Mary", "Public", "Mary@luv2code.com");
            Student tempStudent3 = new Student("Bonita", "Applebaum", "Bonita@luv2code.com");

            session.beginTransaction();

            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            System.out.println("Send commit...");
            session.getTransaction().commit();
            System.out.println("DONE.");
        }
        finally {
            factory.close();
        }
    }
}
