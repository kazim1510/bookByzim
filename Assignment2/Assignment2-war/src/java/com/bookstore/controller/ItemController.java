/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.ItemBeanRemote;
import com.bookstore.model.Item;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author HP
 */
@Named
@RequestScoped
public class ItemController implements Serializable{
    
    @EJB
    ItemBeanRemote itemremote;

    public Item getItem() {
        return item;
    }
    
    private Item item=new Item();
    
    public String createItem(){
        itemremote.create(item);
        return "/welcome?faces-redirect=true";
    }
    
    public List<Item> listItem(String username){
        return itemremote.getList(username);
    }
    
}
