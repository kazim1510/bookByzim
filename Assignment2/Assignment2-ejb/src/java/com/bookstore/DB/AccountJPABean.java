/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.DB;

import com.bookstore.model.Account;
import com.bookstore.utility.DateUtil;
import com.bookstore.utility.Sha;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;


import javax.persistence.*;

/**
 * Implementation of Account bean
 * @author HP
 */
@Default
@Stateless
public class AccountJPABean implements AccountBeanRemote{

    @PersistenceContext
    private EntityManager em;
    
     @Override
    public int getisLoginvalue(String id) {
       return em.find(Account.class, id).getIsLogin();
    }
    
    @Override
    public void create(Account account) {
        try {
            account.setPassword(Sha.hash256(account.getPassword()));   
            account.setStartdate(new Date());
            Date enddate = DateUtil.addMonths(account.getStartdate(), account.getSubmonth());
            account.setStartdate(new Date());
            account.setEnddate(enddate);
            account.setGroupname("Users");
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
        catch(Exception e){
            System.out.println("Error");
            return null;
        }
    }

    @Override
    public Account update(Account account) {
        String type = account.getSubscription();
        int month= account.getSubmonth();
        account = get(account.getUsername());
        account.setSubscription(type);
        account.setSubmonth(month);
        account.setStartdate(new Date());
        Date enddate = DateUtil.addMonths(account.getStartdate(), account.getSubmonth());
        account.setEnddate(enddate);
        em.merge(account);
        em.flush();
        return account;
    }
      @Override
    public void updatePassword(Account account,String password) {
        account = get(account.getUsername());
        try {
            account.setPassword(Sha.hash256(password));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountJPABean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public void updateLogin(Account account) {
        int isLogin = account.getIsLogin();
        account = get(account.getUsername());
        account.setIsLogin(isLogin);
    } 
    @Override
    public void delete(Account account) {
        account = get(account.getUsername());
        em.remove(account);
        em.flush();
    }

    @Override
    public List<Account> getList() {
        String queryStr = "SELECT account FROM Account account";
        TypedQuery<Account> query = em.createQuery(queryStr, Account.class);
        return query.getResultList();
    }
}
