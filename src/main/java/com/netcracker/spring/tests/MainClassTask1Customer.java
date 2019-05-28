package com.netcracker.spring.tests;

import com.netcracker.spring.config.SpringConfig;
import com.netcracker.spring.entity.Customer;
import com.netcracker.spring.service.customer.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClassTask1Customer {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Testing Customer
        System.out.println("\n\n********************************* Testing Customer *********************************");
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        System.out.println("\nfindCustomerById(5):");
        System.out.println(customerService.findCustomerById(5));
        System.out.println("\nfindCustomerById(78):");
        System.out.println(customerService.findCustomerById(78));
        System.out.println("\ncountAllCustomers():");
        System.out.println(customerService.countAllCustomers());
        System.out.println("\nshowAllCustomers():");
        customerService.showAllCustomers();
        System.out.println("\ndeleteCustomerById(55) and showAllCustomers():");
        customerService.deleteCustomerById(55); customerService.showAllCustomers();
        System.out.println("\naddCustomer(...) and showAllCustomers():");
        customerService.addCustomer(new Customer("NewCustomer1", "Kanavinskiy",10));
        customerService.showAllCustomers();
        System.out.println("\nupdateCustomer(88, ...) and showAllCustomers():");
        customerService.updateCustomer(88, new Customer("NewCustomer2", "Leninskiy",20));
        customerService.showAllCustomers();
        System.out.println("\nupdateCustomer(21, ...) and showAllCustomers():");
        customerService.updateCustomer(21, new Customer("NewCustomer2", "Leninskiy",20));
        customerService.showAllCustomers();
        System.out.println("\ndeleteCustomerById(95) and showAllCustomers():");
        customerService.deleteCustomerById(95);
        System.out.println("\ndeleteCustomerById(21) and showAllCustomers():");
        customerService.deleteCustomerById(21);
        customerService.showAllCustomers();
        System.out.println("\ndeleteCustomerById(10) and showAllCustomers():");
        customerService.deleteCustomerById(10);
        customerService.showAllCustomers();

        customerService.closeSessionFactory();

    }

}