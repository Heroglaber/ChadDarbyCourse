package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployeeDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("director.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int employeeId = 1;

            session.beginTransaction();

            System.out.println("Getting the employee...");
            List<Employee> employees = session.createQuery("from Employee e where" +
                    " e.firstName like '%slav'").getResultList();

            for(Employee employee : employees) {
                System.out.println("\n\nEmployee: " + employee);
            }

            //session.getTransaction().commit();
            System.out.println("DONE.");
        }
        finally {
            factory.close();
        }
    }
}
