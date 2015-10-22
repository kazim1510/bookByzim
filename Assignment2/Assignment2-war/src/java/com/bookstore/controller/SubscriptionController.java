/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.SubscriptionBeanRemote;
import com.bookstore.model.Subscription;
import javax.ejb.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 11822095
 */
@Named
@RequestScoped
public class SubscriptionController {
    
    @EJB
    private SubscriptionBeanRemote subscriptionreRemote;
    
    Subscription subscription = new Subscription();

    public Subscription getSubscription() {
        return subscription;
    }
    
    public String signupUser(){
        subscriptionreRemote.createSub(subscription);
        return "welcome?faces-redirect=true";
    }
}
