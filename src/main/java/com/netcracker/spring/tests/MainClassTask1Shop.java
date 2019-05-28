package com.netcracker.spring.tests;

import com.netcracker.spring.config.SpringConfig;
import com.netcracker.spring.entity.Shop;
import com.netcracker.spring.service.shop.ShopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClassTask1Shop {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        //Testing Shop
        System.out.println("\n\n********************************* Testing Shop *********************************");
        ShopService shopService = (ShopService) context.getBean("shopService");
        System.out.println("\nfindShopById(3):");
        System.out.println(shopService.findShopById(3));
        System.out.println("\nfindShopById(78):");
        System.out.println(shopService.findShopById(78));
        System.out.println("\ncountAllShops():");
        System.out.println(shopService.countAllShops());
        System.out.println("\ncountAllShops():");
        shopService.showAllShops();
        System.out.println("\ndeleteShopById(55) and showAllShops():");
        shopService.deleteShopById(55); shopService.showAllShops();
        System.out.println("\naddShop(...) and showAllShops():");
        shopService.addShop(new Shop("NewShop1", "Kanavinskiy",10));
        shopService.showAllShops();
        System.out.println("\nupdateShop(88, ...) and showAllShops():");
        shopService.updateShop(88, new Shop("NewShop2", "Leninskiy",20));
        shopService.showAllShops();
        System.out.println("\nupdateShop(21, ...) and showAllShops():");
        shopService.updateShop(11, new Shop("NewShop2", "Leninskiy",20));
        shopService.showAllShops();
        System.out.println("\ndeleteShopById(95) and showAllShops():");
        shopService.deleteShopById(95);
        System.out.println("\ndeleteShopById(11) and showAllShops():");
        shopService.deleteShopById(11);
        shopService.showAllShops();
        System.out.println("\ndeleteCustomerById(2) and showAllCustomers():");
        shopService.deleteShopById(2);
        shopService.showAllShops();

        shopService.closeSessionFactory();

    }

}