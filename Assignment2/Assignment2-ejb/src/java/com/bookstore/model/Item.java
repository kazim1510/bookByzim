/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A model object for user Items, storing their itemId, itemName anditemDesc.
 * 
 * @author HP
 */
@Entity
public class Item implements Serializable{


    private String itemId;
    private String itemName;
  
    private String itemDescp;
    private String membership;
    private int version;
   
  
    
     public Item(String itemId, String itemName, String itemDescp, String membership) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescp = itemDescp;
        this.membership = membership;
    }

     public Item() {
    }
     
    @Id
    @GeneratedValue
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

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
}
