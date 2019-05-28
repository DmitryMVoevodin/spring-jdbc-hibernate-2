package com.netcracker.spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Data //Get() and Set() are realized notwithstanding the fact that we have lombok
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "book_price", nullable = false)
    private double bookPrice;

    @Column(name = "book_inhabitation", nullable = false)
    private String bookInhabitation;

    @Column(name = "book_count", nullable = false)
    private int bookCount;

    @OneToMany(targetEntity = Purchase.class, mappedBy = "book" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Purchase> purchases;

    public Book() {
        //
    }

    public Book(String bookTitle, double bookPrice, String bookInhabitation, int bookCount) {
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.bookInhabitation = bookInhabitation;
        this.bookCount = bookCount;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public String getBookInhabitation() {
        return bookInhabitation;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookInhabitation(String bookInhabitation) {
        this.bookInhabitation = bookInhabitation;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return ("Book [id=" + bookId + "; title=" + bookTitle + "; price=" + bookPrice +
                "; storage=" + bookInhabitation + "; count=" + bookCount + "]");
    }
}