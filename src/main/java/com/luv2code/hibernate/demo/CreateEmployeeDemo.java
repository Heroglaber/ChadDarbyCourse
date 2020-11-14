package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;

public class CreateEmployeeDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("director.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new employee object...");

            String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = null;
            try {
                theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Employee employee = new Employee("Vladislav", "Shelobaev", "HSE", theDateOfBirth);

            session.beginTransaction();

            System.out.println("Saving the employee...");
            session.save(employee);

            System.out.println("Send commit...");
            session.getTransaction().commit();
            System.out.println("DONE.");
        }
        finally {
            factory.close();
        }
    }
}
