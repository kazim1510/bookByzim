/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Subscription;
import java.io.Serializable;
import javax.ejb.Remote;

/**
 *
 * @author HP
 */
@Remote
public interface SubscriptionDAO extends Serializable{
    
    public Subscription getSub(String id);
    
    public void updateSub(Subscription sub);
    
    public void createSub(Subscription sub);
    
    public void deleteSub(Subscription sub);
    
}
