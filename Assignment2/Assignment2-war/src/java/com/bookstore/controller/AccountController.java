/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.AccountDAO;
import com.bookstore.model.Account;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author HP
 */

@Named
@RequestScoped
public class AccountController implements Serializable{
    
    @EJB
    private AccountDAO accountdao;
    
    Account account = new Account();
    
    public Account getAccount(){
        return account;
    }
    
    public String login(SessionController sessionContrller){
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            getRequest().login(account.getUsername(), account.getPassword());
            sessionContrller.setAccount(accountdao.get(account.getUsername()));
            return "welcome";
        }
        catch(Exception e)
        {
            context.addMessage(null, new FacesMessage("Invalid username or password"));
            return null;
        }
    }
    
    private static HttpServletRequest getRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest)context.getExternalContext().getRequest();
    }
    
}
