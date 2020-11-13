package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

            session.beginTransaction();

            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            System.out.println("Send commit...");
            session.getTransaction().commit();

            //Read student object
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();
            Student duffy = session.get(Student.class, 3);
            session.getTransaction().commit();

            System.out.println("Student got from db: " + duffy);

            System.out.println("DONE.");
        }
        finally {
            factory.close();
        }
    }
}
