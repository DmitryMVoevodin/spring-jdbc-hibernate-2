package com.netcracker.spring.service.purchase;

import com.netcracker.spring.entity.Purchase;

import java.util.List;

public interface PurchaseServiceInterface {

    void deletePurchaseById(int id);

    void updatePurchase(int id, Purchase purchase);

    void addPurchase(Purchase purchase);

    Purchase findPurchaseById(int id);

    List<Purchase> findAllPurchases();

    int countAllPurchases();

    void closeSessionFactory();

    void showAllPurchases();

}