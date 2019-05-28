package com.netcracker.spring.service.shop;

import com.netcracker.spring.entity.Shop;

import java.util.List;

public interface ShopServiceInterface {

    void deleteShopById(int id);

    void updateShop(int id, Shop shop);

    void addShop(Shop shop);

    Shop findShopById(int id);

    List<Shop> findAllShops();

    int countAllShops();

    void closeSessionFactory();

    void showAllShops();

}