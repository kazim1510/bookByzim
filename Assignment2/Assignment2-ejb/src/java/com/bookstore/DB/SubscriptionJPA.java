/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Subscription;
import javax.ejb.Stateless;
import javax.persistence.*;


/**
 *
 * @author HP
 */
@Stateless
public class SubscriptionJPA implements SubscriptionDAO{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Subscription get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Subscription subscription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
