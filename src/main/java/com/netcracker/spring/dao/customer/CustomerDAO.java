package com.netcracker.spring.dao.customer;

import com.netcracker.spring.dao.BaseDAO;
import com.netcracker.spring.entity.Customer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDAO")
@Transactional
public class CustomerDAO extends BaseDAO implements CustomerDAOInterface {

    public void deleteCustomerById(int id) {
        Query query = getSession().createSQLQuery("DELETE FROM customers WHERE customer_id = " + id);
        query.executeUpdate();
    }

    public void updateCustomer(int id, Customer customer) {
        Customer c = null;
        customer.setCustomerId(id);
        try{
            String sql = "SELECT * FROM customers WHERE customer_id = " + customer.getCustomerId();
            Query query = getSession().createNativeQuery(sql).addEntity(Customer.class);
            c = (Customer) query.getSingleResult();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        if (c != null) {
            merge(customer);
        }
    }

    public void addCustomer(Customer customer) {
        persist(customer);
    }

    public Customer findCustomerById(int id) {
        Customer customer = null;
        try{
            String sql = "SELECT * FROM customers WHERE customer_id = " + id;
            Query query = getSession().createNativeQuery(sql).addEntity(Customer.class);
            customer = (Customer) query.getSingleResult();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        return customer;
    }

    public List<Customer> findAllCustomers() {
        List<Customer> listCustomer = null;
        try{
            String sql = "SELECT * FROM customers";
            Query query = getSession().createNativeQuery(sql).addEntity(Customer.class);
            listCustomer = query.list();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        return listCustomer;
    }

    public int countAllCustomers() {
        List<Customer> listCustomer = findAllCustomers();
        if (listCustomer == null) {
            return 0;
        } else {
            return listCustomer.size();
        }
    }

    public void closeSessionFactory() {
        super.closeSessionFactory();
    }

}