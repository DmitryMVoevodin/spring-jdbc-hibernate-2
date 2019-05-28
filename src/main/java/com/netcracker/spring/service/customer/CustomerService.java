package com.netcracker.spring.service.customer;

import com.netcracker.spring.dao.customer.CustomerDAOInterface;
import com.netcracker.spring.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerDAOInterface customerDAOInterface;

    public void deleteCustomerById(int id) {
        customerDAOInterface.deleteCustomerById(id);
    }

    public void updateCustomer(int id, Customer customer) {
        customerDAOInterface.updateCustomer(id, customer);
    }

    public void addCustomer(Customer customer) {
        customerDAOInterface.addCustomer(customer);
    }

    public Customer findCustomerById(int id) {
        return customerDAOInterface.findCustomerById(id);
    }

    public List<Customer> findAllCustomers() {
        return customerDAOInterface.findAllCustomers();
    }

    public int countAllCustomers() {
        return customerDAOInterface.countAllCustomers();
    }

    public void closeSessionFactory() { customerDAOInterface.closeSessionFactory(); }

    public void showAllCustomers() {
        List<Customer> listCustomer = findAllCustomers();
        if(listCustomer != null) {
            for(Customer cs : listCustomer) {
                System.out.println(cs);
            }
        }
    }
}