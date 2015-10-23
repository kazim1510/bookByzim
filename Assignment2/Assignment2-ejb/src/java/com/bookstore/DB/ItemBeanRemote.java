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
 *
 * @author HP
 */
@Remote
public interface ItemBeanRemote extends Serializable{
    
    public void create(Item item);
    
    public Item get(int id);
    
    public List<Item> getList(String username);
    
    public void update(Item item);
    
    public void delete(Item item);
  
    
}
