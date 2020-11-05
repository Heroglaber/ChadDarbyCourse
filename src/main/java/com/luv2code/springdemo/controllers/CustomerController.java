package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/showForm")
    public String showForm(Model theModel) {

        // create a student object
        Customer theCustomer = new Customer();

        // add student object to the model
        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        // log the input data
        System.out.println("theCustomer: " + theCustomer.getFirstName()
                + " " + theCustomer.getLastName());

        return "customer-confirmation";
    }

}
