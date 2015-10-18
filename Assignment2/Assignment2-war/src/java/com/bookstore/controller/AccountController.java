/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.AccountDAO;
import com.bookstore.model.Account;
import javax.faces.context.FacesContext;
import javax.inject.*;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author HP
 */
public class AccountController {
    
    @Inject
    private AccountDAO accountdao;
    
    Account account = new Account();
    
    public Account getAccount(){
        return account;
    }
    
    public void login(SessionController sessionContrller){
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            getRequest().login(account.getUsername(), account.getPassword());
            sessionContrller.setAccount(accountdao.get(account.getUsername()));
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
    
    private static HttpServletRequest getRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest)context.getExternalContext().getRequest();
    }
    
}
