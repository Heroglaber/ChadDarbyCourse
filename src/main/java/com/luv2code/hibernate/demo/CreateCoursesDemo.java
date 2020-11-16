package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateCoursesDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 2;
            Instructor instructor = session.get(Instructor.class, theId);

            Course course1 = new Course("Air Guitar = The Ultimate Guide2");

            Course course2 = new Course("The Pinball Masterclass2");

//            List<Course> guitarCourses = session.createQuery("from Course c where title = 'Air Guitar = The Ultimate Guide'")
//                    .getResultList();
//
//            List<Course> pinballCourses = session.createQuery("from Course c where title = 'The Pinball Masterclass'")
//                    .getResultList();

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}