/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author HP
 */
@Entity
public class Item implements Serializable{

    private int itemId;
    private String itemName;
    private String itemDescp;
    
    @ManyToOne
    private Subscription subscription;
    
    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescp() {
        return itemDescp;
    }

    public void setItemDescp(String itemDescp) {
        this.itemDescp = itemDescp;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
