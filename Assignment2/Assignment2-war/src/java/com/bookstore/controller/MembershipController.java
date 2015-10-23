/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.controller;

import com.bookstore.DB.MembershipBeanRemote;
import com.bookstore.model.Membership;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author HP
 */

@Named
@RequestScoped
public class MembershipController implements Serializable{
     @EJB
      MembershipBeanRemote membershipBeanRemote;
  public void loadData(){
      membershipBeanRemote.loadData();
  }
}
