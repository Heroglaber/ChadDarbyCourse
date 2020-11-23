package com.luv2code.hibernate.service;

import com.luv2code.hibernate.dao.CustomerDAO;
import com.luv2code.hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        List<Customer> customers = customerDAO.getAll();
        return customers;
    }

    @Override
    @Transactional
    public boolean save(Customer customer) {
        try {
            customerDAO.save(customer);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        Optional<Customer> optionalCustomer = customerDAO.get((long)id);
        Customer customer = optionalCustomer.orElseThrow(() -> new NoSuchElementException("no user with id:" + id));
        return customer;
    }

    @Override
    @Transactional
    public boolean deleteCustomer(Customer customer) {
        try {
            customerDAO.delete(customer);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
