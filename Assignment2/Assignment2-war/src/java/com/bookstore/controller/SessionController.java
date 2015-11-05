/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.model.Account;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 * This backing bean remembers the details of the currently logged in user
 * and is session-scoped.
 * getAccount() should return null if and only if no user is currently
 * logged into this session.
 * 
 * @author kazim and bipin
 */

@Named
@SessionScoped
public class SessionController implements Serializable{

    /**
     * The current account
     */
    Account account = new Account();
    /**
     * Get the current value of the Account.
     * @return the current Account of the user 
     */
    public Account getAccount(){
        return account;
    }
    /**
     * Set the value of the Account.
     * @param account
     */
    public void setAccount(Account account) {
        this.account = account;
    }  
}
