/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.AccountBeanRemote;
import com.bookstore.model.Account;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * This backing bean manages login, logout, register, upgrade user, delete user
 * list user and change password.
 * @author Kazim
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

    /**
     * Logs in the user via container-managed authentication and also
     * records the currently logged in user into the given session controller.
     * @param sessionController the session controller
     * @return 
     */
    public String login(SessionController sessionController){
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        try{
            getRequest().login(account.getUsername(), account.getPassword());
             Account acc =  accountBeanRemote.get(account.getUsername());
            
            sessionController.setAccount(acc);
            if(acc.getRole().equals("user")){
                return "/Customer/welcome?faces-redirect=true";
            }
            else{
                return "/Admin/adminwelcome?faces-redirect=true";
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            context.addMessage(null, new FacesMessage("Invalid username or password"));
            return null;
        }
    }
      /**
     * Register the new user.
     * @return
     */
    public String signUpUser(){ 
        accountBeanRemote.create(account);
        return "/Login?faces-redirect=true";       
    }
     /**
     * Logs out the current user via the container and also clears the
     * current user in the given session controller.
     * 
     * @param sessionController
     * @return
     */
    public String logout(SessionController sessionController) throws ServletException{
        sessionController.setAccount(null);
        getRequest().logout();
        return "/Login?faces-redirect=true";
    }
    /**
     * Obtains the current HTTPServletRequest from the container.
     * 
     * @return the current HTTPServletRequest
     */
    private static HttpServletRequest getRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest)context.getExternalContext().getRequest();
    }
     /**
     * get the list of user.
     * @return list of registered user.
     * 
     */
    public List<Account> listUser(){
        return accountBeanRemote.getList();
    }
     /**
     * Change subscription of logged user.
     * @param sessionController
     * @return
     */
    public String upgradeUser(SessionController sessionController){
        Account account = accountBeanRemote.update(sessionController.getAccount());
        sessionController.setAccount(account);
        return "/Customer/welcome?faces-redirect=true";
    }
     /**
     * Delete account of user.
     * @param account
     * @return
     */
    public String deleteUser(Account account){
        accountBeanRemote.delete(account);
        return "/Admin/adminusers?faces-redirect=true";
    }
    /**
     * Change password of registered user.
     * @param account
     * @return
     */
    public String changePassword(Account account){
        accountBeanRemote.updatePassword(account);
        return "/Customer/welcome?faces-redirect=true";
    }   
}
