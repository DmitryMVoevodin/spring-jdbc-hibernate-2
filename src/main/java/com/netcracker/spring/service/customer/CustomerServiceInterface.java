package com.netcracker.spring.service.customer;

import com.netcracker.spring.entity.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    void deleteCustomerById(int id);

    void updateCustomer(int id, Customer customer);

    void addCustomer(Customer customer);

    Customer findCustomerById(int id);

    List<Customer> findAllCustomers();

    int countAllCustomers();

    void closeSessionFactory();

    void showAllCustomers();

}