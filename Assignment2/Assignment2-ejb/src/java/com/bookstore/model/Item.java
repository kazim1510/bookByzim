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


    private String itemId;
    private String itemName;
    private String itemDescp;
    
    private Membership subscription;
    
     public Item(String itemId, String itemName, String itemDescp, Membership subscription) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescp = itemDescp;
        this.subscription = subscription;
    }

     public Item() {
    }
     
    @Id
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
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

@ManyToOne
    public Membership getSubscription() {
        return subscription;
    }

    public void setSubscription(Membership subscription) {
        this.subscription = subscription;
    }
}
