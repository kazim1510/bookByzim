/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Account;
import com.bookstore.utility.Sha;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;


import javax.persistence.*;

/**
 *
 * @author HP
 */


@Default
@Stateless
public class AccountJPABean implements AccountBeanRemote{

    @PersistenceContext
    private EntityManager em;
    

    @Override
    public void create(Account account) {
        try {
            account.setPassword(Sha.hash256(account.getPassword()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountJPABean.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.persist(account);
        em.flush();
    }

    @Override
    public Account get(String username) {
        try{
        Account account= em.find(Account.class, username);
        return account;
        }
        catch(Exception e)
        {
            System.out.println("Error");
            return null;
        }
    }

    @Override
    public void update(Account account) {
        
        String type = account.getSubscription();
        account = get(account.getUsername());
        account.setSubscription(type);
        em.merge(account);
        em.flush();
    }
    
    @Override
    public void updatePassword(Account account) {
        
        String password = account.getPassword();
        account = get(account.getUsername());
        account.setPassword(password);
        try {
            account.setPassword(Sha.hash256(account.getPassword()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountJPABean.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.merge(account);
        em.flush();
    }
    

    @Override
    public void delete(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getList() {
        String queryStr = "SELECT account FROM Account account";
        TypedQuery<Account> query = em.createQuery(queryStr, Account.class);
        return query.getResultList();
    }
}
