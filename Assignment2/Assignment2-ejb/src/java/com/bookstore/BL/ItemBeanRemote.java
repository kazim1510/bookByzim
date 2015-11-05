/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.BL;

import com.bookstore.model.Item;
import com.bookstore.utility.ConcurrentChangeDetected;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * ItemBean interface for CRUD access for item.
 * @author kazim and bipin
 */
@Remote
public interface ItemBeanRemote extends Serializable{
     /**
     * create Item for user.
     * @param item
     */
    public void create(Item item);
    /**
     * get item for ItemId.
     * @param id.
     * @return item.
     */
    public Item getItem(String id);
     /**
     * get item list for user.
     * @param username.
     * @return list of item for user.
     */
    public List<Item> getList(String username);
    /**
     * delete item.
     * @param itemId
     */
   public void delete(String itemId);
     /**
     * Retrieve a list of all Items.
     * @return the list of all items
     */
    public List<Item> getAllList();
     /**
     * Updates the item currently based on version property.
     * @param item 
     * @return the updated item.
     * @throws ConcurrentChangeDetected if the item has been concurrently updated.
     */
    public Item updateItem(Item item) throws ConcurrentChangeDetected;
}
