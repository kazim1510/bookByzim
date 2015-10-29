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
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
        //item.setMembership(membershipBeanRemote.get(item.getMembership().getSubsId()));
        
        em.persist(item);
        em.flush();
    }

    @Override
    public Item get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void update(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
