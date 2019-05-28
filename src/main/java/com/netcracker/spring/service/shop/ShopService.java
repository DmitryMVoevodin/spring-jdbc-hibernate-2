package com.netcracker.spring.service.shop;

import com.netcracker.spring.dao.shop.ShopDAOInterface;
import com.netcracker.spring.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopService")
public class ShopService implements ShopServiceInterface {

    @Autowired
    private ShopDAOInterface shopDAOInterface;

    public void deleteShopById(int id) {
        shopDAOInterface.deleteShopById(id);
    }

    public void updateShop(int id, Shop shop) {
        shopDAOInterface.updateShop(id, shop);
    }

    public void addShop(Shop shop) {
        shopDAOInterface.addShop(shop);
    }

    public Shop findShopById(int id) {
        return shopDAOInterface.findShopById(id);
    }

    public List<Shop> findAllShops() {
        return shopDAOInterface.findAllShops();
    }

    public int countAllShops() {
        return shopDAOInterface.countAllShops();
    }

    public void closeSessionFactory() { shopDAOInterface.closeSessionFactory(); }

    public void showAllShops() {
        List<Shop> listShop = findAllShops();
        if(listShop != null) {
            for(Shop sp : listShop) {
                System.out.println(sp);
            }
        }
    }
}