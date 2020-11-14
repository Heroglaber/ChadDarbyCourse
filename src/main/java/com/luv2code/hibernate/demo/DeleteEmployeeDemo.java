package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("director.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int employeeId = 2;

            session.beginTransaction();

            System.out.println("Deleting the employee...");
            Employee employee = session.get(Employee.class, employeeId);

            System.out.println("Deleting employee: " + employee);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("DONE.");
        }
        finally {
            factory.close();
        }
    }
}
