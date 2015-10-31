/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Item;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * ItemBean interface for CRUD access for item.
 * @author HP
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
     * get item list for Item.
     * @param username.
     * @return list of item.
     */
    public List<Item> getList(String username);
   
     /**
     * delete item.
     * @param itemId
     */
    
    public void delete(String itemId);
     /**
     * Retrieve a list of Items.
     * @return the list of items
     */
    public List<Item> getAllList();
      /**
     * update item.
     * @param item
     * @return item
     */
    public Item updateItem(Item item);
}
