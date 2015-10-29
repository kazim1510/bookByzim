/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.webservice;

import com.bookstore.DB.AccountBeanRemote;
import com.bookstore.DB.ItemBeanRemote;
import com.bookstore.model.Account;
import com.bookstore.model.Item;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author HP
 */
@Path("listitem")
public class ListItem {
     @EJB
    private ItemBeanRemote itemBeanRemote;
    @GET
    public List<Item> listItem(){
        return itemBeanRemote.getAllList();
    }
}
