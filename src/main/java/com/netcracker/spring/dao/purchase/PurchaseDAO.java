package com.netcracker.spring.dao.purchase;

import com.netcracker.spring.dao.BaseDAO;
import com.netcracker.spring.entity.Purchase;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository("purchaseDAO")
@Transactional
public class PurchaseDAO extends BaseDAO implements PurchaseDAOInterface {

    public void deletePurchaseById(int id) {
        Query query = getSession().createSQLQuery("DELETE FROM purchases WHERE pur_id = " + id);
        query.executeUpdate();
    }

    public void updatePurchase(int id, Purchase purchase) {
        Purchase p = null;
        purchase.setPurId(id);
        try{
            String sql = "SELECT * FROM purchases WHERE pur_id = " + purchase.getPurId();
            Query query = getSession().createNativeQuery(sql).addEntity(Purchase.class);
            p = (Purchase) query.getSingleResult();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        if (p != null) {
            merge(purchase);
        }
    }

    public void addPurchase(Purchase purchase) {
        persist(purchase);
    }

    public Purchase findPurchaseById(int id) {
        Purchase purchase = null;
        try{
            String sql = "SELECT * FROM purchases WHERE pur_id = " + id;
            Query query = getSession().createNativeQuery(sql).addEntity(Purchase.class);
            purchase = (Purchase) query.getSingleResult();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        return purchase;
    }

    public List<Purchase> findAllPurchases() {
        List<Purchase> listPurchase = null;
        try{
            String sql = "SELECT * FROM purchases";
            Query query = getSession().createNativeQuery(sql).addEntity(Purchase.class);
            listPurchase = query.list();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        return listPurchase;
    }

    public int countAllPurchases() {
        List<Purchase> listPurchase = findAllPurchases();
        if (listPurchase == null) {
            return 0;
        } else {
            return listPurchase.size();
        }
    }

    public void closeSessionFactory() {
        super.closeSessionFactory();
    }

}