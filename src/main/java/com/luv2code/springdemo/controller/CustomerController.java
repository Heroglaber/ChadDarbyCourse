package com.luv2code.springdemo.controller;

import com.luv2code.hibernate.dao.DAO;
import com.luv2code.hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private DAO<Customer> customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> customers = customerDAO.getAll();

        model.addAttribute("customers", customers);

        return "list-customers";
    }


}
