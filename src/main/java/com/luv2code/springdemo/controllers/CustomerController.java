package com.luv2code.springdemo.controllers;

import com.luv2code.springdemo.models.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //add initbinder to remove leading and triling whitespaces from strings
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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

        System.out.println("Binding result: " + bindingResult);

        System.out.println("\n\n\n\n");

        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        // log the input data
        System.out.println("theCustomer: " + theCustomer.getFirstName()
                + " " + theCustomer.getLastName());

        return "customer-confirmation";
    }

}
