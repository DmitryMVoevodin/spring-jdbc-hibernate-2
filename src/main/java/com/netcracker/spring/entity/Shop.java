package com.netcracker.spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shops")
@Data //Get() and Set() are realized notwithstanding the fact that we have lombok
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int shopId;

    @Column(name = "shop_title", nullable = false)
    private String shopTitle;

    @Column(name = "shop_inhabitation", nullable = false)
    private String shopInhabitation;

    @Column(name = "shop_commission", nullable = false)
    private double shopCommission;

    @OneToMany(targetEntity = Purchase.class, mappedBy = "shop" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Purchase> purchases;

    public Shop() {
        //
    }

    public Shop(String shopTitle, String shopInhabitation, double shopCommission) {
        this.shopTitle = shopTitle;
        this.shopInhabitation = shopInhabitation;
        this.shopCommission = shopCommission;
    }

    public int getShopId() {
        return shopId;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public String getShopInhabitation() {
        return shopInhabitation;
    }

    public double getShopCommission() {
        return shopCommission;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public void setShopInhabitation(String shopInhabitation) {
        this.shopInhabitation = shopInhabitation;
    }

    public void setShopCommission(double shopCommission) {
        this.shopCommission = shopCommission;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return ("Shop [id=" + shopId + "; title=" + shopTitle + "; address=" +
                shopInhabitation + "; commission=" + shopCommission + "]");
    }

}