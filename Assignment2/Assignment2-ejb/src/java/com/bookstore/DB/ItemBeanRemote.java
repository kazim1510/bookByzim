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
     
    public Item get(int id);
     /**
     * get item list for user.
     * @param username.
     * @return list of item.
     */
    public List<Item> getList(String username);
    
    public void update(Item item);
    
    public void delete(Item item);
  
    
}
