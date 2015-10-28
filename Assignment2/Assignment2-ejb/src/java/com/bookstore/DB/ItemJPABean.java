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
 *
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
        String queryStr = "SELECT item FROM  Item item WHERE item.membership = :type";
        TypedQuery<Item> query = em.createQuery(queryStr, Item.class);
        query.setParameter("type", type);
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
