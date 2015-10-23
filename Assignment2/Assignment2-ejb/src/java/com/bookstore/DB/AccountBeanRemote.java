/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Account;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author HP
 */
@Remote
public interface AccountBeanRemote extends Serializable{
    
    public void create(Account account);
    
    public Account get(String username);
    
    public void update(Account account);
    
    public void delete(Account account);
    
    public List<Account> getList();
}
