package com.luv2code.hibernate.dao;

import com.luv2code.hibernate.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAO implements DAO<Customer> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Customer> get(long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public List<Customer> getAll() {

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        Query<Customer> query =
                session.createQuery("from Customer", Customer.class);

        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void update(Customer customer, String[] params) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
