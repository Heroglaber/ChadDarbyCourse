package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudent {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int studentId = 2;
            Student student = session.get(Student.class, studentId);
            System.out.println("Loaded student: " + student);

            Course maryCourse1 = new Course("Rubik`s - How to solve rubik`s Cube");
            Course maryCourse2 = new Course("Atari 2600 - Game Development");

            student.addCourse(maryCourse1);
            student.addCourse(maryCourse2);
            System.out.println("Saving the courses ...");

            session.save(maryCourse1);
            session.save(maryCourse2);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}