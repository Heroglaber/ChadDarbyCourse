package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);

            //query students: lastName='Doe' OR firstName='Daffy'
            theStudents = session.createQuery("from Student s where" +
                    " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
            System.out.println("\n\nStudents who have lastName='Doe' OR firstName='Daffy'");
            displayStudents(theStudents);

            //query students: where email like '%gmail.com'
            theStudents = session.createQuery("from Student s where" +
                    " s.email LIKE '%gmail.com'").getResultList();
            System.out.println("\n\nStudents where email like '%gmail.com'");
            displayStudents(theStudents);

            session.getTransaction().commit();
            System.out.println("DONE.");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student student : theStudents) {
            System.out.println(student);
        }
    }
}
