/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.AccountBeanRemote;
import com.bookstore.model.Account;
import java.io.Serializable;
import java.nio.channels.SeekableByteChannel;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author HP
 */

@Named
@RequestScoped
public class AccountController implements Serializable{
    
    @EJB
    private AccountBeanRemote accountBeanRemote;
    
    Account account = new Account();
    
    public Account getAccount(){
        return account;
    }
    
    public String login(SessionController sessionController){
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            getRequest().login(account.getUsername(), account.getPassword());
             sessionController.setAccount(account);
            return "/welcome?faces-redirect=true";
        }
        catch(Exception e)
        {
            System.out.println(e);
            context.addMessage(null, new FacesMessage("Invalid username or password"));
            return null;
        }
    }
    
    public String signUpUser(){
        accountBeanRemote.create(account);
        return "/welcome?faces-redirect=true";
    }
    
    public String logout(SessionController sessionController) throws ServletException{
        sessionController.setAccount(null);
        getRequest().logout();
        return "/Login?faces-redirect=true";
    }
    private static HttpServletRequest getRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest)context.getExternalContext().getRequest();
    }
    
}
