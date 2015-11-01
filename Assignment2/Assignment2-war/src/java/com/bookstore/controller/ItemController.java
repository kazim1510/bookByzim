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
 * This backing bean manages request for upload new book and get list of books.
 *  and Delete books
 * @author kazim
 */
@Named
@RequestScoped
public class ItemController implements Serializable{
    
    @EJB
    ItemBeanRemote itemremote;

    public Item getItem() {
        return item;
    }
     public void setItem(Item item) {
        this.item = item;
    }
    
    private Item item=new Item();
    /**
     * Methode for upload new book.
     * @return
     * 
     */
    public String createItem(){
      
      item.setItemId(null);
      itemremote.create(item);
      return "/Admin/listitem?faces-redirect=true";
        
    }
    /**
     * get the list of books.
     * @return list of books.
     * 
     */
    public List<Item> listItem(String username){
        return itemremote.getList(username);
    }
    /**
     * get the list of Item.
     * @return list of items.
     * 
     */
    public List<Item> listAll(){
        return itemremote.getAllList();
    }
    
    /**
     * Delete Item.
     * @param itemId
     * @return
     */
    public String deleteItem(String itemId)
    {
        itemremote.delete(itemId);
        return "/Admin/listitem?faces-redirect=true";
    }
     /**
     * Update Item.
     * @param item
     * @return
     */
    public String updateItem(Item item)
    {
        Item item1= itemremote.updateItem(item);
        this.setItem(item1);
        return "/Admin/listitem?faces-redirect=true";
    }
    
    
    
}
