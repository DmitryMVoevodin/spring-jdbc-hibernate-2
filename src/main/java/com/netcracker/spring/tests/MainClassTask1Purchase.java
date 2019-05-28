package com.netcracker.spring.tests;

import com.netcracker.spring.config.SpringConfig;
import com.netcracker.spring.entity.Book;
import com.netcracker.spring.entity.Customer;
import com.netcracker.spring.entity.Purchase;
import com.netcracker.spring.entity.Shop;
import com.netcracker.spring.service.book.BookService;
import com.netcracker.spring.service.customer.CustomerService;
import com.netcracker.spring.service.purchase.PurchaseService;
import com.netcracker.spring.service.shop.ShopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.Date;

public class MainClassTask1Purchase {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Testing Book
        System.out.println("\n\n********************************* Testing Purchase *********************************");
        PurchaseService purchaseService = (PurchaseService) context.getBean("purchaseService");
        BookService bookService = (BookService) context.getBean("bookService");
        ShopService shopService = (ShopService) context.getBean("shopService");
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        System.out.println("\nfindPurchaseById(10):");
        System.out.println(purchaseService.findPurchaseById(10));
        System.out.println("\nfindPurchaseById(78):");
        System.out.println(purchaseService.findPurchaseById(78));
        System.out.println("\ncountAllPurchases():");
        System.out.println(purchaseService.countAllPurchases());
        System.out.println("\nshowAllPurchases():");
        purchaseService.showAllPurchases();
        System.out.println("\ndeletePurchaseById(55) and showAllPurchases():");
        purchaseService.deletePurchaseById(55); purchaseService.showAllPurchases();
        System.out.println("\naddPurchase(...) and showAllPurchases():");
        Shop shopNew = shopService.findShopById(4);
        Customer customerNew = customerService.findCustomerById(5);
        Book bookNew = bookService.findBookById(8);
        Book bookNew1 = bookService.findBookById(9);
        purchaseService.addPurchase(new Purchase(new Date(2019 - 1900, 4, 27), shopNew, customerNew, bookNew, 4));
        purchaseService.showAllPurchases();
        System.out.println("\nupdatePurchase(88, ...) and showAllPurchases():");
        purchaseService.updatePurchase(88, new Purchase(new Date(2019 - 1900, 2, 27), shopNew, customerNew, bookNew1, 2));
        purchaseService.showAllPurchases();
        System.out.println("\nupdatePurchase(31, ...) and showAllPurchases():");
        purchaseService.updatePurchase(31, new Purchase(new Date(2019 - 1900, 2, 27), shopNew, customerNew, bookNew1, 2));
        purchaseService.showAllPurchases();
        System.out.println("\ndeletePurchaseById(95) and showAllPurchases():");
        purchaseService.deletePurchaseById(95);
        System.out.println("\ndeletePurchaseById(31) and showAllPurchases():");
        purchaseService.deletePurchaseById(31);
        purchaseService.showAllPurchases();
        System.out.println("\ndeletePurchaseById(1) and showAllPurchases():");
        purchaseService.deletePurchaseById(1);
        purchaseService.showAllPurchases();

        purchaseService.closeSessionFactory();

    }

}