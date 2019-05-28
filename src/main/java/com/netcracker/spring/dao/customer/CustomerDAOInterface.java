package com.netcracker.spring.dao.customer;

import com.netcracker.spring.entity.Customer;

import java.util.List;

public interface CustomerDAOInterface {

    void deleteCustomerById(int id);

    void updateCustomer(int id, Customer customer);

    void addCustomer(Customer customer);

    Customer findCustomerById(int id);

    List<Customer> findAllCustomers();

    int countAllCustomers();

    void closeSessionFactory();

}