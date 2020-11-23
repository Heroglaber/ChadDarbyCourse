package com.luv2code.hibernate.service;

import com.luv2code.hibernate.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public boolean save(Customer customer);

    Customer getCustomer(int id);

    public boolean deleteCustomer(Customer customer);
}
