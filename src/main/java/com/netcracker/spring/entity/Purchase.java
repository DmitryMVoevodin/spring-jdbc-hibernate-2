package com.netcracker.spring.entity;

import com.netcracker.spring.service.book.BookService;
import com.netcracker.spring.service.customer.CustomerService;
import com.netcracker.spring.service.shop.ShopService;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "purchases")
@Data //Get() and Set() are realized notwithstanding the fact that we have lombok
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pur_id")
    private int purId;

    @Column(name = "pur_date")
    private Date purDate;

    @ManyToOne
    @JoinColumn(name = "pur_seller")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "pur_buyer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "pur_book")
    private Book book;

    @Column(name = "pur_count")
    private int purCount;

    @Column(name = "pur_sum")
    private double purSum;

    public Purchase() {
        //
    }

    public Purchase(Date purDate, Shop shop, Customer customer, Book book, int purCount) {
        this.purDate = purDate;
        this.shop = shop;
        this.customer = customer;
        this.book = book;
        this.purCount = purCount; if(this.purCount < 0) this.purCount = 0;
        if(this.book != null) {
            this.purSum = this.purCount * this.book.getBookPrice();
        } else {
            this.purSum = 0;
        }

    }

    public int getPurId() {
        return purId;
    }

    public Date getPurDate() {
        return purDate;
    }

    public Shop getShop() {
        return shop;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public int getPurCount() {
        return purCount;
    }

    public double getPurSum() {
        return purSum;
    }

    public void setPurId(int purId) {
        this.purId = purId;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBook(Book book) {
        this.book = book;
        this.purSum = this.book.getBookPrice() * this.purCount;
    }

    public void setPurCount(int purCount) {
        this.purCount = purCount;
        this.purSum = this.book.getBookPrice() * this.purCount;
    }

    public void setPurSum(double purSum) {
        this.purSum = purSum;
    }

    @Override
    public String toString() {
        return ("Purchase {id=" + purId + "; date=" + purDate + "; " +
                shop.getShopId() + "; " + customer.getCustomerId() + "; " + book.getBookId() +
                "; count=" + purCount + "; sum=" + purSum + "}");
    }

}
