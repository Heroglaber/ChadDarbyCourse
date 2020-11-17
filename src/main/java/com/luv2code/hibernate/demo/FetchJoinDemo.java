package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchJoinDemo {
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

            int theId = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                            "join fetch i.courses " +
                            "where i.id=:theInstructorId",
                    Instructor.class);

            query.setParameter("theInstructorId", theId);

            Instructor instructor = query.getSingleResult();

            System.out.println("luv2code: instructor: " + instructor);

            session.getTransaction().commit();

            session.close();

            System.out.println("luv2code: Courses: " + instructor.getCourses());
        }
        finally {
            session.close();
            factory.close();
        }
    }
}