/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Subscription;
import javax.ejb.*;
import javax.persistence.*;


/**
 *
 * @author HP
 */
@Stateless
public class SubscriptionJPABean implements SubscriptionBeanRemote{
     
    @PersistenceContext
    private EntityManager em;

    @Override
    public Subscription getSub(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSub(Subscription sub) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createSub(Subscription sub) {
            
        em.persist(sub.getAccount());
        
        em.persist(sub.getMembership());
        

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteSub(Subscription sub) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
