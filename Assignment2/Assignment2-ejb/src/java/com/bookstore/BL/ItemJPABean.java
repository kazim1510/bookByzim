/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.BL;

import com.bookstore.model.Item;
import com.bookstore.utility.ConcurrentChangeDetected;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.*;

/**
 * Implementation of ItemBean interface.
 * @author kazim and bipin
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
    public Item updateItem(Item item) throws ConcurrentChangeDetected{
        try{
            Item item1;
            item1= em.merge(item);
            em.flush();
            return item1;
        }
        catch(OptimisticLockException e)
        {
            throw new ConcurrentChangeDetected();
        }
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
