/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Item;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.*;


/**
 * Implementation of ItemBean interface.
 * @author HP
 */
@Default
@Stateless
public class ItemJPABean implements ItemBeanRemote{
    
    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private AccountBeanRemote accountBeanRemote;
   
    @Override
    public void create(Item item) {
        em.persist(item);
        em.flush();
    }

    @Override
    public Item getItem(String id) {
       return em.find(Item.class, id);
    }
    
    

    @Override
    public List<Item> getList(String Username) {
        String type = accountBeanRemote.get(Username).getSubscription();
        String queryStr="";
        String type1= "free",type2 = "standard",type3 ="premium";
        TypedQuery<Item> query =null;
        
        
        if(type.equals("free")) {queryStr = "SELECT item FROM  Item item WHERE item.membership = :type1";
            query = em.createQuery(queryStr, Item.class);
            query.setParameter("type1", type1);
        }
        
        
        if (type.equals("standard")){   
            queryStr = "SELECT item FROM  Item item WHERE item.membership = :type1 or item.membership = :type2";
            query = em.createQuery(queryStr, Item.class);
            query.setParameter("type1", type1);
            query.setParameter("type2", type2);
        }
         if (type.equals("premium")){   
            queryStr = "SELECT item FROM  Item item WHERE item.membership = :type1 or item.membership = :type2 or item.membership=:type3";
            query = em.createQuery(queryStr, Item.class);
            query.setParameter("type1", type1);
            query.setParameter("type2", type2);
            query.setParameter("type3", type3);
        }
        
        
        return query.getResultList();
    }

    @Override
    public Item updateItem(Item item) {
        Item item1;
        item1 = getItem(item.getItemId());
        item1.setItemName(item.getItemName());
        item1.setItemDescp(item.getItemDescp());
        item1.setMembership(item.getMembership());
        //em.merge(item);
        //em.flush();
        return item1;
    }

    @Override
    public void delete(String itemId) {
        Item item = getItem(itemId);
        em.remove(item);
        em.flush();
    }

    
    @Override
    public List<Item> getAllList() {
        String queryStr = "SELECT item FROM Item item";
        TypedQuery<Item> query = em.createQuery(queryStr, Item.class);
        return query.getResultList();
    }
}
