/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.webservice;

import com.bookstore.DB.AccountBeanRemote;
import com.bookstore.model.Account;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author bipinpatel
 * A JAX-RS Resource that provides a expose list of all user service
 */

@Path("listuser")
public class Listuser {
    @EJB
    private AccountBeanRemote accountBeanRemote;
    @GET
    public List<Account> listUser(){
        return accountBeanRemote.getList();
    }
    
}
