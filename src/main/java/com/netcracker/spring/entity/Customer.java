package com.netcracker.spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Data //Get() and Set() are realized notwithstanding the fact that we have lombok
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_secondname", nullable = false)
    private String customerSecondName;

    @Column(name = "customer_inhabitation", nullable = false)
    private String customerInhabitation;

    @Column(name = "customer_discount", nullable = false)
    private double customerDiscount;

    @OneToMany(targetEntity = Purchase.class, mappedBy = "customer" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Purchase> purchases;

    public Customer() {
        //
    }

    public Customer(String customerSecondName, String customerInhabitation, double customerDiscount) {
        this.customerSecondName = customerSecondName;
        this.customerInhabitation = customerInhabitation;
        this.customerDiscount = customerDiscount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerSecondName() {
        return customerSecondName;
    }

    public String getCustomerInhabitation() {
        return customerInhabitation;
    }

    public double getCustomerDiscount() {
        return customerDiscount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerSecondName(String customerSecondName) {
        this.customerSecondName = customerSecondName;
    }

    public void setCustomerInhabitation(String customerInhabitation) {
        this.customerInhabitation = customerInhabitation;
    }

    public void setCustomerDiscount(double customerDiscount) {
        this.customerDiscount = customerDiscount;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return ("Customer [id=" + customerId + "; name=" + customerSecondName +
                "; inhabitation=" + customerInhabitation + "; discount=" + customerDiscount + "]");
    }

}