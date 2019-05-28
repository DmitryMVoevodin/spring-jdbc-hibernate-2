package com.netcracker.spring.dao.shop;

import com.netcracker.spring.dao.BaseDAO;
import com.netcracker.spring.entity.Shop;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository("shopDAO")
@Transactional
public class ShopDAO extends BaseDAO implements ShopDAOInterface {

    public void deleteShopById(int id) {
        Query query = getSession().createSQLQuery("DELETE FROM shops WHERE shop_id = " + id);
        query.executeUpdate();
    }

    public void updateShop(int id, Shop shop) {
        Shop s = null;
        shop.setShopId(id);
        try{
            String sql = "SELECT * FROM shops WHERE shop_id = " + shop.getShopId();
            Query query = getSession().createNativeQuery(sql).addEntity(Shop.class);
            s = (Shop) query.getSingleResult();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        if (s != null) {
            merge(shop);
        }
    }

    public void addShop(Shop shop) {
        persist(shop);
    }

    public Shop findShopById(int id) {
        Shop shop = null;
        try{
            String sql = "SELECT * FROM shops WHERE shop_id = " + id;
            Query query = getSession().createNativeQuery(sql).addEntity(Shop.class);
            shop = (Shop) query.getSingleResult();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        return shop;
    }

    public List<Shop> findAllShops() {
        List<Shop> listShop = null;
        try{
            String sql = "SELECT * FROM shops";
            Query query = getSession().createNativeQuery(sql).addEntity(Shop.class);
            listShop = query.list();
        } catch(NoResultException nr) {
            System.out.println(nr);
        }
        return listShop;
    }

    public int countAllShops() {
        List<Shop> listShop = findAllShops();
        if (listShop == null) {
            return 0;
        } else {
            return listShop.size();
        }
    }

    public void closeSessionFactory() {
        super.closeSessionFactory();
    }

}