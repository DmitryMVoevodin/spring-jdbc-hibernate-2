package com.netcracker.spring.service.purchase;

import com.netcracker.spring.dao.purchase.PurchaseDAOInterface;
import com.netcracker.spring.entity.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purchaseService")
public class PurchaseService implements PurchaseServiceInterface {

    @Autowired
    private PurchaseDAOInterface purchaseDAOInterface;

    public void deletePurchaseById(int id) {
        purchaseDAOInterface.deletePurchaseById(id);
    }

    public void updatePurchase(int id, Purchase purchase) {
        purchaseDAOInterface.updatePurchase(id, purchase);
    }

    public void addPurchase(Purchase purchase) {
        purchaseDAOInterface.addPurchase(purchase);
    }

    public Purchase findPurchaseById(int id) {
        return purchaseDAOInterface.findPurchaseById(id);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseDAOInterface.findAllPurchases();
    }

    public int countAllPurchases() {
        return purchaseDAOInterface.countAllPurchases();
    }

    public void closeSessionFactory() { purchaseDAOInterface.closeSessionFactory(); }

    public void showAllPurchases() {
        List<Purchase> listPurchase = findAllPurchases();
        if(listPurchase != null) {
            for(Purchase pc : listPurchase) {
                System.out.println(pc);
            }
        }
    }
}