package com.luv2code.hibernate.dao;

import com.luv2code.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAO implements DAO<Customer> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Customer> get(long id) {

        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, (int)id);
        return Optional.of(customer);
    }

    @Override
    public List<Customer> getAll() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query =
                session.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public void update(Customer customer, String[] params) {

    }

    @Override
    public void delete(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
    }
}
